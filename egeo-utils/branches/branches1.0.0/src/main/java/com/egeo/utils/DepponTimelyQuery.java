package com.egeo.utils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import com.deppon.dop.module.sdk.shared.util.HttpUtils;
import com.deppon.dop.module.sdk.shared.util.SecurityUtil;
public class DepponTimelyQuery {
	private final static String APP_KEY = "35a998bbda10a42170a1e71a7f73e198";
	private final static String PARTNER_ID = "EWBEG";
	private final static String SIGN = "EEG";
	private final static String REQUEST_URL = "http://dpapi.deppon.com/dop-interface-sync/standard-query/traceOrder.action";
	/**
	 * @param ShipperCode
	 * @param LogisticCode
	 * @return
	 * @throws Exception
	 */
	public static String getOrderTraces(String ShipperCode, String LogisticCode)
			throws Exception {
		if (!ShipperCode.equals("DEPPON") && !ShipperCode.equals("DBL"))
			return "";
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"logisticCompanyID\": \"DEPPON\",");
		sb.append("\"orders\": [");
		sb.append("{\"mailNo\": \""+LogisticCode+"\" }");
		sb.append("]");
		sb.append("}");
		System.out.println(sb);
		String params = sb.toString();
		// companyCode与appkey为双方约定
		// 时间戳 SDK提供SecurityUtil获取时间戳
		String timestamp = SecurityUtil.getTimestamp();
		// 摘要 SDK提供SecurityUtil生成摘要
		String digest = SecurityUtil.getDigest(params + APP_KEY + timestamp);
		// post请求参数
		NameValuePair[] data = new NameValuePair[4];
		data[0] = new NameValuePair("companyCode", PARTNER_ID);
		data[1] = new NameValuePair("digest", digest);
		data[2] = new NameValuePair("timestamp", timestamp);
		data[3] = new NameValuePair("params", params);
		String response = null;
		try {
			// 返回结果
			response = HttpUtils.sendRequest(REQUEST_URL, data, "UTF-8", 5000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 根据返回结果进行后续操作
		return response;
	}


	private String getAccessDate(String AcceptTime) {
		String tempDate = AcceptTime;
		try {
			tempDate = tempDate.replaceAll("-", "").replaceAll("/", "")
					.replaceAll(" ", "").replaceAll(":", "")
					.replaceAll("'T'", "").replaceAll("T", "");
			tempDate = tempDate.substring(0, 14);
			Calendar day = Calendar.getInstance();
			day.add(Calendar.DATE, 0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// "yyyy-MM-dd"
			tempDate = sdf.format(day.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempDate;
	}

	public static void main(String[] args) throws Exception {
		DepponTimelyQuery httpUtil = new DepponTimelyQuery();
		String result = "{"
				+ "    \"responseParam\": {"
				+ "        \"logisticCompanyID\": \"DEPPON\","
				+ "        \"orders\": ["
				+ "            {"
				+ "                \"mailNo\": \"92189788\","
				+ "                \"orderStatus\": \"SIGNSUCCESS\","
				+ "                \"traceCode\": \"1000\","
				+ "                \"steps\": ["
				+ "                    {"
				+ "                        \"acceptTime\": \"2013-04-16T10:53:46.000+0800\","
				+ "                        \"remark\": \"已收取货物，[盐城]营业网点库存中\""
				+ "                    },"
				+ "                    {"
				+ "                        \"acceptTime\": \" 2013-04-17T09:13:25.000+0800\","
				+ "                        \"remark\": \"离开 [盐城]营业网点 发往 [南通]运输中心\""
				+ "                    },"
				+ "                    {"
				+ "                        \"acceptTime\": \" 2013-04-18T19:53:46.000+0800\","
				+ "                        \"remark\": \"已到达 [南通]运输中心\""
				+ "                    },"
				+ "                    {"
				+ "                        \"acceptTime\": \"2012-11-30 10:59:11\","
				+ "                        \"remark\": \"已到达 目的地,[西安雁塔?茁穄\""
				+ "                    },"
				+ "                    {"
				+ "                        \"acceptTime\": \" 2013-05-16 09:26:19 \","
				+ "                        \"remark\": \" 签收人：赵**\""
				+ "                    }" + "                ]"
				+ "            }" + "        ]" + "    },"
				+ "    \"result\": \"true\"," + "    \"resultCode\": \"1000\","
				+ "    \"reason\": \"\","
				+ "    \"uniquerRequestNumber\": \"839296208933240\"" + "}";
		/*Map map = httpUtil.resultJsonDataToMap(result);
		System.out.println(map);*/
		
		  String text="2013-04-16T10:53:46.000+0800"; text=text.replaceAll("-",
		  "").replaceAll("/", "") .replaceAll(" ", "").replaceAll(":",
		  "").replaceAll("'T'", "").replaceAll("T", "");
		  System.out.println(text); System.out.println(text.substring(0,14));
		 
		System.out.println("begin===="+new java.util.Date());
		String str=httpUtil.getOrderTraces("DEPPON", "99925724");
		System.out.println("str=="+str);
		System.out.println("end===="+new java.util.Date());
	}
}
