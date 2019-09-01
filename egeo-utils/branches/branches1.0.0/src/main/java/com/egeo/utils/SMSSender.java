package com.egeo.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ClassName: SMSSender
 * @author Administrator
 * @Description: TODO 发送 短信
 */
public final class SMSSender {
	private static Logger logger = LoggerFactory.getLogger(SMSSender.class);

	// 发送传递的参数
	// http://www.ztsms.cn:8800/sendXSms.do?username=用户名&password=密码&mobile=手机号码&content=内容&dstime=&productid=产品ID&xh=留空

	private static String productid;
	private static String xh;
	private static String sendurl;
	

	/****
	 * username 用户名（必填） password 密码（必填） mobile 手机号，多个手机号为用半角 ,
	 * 分开，如13899999999,13688888888(最多100个，必填) content 发送内容（必填） dstime
	 * 定时时间，为空时表示立即发送（选填） productid 产品id(必填) xh 扩展号,留空
	 * ***/

	public SMSSender() {
		sendurl = "http://www.ztsms.cn:8800/"; // 助通提供的发送地址
		productid = "95533";//
		xh = ""; // 扩展号留空
	}

	public String sendSms(String mobile, String content) {
		String sendUrl = null;
		try {// 否则发到手机乱码
			sendUrl = sendurl + "sendXSms.do?username="
					+ SMSSetting.SHORT_MSG_ACCOUNT + "&password="
					+ SMSSetting.SHORT_MSG_PWD + "&mobile=" + mobile
					+ "&content=" + URLEncoder.encode(content, "UTF-8")
					+ "&productid=" + productid + "&xh=" + xh;
		} catch (UnsupportedEncodingException uee) {
			logger.error(uee.toString());
		}
		// logger.info("短信内容为------------->:" + content);
		return getUrl(sendUrl);
	}

	/**
	 * @Title: getUrl
	 * @Description: 获取地址
	 * @param urlString
	 * @return
	 */

	public String getUrl(String urlString) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			conn.setReadTimeout(15000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			for (String line = null; (line = reader.readLine()) != null;) {
				sb.append(line + "\n");
			}
			reader.close();
		} catch (Exception e) {
			logger.error(e.toString());
		}
		String result = "";
		try {
			result = URLDecoder.decode(sb.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String sendRegisterCode(String phone, int code) {
		return sendSms(phone, "亲爱的用户您好，验证码为" + code + "，五分钟内有效！【上海迩格】");
	}
	
	public String commonSend(String phone,String content){
		return sendSms(phone,content);
	}

	public boolean sendMemberPassword(String phone, int code, String username) {
		String result_ = sendSms(phone, "亲爱的的用户" + "，您好！你本次的验证码为："
				+ code + "，登陆后请立即修改，注意保密！【上海迩格】");
		if (StringUtils.isNotEmpty(result_) && result_.trim().startsWith("1,")) {
			return true;
		}
		return false;
	}

	/***
	 * 测试地址
	 * 
	 * ***/
	public static void main(String[] args) {
//		String sendUrl = null;
//		try {// 否则发到手机乱码
//			sendUrl = "http://www.ztsms.cn:8800/" + "sendXSms.do?username="
//					+ "erge" + "&password="
//					+ "ergeAdmin$2015" + "&mobile=" + "17621986391"
//					+ "&content=" + URLEncoder.encode("ceshi", "UTF-8")
//					+ "&productid=" + 95533 + "&xh=" + "";
//		} catch (UnsupportedEncodingException uee) {
//			logger.error(uee.toString());
//		}
//		 new SMSSender().getUrl(sendUrl);
	}

}
