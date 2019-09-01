package com.egeo.back.user.businiess.util;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.egeo.back.user.model.entity.Ticket;
import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.util.cache.JedisUtil;
import com.egeo.core.Constant.BusinessConstant;


/**
 * @author crc
 * @time 2015-5-29 下午5:04:09
 * @description <pre>
 * <p/>
 * </pre>
 */
@Service("ticketUtils")
public class TicketUtils {
	
	@Resource(name="userCache")
	private  JedisUtil cache;
	
	@Resource(name="ssoClientUtil")
	private  SsoClientUtil ssoClientUtil;
	
	public Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private  final int ut_timeout = BusinessConstant.USER_UT_TIMEOUT; // 一个月

    public  UserCookieVO generateTicket(CacheUser userCache, HttpServletRequest req, HttpServletResponse resp) {

    	try {
            String ut = UUID.randomUUID().toString().replace("-", "");
           
            if(null!=req&&null!=resp){

            	String domain=req.getServerName();//获得网站域名
                Cookie cookie = new Cookie("ut", ut);
                cookie.setDomain(domain);  //请用自己的域
                if (userCache.isAutoLogin()) {//自动登录cookie保存一天,否则关闭浏览器,cookie失效
                    cookie.setMaxAge((int) (24 * 60 * 60)); //关闭浏览器后，cookie立即失效
                }
                cookie.setPath("/");              
                resp.addCookie(cookie);
/*                Cookie[] cookies = req.getCookies();
                if (null==cookies) {
                    System.out.println("没有cookie=========");
                } else {
                    for(Cookie cooki : cookies){
                        System.out.println("name:"+cooki.getName()+",value:"+ cooki.getValue());
                    }
                }*/
             }
            /*cookie.setPath("/");
            resp.addCookie(cookie);*/
            Ticket t = new Ticket();
            t.setTime(new Date().getTime());
            t.setUser(userCache);
            cache.set(ut, ut_timeout, t);
            UserCookieVO userCookie = new UserCookieVO();
            userCookie.setUserId(userCache.getId());
            userCookie.setType(1);
            userCookie.setCookieName("ut");
            userCookie.setCookieValue(ut);
            userCookie.setDomain(ssoClientUtil.getDomain());
            return userCookie;
        } catch (Exception e) {
        	
        	throw e;
        }
    }


  

    public  boolean deleteTicket(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String ut = getUT(req);
            if (StringUtils.isBlank(ut)) {
                return true;
            }
            StringBuilder cookieBuffer = new StringBuilder();
            cookieBuffer.append(ssoClientUtil.getCookieName()).append("=").append(";Path=/;Domain=").append(ssoClientUtil.getDomain()).append(";Max-Age=0;HTTPOnly");
            resp.setHeader("Set-Cookie", cookieBuffer.toString());
            return true;
        } catch (Exception e) {
        	throw e;
        }
    }

    public  String getUT(HttpServletRequest req) {
        String ut = null;
        ut = req.getParameter("ut");
        if (StringUtils.isNotBlank(ut)) {
            ut = ut.trim();
            ut = ut.toLowerCase();
            ut = ut.replaceAll(" ", "");
            ut = ut.replaceAll("\t", "");
            ut = ut.replaceAll("\r", "");
            ut = ut.replaceAll("\n", "");
            return ut;
        }
        Cookie[] cookies = req.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            return "";
        }
        for (int i = 0; i < cookies.length; i++) {
            if (ssoClientUtil.getCookieName().equalsIgnoreCase(cookies[i].getName())) {
                ut = cookies[i].getValue();
                break;
            }
        }
        if (StringUtils.isBlank(ut)) {
            return "";
        }
        return ut;
    }

    public  CacheUser getUser(String ut) {


    	
    	try {
            if (StringUtils.isBlank(ut)) {
                return null;
            }

            Ticket t = (Ticket) cache.get(ut);

            if (t == null) {
                return null;
            }
            long last = t.getTime();
			long now = new Date().getTime();
			// 时间计算错误, 乘法优于除法.
			long remain = ut_timeout - (now - last); // 缓存剩余分钟数
			if (remain <= 0) {
                return null;
			}
			if (remain < 600000) {
				t.setTime(now);
				cache.set(ut, ut_timeout, t);
			}
            return t.getUser();
        } catch (Exception e) {
        	throw e;
        }

    }

        @SuppressWarnings("unused")
    public  CacheUser getUser(HttpServletRequest req, HttpServletResponse resp) {
       
        try {
            String ut = getUT(req);
            return getUser(ut);
        } catch (Exception e) {
        	throw e;
        }
    }

    public  boolean generateTicket(CacheUser userCache,  String ut) {
        Ticket t = new Ticket();
        t.setTime(new Date().getTime());
        t.setUser(userCache);

        cache.set(ut, ut_timeout, t);
        return true;
    }

    public  String getUt(HttpServletRequest req) {
        String ut = getUT(req);
        return ut;
    }

    public  boolean deleteCookie(String ut) {
    	cache.del(ut);
        return true;
    }


}   