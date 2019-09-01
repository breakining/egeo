package com.egeo.utils.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.helper.StringUtil;

import com.egeo.utils.EmptyUtil;

/**
 * StringUtils<br>
 * 继承了org.apache.commons.lang.StringUtils
 * 
 * @author guannan.shang
 * @date 2015-2-3 下午7:07:57
 * @version 1.0
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
	/**
	 * 转换为下划线命名法规则<br>
	 * <code>String str = "userName";<br>
	 * str = parse2Underscore(str);</code> <br>
	 * 结果 str = "USER_NAME"
	 * 
	 * @param str
	 * @return
	 */
	public static String parse2Underscore(String str) {
		char[] chars = str.toCharArray();
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 65 && chars[i] <= 90) {
				if (!isFirst)
					s.append('_');
				s.append(chars[i]);
			} else if (chars[i] >= 97 && chars[i] <= 122) {
				s.append((char) (chars[i] - 32));
			} else {
				s.append(chars[i]);
			}
			isFirst = false;
		}
		return s.toString();
	}

	/**
	 * 转换成骆驼命名法
	 * 
	 * @param str
	 * @return
	 */
	public static String parse2Camel(String str) {
		str = str.toLowerCase();
		char[] chars = str.toCharArray();
		char[] toChar = new char[chars.length];
		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if ('_' == c && i != chars.length - 1)
				c = upperCase(chars[++i]);
			toChar[j] = c;
			j++;
		}
		return new String(toChar).trim();
	}

	public static char lowerCase(char c) {
		if (c >= 65 && c <= 90)
			c += 32;
		return c;
	}

	public static char upperCase(char c) {
		if (c >= 97 && c <= 122)
			c -= 32;
		return c;
	}

	public static String firstCharUpperCase(String str) {
		char[] cs = str.toCharArray();
		cs[0] = upperCase(cs[0]);
		return String.valueOf(cs);
	}

	public static String firstCharLowerCase(String str) {
		char[] cs = str.toCharArray();
		cs[0] = lowerCase(cs[0]);
		return String.valueOf(cs);
	}

	/**
	 * 将log中的参数注入
	 * 
	 * @param log
	 *            字符串包含参数格式为：{0}{1}{2}
	 * @param param
	 *            参数按照顺序填入{0}{1}{2}
	 * @return
	 */
	public static String getLog(String log, Object... params) {
		if (params == null)
			return log;
		for (int i = 0; i < params.length; i++) {
			Object param = params[i];
			if (param != null) {
				log = log.replaceAll("\\{" + i + "\\}", param.toString());
				log = log.replaceAll("｛" + i + "｝", param.toString());
			}
		}
		return log;
	}

	/**
	 * 判断一个字符串是否含有中文搜索
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		if (str == null)
			return false;
		for (char c : str.toCharArray()) {
			if (isChinese(c))
				return true;// 有一个中文字符就返回
		}
		return false;
	}

	/**
	 * 判断一个字符是否是中文
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.length() != 0;// 根据字节码判断
	}

	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);// 根据字节码判断
	}

	/**
	 * 检查是否为正确的手机号码
	 */
	public static boolean validMobile(String mobile) {
		if (isEmpty(mobile)) {
			return false;
		}
		// String pattern = "^(1\\d{10})$";
		String pattern = "^1(3|4|5|7|8)\\d{9}$";
		return Pattern.matches(pattern, mobile);
	}

	/**
	 * 验证座机号码
	 * 
	 * @param tel
	 * @return
	 */
	public static boolean validTel(String tel) {
		if (isEmpty(tel)) {
			return false;
		}
		String pattern = "^\\d{3,4}-?\\d{7,9}$";
		return Pattern.matches(pattern, tel);
	}

	/**
	 * 验证座机号码
	 * 
	 * @param tel
	 * @return
	 */
	public static String getArrayLastValue(String array) {
		if (isEmpty(array)) {
			return "";
		}
		String substring = array.substring(1, array.length() - 1);
		List<String> list = Arrays.asList(substring.split(","));
		return list.get(list.size() - 1);

	}

	/**
	 * 将形如1,2,3,4的字符串数组转换成id列表
	 * 
	 * @param ids
	 * @return
	 */
	public static List<Long> string2IdList(String ids, String seperator) {
		List<Long> result = new ArrayList<>();
		if (StringUtil.isBlank(ids) || StringUtil.isBlank(seperator))
			return result;
		String[] idsArray = ids.split(seperator);
		for (String id : idsArray) {
			result.add(Long.parseLong(id));
		}
		return result;
	}
	/**
	 * 判断字符串是否为数字
	 * @return
	 */
	public static boolean isNotFigure(String str){
		boolean isFirst = false;
		//不为空才进行下面的判断
		if(EmptyUtil.isNotEmpty(str)){
			for (int i = 0; i < str.length(); i++){
			   if (Character.isDigit(str.charAt(i)) || str.charAt(i) =='.'){
				   isFirst = true;
			   }else{
				   isFirst = false;
				   break;
			   }
			  }
		}
		return isFirst;
		
	}
	
	/**
	 * 获取6位随机验证码
	 * @return
	 */
	public static String getRandom() {
	String num = "";
	for (int i = 0 ; i < 6 ; i ++) {
	num = num + String.valueOf((int) Math.floor(Math.random() * 9 + 1));
	}
	return num;
	}
	
	/**
	 * 获取规定位随机验证码
	 * @return
	 */
	public static String getRandomByCount(int n) {
		String num = "";
		for (int i = 0 ; i < n ; i ++) {
			num = num + String.valueOf((int) Math.floor(Math.random() * 9 + 1));
		}
		return num;
	}
	
	/**
	 * 判断字符串是否为邮箱
	 * @return
	 */
	public static boolean isNotEmail(String email){
		boolean isFirst = true;
		//利用正则表达式（可改进）验证邮箱是否符合邮箱的格式  
        if(email.contains("@")){  
        	isFirst = false;
        }  
		return isFirst;
		
	}
	
	public static boolean isNotPasswordMay(String password){
		boolean isFirst = false;
		// 编译正则表达式
		String regEx ="^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![0-9\\W]+$)(?![a-z\\W]+$)(?![a-zA-Z]+$)(?![A-Z\\W]+$)[a-zA-Z0-9\\W_]+$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(password);
		// 字符串是否与正则表达式相匹配
		if (matcher.matches()) {
			isFirst = true; 
		}
		return isFirst;
	}
	public static void main(String[] args) {
		System.out.println(isNotEmail("lorne.min@egeo.com.cn"));
	}

}
