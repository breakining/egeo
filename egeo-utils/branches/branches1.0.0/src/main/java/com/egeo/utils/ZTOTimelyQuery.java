package com.egeo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ZTOTimelyQuery {
	private final static String REQUEST_URL="http://japi.zto.cn/zto/api_utf8/traceInterface";
	private final static String APP_KEY="C8152DF85F31738B3FDFC52191CEA3CD";
	private final static String PARTNER_ID="ef65981a1d1f472a913c9582ff1b09fa";
	/**
	 * 发送POST 请求
	 * @param url 请求地址
	 * @param charset 编码格式
	 * @param params 请求参数
	 * @return 响应
	 * @throws IOException
	 */
	private static String sendZTOPost(String url, String charset, Map<String,Object> params) throws IOException {
		HttpURLConnection conn = null;
		OutputStreamWriter out = null;
		InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        Scanner in=null;
		try {
			conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", charset);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			out = new OutputStreamWriter(conn.getOutputStream(), charset);
			out.write(buildQuery(params, charset));
			out.flush();
			inputStream = conn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			in = new Scanner(conn.getInputStream(),charset);
			while(in.hasNextLine())
			{
				result.append(in.nextLine());
			}
			/*reader = new BufferedReader(inputStreamReader);
            String tempLine = null;
            while ((tempLine = reader.readLine()) != null) {
            	result.append(tempLine);
            }*/
            
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
            if (reader != null) {
                reader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if(in!=null){
            	in.close();
            }
		}
		return result.toString();
	}
	
	/**
	 * 将map转换为请求字符串
	 * <p>data=xxx&msg_type=xxx</p>
	 * @param params
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	private static String buildQuery(Map<String, Object> params, String charset) throws IOException {
		if (params == null || params.isEmpty()) {
			return null;
		}
		StringBuffer data = new StringBuffer();
		boolean flag = false;
		for (Entry<String, Object> entry : params.entrySet()) {
			if (flag) {
				data.append("&");
			} else {
				flag = true;
			}
			data.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), charset));
		}
		return data.toString();
	}
	/**
	 * 
	 * @param requestDataType 2=json 1=xml默认为2
	 * @param ShipperCode
	 * @param LogisticCode
	 * @param orderCode 可以为空
	 * @return
	 * @throws Exception
	 */
	public static String getOrderTraces(String ShipperCode,String LogisticCode) throws Exception
	{
		if(!ShipperCode.equals("ZTO")) return "";
		Map<String,Object> map = new HashMap<>();
		String data = "[\""+LogisticCode+"\"]";
		map.put("data", data);
		map.put("msg_type", "TRACES");
		map.put("data_digest", DigestUtil.digest(data, APP_KEY, DigestUtil.UTF8));
		map.put("company_id", PARTNER_ID);
		String result=sendZTOPost(REQUEST_URL, DigestUtil.UTF8, map);
		return result;
	}
	public Map<String,Object> resultXmlDataToMap(String result)
	{
		return null;
	}
	public static void main(String[] args) {
		try {
			String string = getOrderTraces("ZTO","449104676318");
			System.out.println(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
