package com.egeo.back.user.businiess.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.core.Constant.CacheKeyConstant;
import com.egeo.util.cache.JedisUtil;



/**
 * @author crc
 * @time 2015-5-29 下午5:06:04
 * @description <pre>
 * <p/>
 * </pre>
 */
@Service("ssoClientUtil")
public class SsoClientUtil {

    private  final Log logger = LogFactory.getLog(SsoClientUtil.class);

    private  CacheUser testUser;
    
    private  String domain;

    private  String cookieName;

    private  boolean init = false;
    
	@Resource(name="userCache")
	private JedisUtil cache;   
	
	@Resource(name="ticketUtils")
	private TicketUtils TicketUtils;  

    private  void init() {
/*    	String path = System.getProperty("global.config.path")+"/back-user/back-user-business/redis.properties";
    	if(!JedisUtil.isInit()){
    		JedisUtil.setCONFIGFILE(path);
    	}*/
    	String path = System.getProperty("global.config.path")+"/back-user/back-user-business/client.properties";
    	
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(path));
            Properties properties = new Properties();
            properties.load(is);
            domain = properties.get("domain").toString();
            cookieName = properties.get("cookieName").toString();
        } catch (Exception e) {
            throw new RuntimeException("path "+path + " is not exist.");
        }
    	
    	init = true;
    }
     


    public  String getDomain() {
        return domain;
    }

    public  String getCookieName() {
        return cookieName;
    }

    public  CacheUser getUser(HttpServletRequest req, HttpServletResponse resp) {
        if (init == false) {
            init();
        }
        return TicketUtils.getUser(req, resp);
    }


    public  String getUt(HttpServletRequest req) {
        if (init == false) {
            init();
        }
        return TicketUtils.getUt(req);
    }

    public  CacheUser getUser(String ut) {
        if (init == false) {
            init();
        }
        return TicketUtils.getUser(ut);
    }

    public  UserCookieVO login(CacheUser userCache, HttpServletRequest req, HttpServletResponse resp) {
        if (init == false) {
            init();
        }
        return TicketUtils.generateTicket(userCache, req, resp);
    }

    public  boolean login(CacheUser userCache, String ut) {
        if (init == false) {
            init();
        }
        return TicketUtils.generateTicket(userCache, ut);
    }

    public  boolean logout(HttpServletRequest req, HttpServletResponse resp) {
        if (init == false) {
            init();
        }
        return TicketUtils.deleteTicket(req, resp);
    }
    public  boolean logout(String ut) {
        if (init == false) {
            init();
        }
        return TicketUtils.deleteCookie(ut);
    }

    @SuppressWarnings("unchecked")
    public  String getCurrentUrl(HttpServletRequest req, HttpServletResponse resp) {
        if (init == false) {
            init();
        }
        Iterator<Map.Entry<String, Object>> it = req.getParameterMap().entrySet().iterator();
        StringBuffer params = new StringBuffer();
        while (it.hasNext()) {
            if (StringUtils.isNotBlank(params.toString())) {
                params.append("&");
            }
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            if (val instanceof String[]) {
                String[] values = (String[]) val;
                for (int i = 0; i < values.length; i++) {
                    if (i > 0) {
                        params.append("&");
                    }
                    params.append(key).append("=").append(values[i]);
                }
            } else {
                if (val != null) {
                    params.append(key).append("=").append(val.toString());
                }
            }
        }
        StringBuffer returnUrl = new StringBuffer();
        returnUrl.append(req.getRequestURL());
        if (StringUtils.isNotBlank(params.toString())) {
            returnUrl.append("?").append(params.toString());
        }
        return getEncodeUrl(returnUrl.toString(), "UTF-8");
    }

    private  String getEncodeUrl(String url, String enc) {

        try {
            return URLEncoder.encode(url, enc);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }


    public  List<String> getUrlList() {

        return  (List<String>) cache.get(CacheKeyConstant.MENU_CACHE_LIST_KEY);
    }
    

    /**
     * @param userId
     * @description <pre>
     * 从缓存中获取用户权限
     * </pre>
     */
/*    @SuppressWarnings("unchecked")
    public  Set<String> getLoginUserFunction(Long userId) {
        if (init == false) {
            init();
        }
        return (Set<String>) proxy.get(userId + "");
    }
*/}
