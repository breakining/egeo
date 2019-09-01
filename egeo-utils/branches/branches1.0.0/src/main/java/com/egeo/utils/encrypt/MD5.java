package com.egeo.utils.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public String getMD5(byte[] source){  
        String s=null;  
        //用来将字节转换成16进制表示的字符  
        char[] hexDigits={'0','1','2','3','4','5','6','7','8','9',  
                'a','b','c','d','e','f'};  
        try {  
            MessageDigest md=MessageDigest.getInstance("MD5");  
            md.update(source);  
            //MD5的计算结果是一个128位的长整数，用字节表示为16个字节  
            byte[] tmp=md.digest();  
            //每个字节用16进制表示的话，使用2个字符(高4位一个,低4位一个)，所以表示成16进制需要32个字符  
            char[] str=new char[16*2];  
            int k=0;//转换结果中对应的字符位置  
            for(int i=0;i<16;i++){//对MD5的每一个字节转换成16进制字符  
                byte byte0=tmp[i];  
                str[k++]=hexDigits[byte0>>>4 & 0xf];//对字节高4位进行16进制转换  
                str[k++]=hexDigits[byte0 & 0xf];    //对字节低4位进行16进制转换  
            }  
            s=new String(str);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return s;  
    }  
    public static void main(String[] args) {  
        MD5 md5Util=new MD5();  
        String result=md5Util.getMD5("abc".getBytes());  
        String result1 = MD5.encode("abc");
        System.out.println(result);  
        System.out.println(result1);  
    }  
	
	public static String encode(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
