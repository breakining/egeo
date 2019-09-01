package com.egeo.back.user.business.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;



public class CommonUtils {
	
	
	private static final String EMAIL_PATTERN = "^.+@.+\\..+$";
	
	public static boolean verifyEmail(String email) {
		return verifyRegularExpression(email, EMAIL_PATTERN);
	}
	
	private static boolean verifyRegularExpression(String email, String pattern) {
		try {
			return Pattern.compile(pattern).matcher(email).matches();
		} catch (Exception e) {
			return false;
		}
	}
	

	
	public static String getUserIp(HttpServletRequest request) {
		// 获取客户端前台IP进行解析
		String UserIp = request.getHeader("x-forwarded-for");
		if (UserIp == null || UserIp.length() == 0 || "unknown".equalsIgnoreCase(UserIp)) {
			UserIp = request.getHeader("Proxy-Client-IP");
		}
		if (UserIp == null || UserIp.length() == 0 || "unknown".equalsIgnoreCase(UserIp)) {
			UserIp = request.getHeader("WL-Proxy-Client-IP");
		}
		if (UserIp == null || UserIp.length() == 0 || "unknown".equalsIgnoreCase(UserIp)) {
			UserIp = request.getRemoteAddr();
		}
		return UserIp;
	}
	
	/**
     * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
     * @param request
     * @return ip
     */
   public static String getLocalIp(HttpServletRequest request) {
       String remoteAddr = request.getRemoteAddr();
       String forwarded = request.getHeader("X-Forwarded-For");
       String realIp = request.getHeader("X-Real-IP");
       String ip = null;
       if (realIp == null) {
           if (forwarded == null) {
               ip = remoteAddr;
           } else {
               ip = remoteAddr + "/" + forwarded.split(",")[0];
           }
       } else {
           if (realIp.equals(forwarded)) {
               ip = realIp;
           } else {
               if(forwarded != null){
                   forwarded = forwarded.split(",")[0];
               }
               ip = realIp + "/" + forwarded;
           }
       }
       return ip;
   }
	
	public static long[] stringToLong(String stringArray[]) {
        if (stringArray == null || stringArray.length < 1) {
            return null;
        }
        long longArray[] = new long[stringArray.length];
        for (int i = 0; i < longArray.length; i++) {
            try {
                longArray[i] = Long.valueOf(stringArray[i]);
            } catch (NumberFormatException e) {
                longArray[i] = 0;
                continue;
            }
        }
        return longArray;
    }
	
	 public static String getMACAddress(String ip){
         String str = "";
         String macAddress = "";
         try {
             Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
             InputStreamReader ir = new InputStreamReader(p.getInputStream());
             LineNumberReader input = new LineNumberReader(ir);
             for (int i = 1; i < 100; i++) {
                 str = input.readLine();
                 if (str != null) {
                     if (str.indexOf("MAC Address") > 1) {
                         macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                         break;
                     }
                 }
             }
         } catch (IOException e) {
             e.printStackTrace(System.out);
         }
         return macAddress;
     }
}
