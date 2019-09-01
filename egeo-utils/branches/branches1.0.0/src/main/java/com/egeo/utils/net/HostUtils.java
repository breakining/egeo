package com.egeo.utils.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HostUtils {
	static Logger logger = LoggerFactory.getLogger(HostUtils.class);

	public static String getHostIP() {
		try {
			if (isWindowsOS()) {
				InetAddress ip = InetAddress.getLocalHost();
				return ip.getHostAddress();
			} else {
				InetAddress ip = null;
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
						.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements()) {
					NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
					Enumeration<InetAddress> ips = ni.getInetAddresses();
					while (ips.hasMoreElements()) {
						ip = (InetAddress) ips.nextElement();
						if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
								&& ip.getHostAddress().indexOf(":") == -1) {
							return ip.getHostAddress();
						}
					}

				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	public static String getHostName() {
		try {
			if (isWindowsOS()) {
				InetAddress ip = InetAddress.getLocalHost();
				return ip.getHostAddress();
			} else {
				return getLocalNameFromException();
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	/**
	 * 获得主机IP
	 *
	 * @return String
	 */
	private static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	private static String getLocalNameFromException() {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			return ia.getHostName();
		} catch (UnknownHostException e) {
			logger.error("", e);
			String s = e.getMessage();
			return s.substring(0, s.indexOf(":"));
		}
	}

	public static Object getClientIP(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
}
