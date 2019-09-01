package com.egeo.back.user.web.interceptor;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.egeo.back.user.model.entity.Ticket;
import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.Constant.CacheKeyConstant;
import com.egeo.core.web.JsonResult;
import com.egeo.util.cache.JedisUtil;
import com.egeo.util.security.MD5Support;

/**
 * Created by xiaping on 17/05/12.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Resource(name = "userCache")
    private JedisUtil cache;

    public final static String LOGIN_ATTRIBUTE_NAME = "__" + LoginInterceptor.class.getName()
            + "_loginAttributeName";

    private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    private static String JSON_MEDIA_TYPE = MediaType.APPLICATION_JSON_VALUE;

    private static final String USERTOKEN = "ut";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {

            String url = request.getRequestURL().toString();

            /*
             * if (loginContext == null) { return true; }
             */
            // 从参数和cookie里取值

            String ut = request.getParameter(USERTOKEN);
            if (StringUtils.isEmpty(ut)) {
                // 在消息头里取ut
                ut = request.getHeader("ut");
            }

            if (StringUtils.isEmpty(ut)) {
                // cookie里面取ut
                Cookie[] cks = request.getCookies();
                if (cks != null) {
                    for (Cookie cookie : cks) {
                        if (USERTOKEN.equals(cookie.getName())) {
                            ut = cookie.getValue();
                            break;
                        }
                    }
                }
            }
            // cookie里面也没有
            if (StringUtils.isEmpty(ut)) {
                return handleNotLogin(request, response, url);
            }

            CacheUser userCache = null;
            try {
                userCache = getUser(ut);
            } catch (Exception e) {
                log.warn("get user error", e);
            }

            // 放到request中
            request.setAttribute(USERTOKEN, userCache);
            if (userCache == null) {
                return handleNotLogin(request, response, url);
            }

            if (handUrl(url) == false) {
                return true;
            }

            Long userId = userCache.getId();
            String localUserInfo = MD5Support.MD5(ut + userId);
            String authString = request.getHeader("authorization");
            if (handTokenPermission(authString, localUserInfo, request, response) == false) {
                return false;
            }

            if (handUrlPermission(url, userCache, request, response) == false) {
                return false;
            }

            // request.setAttribute(LOGIN_ATTRIBUTE_NAME, userCache);

        }
        return true;
    }

    private boolean handTokenPermission(String authString, String localUserInfo, HttpServletRequest request,
            HttpServletResponse response) {
        // TODO Auto-generated method stub

        if (authString.equals(localUserInfo)) {
            return true;
        }

        // 是否是ajax请求
        if (LoginContext.isAjax) {
            JsonResult<Boolean> result = new JsonResult<Boolean>();
            result.setCode(BusinessExceptionConstant.USER_NOT_PERMISSION);
            result.setError("缺少相应的权限！");
            result.setData(false);

            String resultJson = JSON.toJSONString(result);
            response.setContentType(JSON_MEDIA_TYPE);
            response.setCharacterEncoding("UTF-8");
            try {
                System.out.println(request.getRequestURI());
                response.getWriter().write(resultJson);
                response.getWriter().flush();
            } catch (IOException e) {
                log.error("write json error", e);
            }

        } else {
            // redirect
        }
        return false;
    }

    private boolean handUrl(String url) {
        // TODO Auto-generated method stub

        List<String> urlList = (List<String>) cache.get(CacheKeyConstant.MENU_CACHE_LIST_KEY);
        for (String str : urlList) {
            if (url.indexOf(str) > -1) {
                return true;
            }

        }

        return false;
    }

    private boolean handUrlPermission(String url, CacheUser userCache, HttpServletRequest request,
            HttpServletResponse response) {
        // TODO Auto-generated method stub
        List<String> urlList = userCache.getUrlPath();
        Long userId = userCache.getId();
        for (String str : urlList) {
            if (url.indexOf(str) > -1) {
                return true;
            }

        }

        // 是否是ajax请求
        if (LoginContext.isAjax) {
            JsonResult<Boolean> result = new JsonResult<Boolean>();
            result.setCode(BusinessExceptionConstant.TOKEN_NO_MATCH);
            result.setError("用户token值异常！");
            result.setData(false);

            String resultJson = JSON.toJSONString(result);
            response.setContentType(JSON_MEDIA_TYPE);
            response.setCharacterEncoding("UTF-8");
            try {
                System.out.println(request.getRequestURI());
                response.getWriter().write(resultJson);
                response.getWriter().flush();
            } catch (IOException e) {
                log.error("write json error", e);
            }

        } else {
            // redirect
        }
        return false;
    }

    boolean handleNotLogin(HttpServletRequest request, HttpServletResponse response, String url) {
        // 如果不是必须登录
        if (!LoginContext.required) {
            return true;
        }
        if (handUrl(url) == false) {
            return true;
        }
        // 是否是ajax请求
        if (LoginContext.isAjax) {
            JsonResult<Boolean> result = new JsonResult<Boolean>();
            result.setCode(BusinessExceptionConstant.USER_NOT_LOGIN);
            result.setError("未登录或已过期，请登录！");
            result.setData(false);

            String resultJson = JSON.toJSONString(result);
            response.setContentType(JSON_MEDIA_TYPE);
            response.setCharacterEncoding("UTF-8");
            try {
                System.out.println(request.getRequestURI());
                response.getWriter().write(resultJson);
                response.getWriter().flush();
            } catch (IOException e) {
                log.error("write json error", e);
            }

        } else {
            // redirect
        }
        return false;

    }

    public CacheUser getUser(String ut) {

        try {
            if (StringUtils.isBlank(ut)) {
                return null;
            }

            Ticket t = (Ticket) cache.get(ut);
            return t.getUser();
        } catch (Exception e) {
            throw e;
        }

    }

    public static void main(String[] args) {
        System.out.println(LOGIN_ATTRIBUTE_NAME);
    }

}
