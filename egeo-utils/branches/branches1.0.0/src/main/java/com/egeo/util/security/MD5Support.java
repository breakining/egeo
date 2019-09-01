package com.egeo.util.security;

import java.security.MessageDigest;

public class MD5Support
{
  private static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

  public static final String MD5(String paramString)
  {
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      int i = arrayOfByte2.length;
      char[] arrayOfChar = new char[i * 2];
      int j = 0;
      for (int k = 0; k < i; k++)
      {
        int m = arrayOfByte2[k];
        arrayOfChar[(j++)] = hexDigits[(m >>> 4 & 0xF)];
        arrayOfChar[(j++)] = hexDigits[(m & 0xF)];
      }
      return new String(arrayOfChar);
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static final String MD5(String paramString1, String paramString2) 
  {
    try
    {
	  byte[] arrayOfByte1 = paramString1.getBytes("UTF-8");
      if (paramString2 != null){
    	  paramString1 =paramString1 +paramString2;
    	  arrayOfByte1 = paramString1.getBytes("UTF-8");
      }else{
    	  arrayOfByte1 = paramString1.getBytes("UTF-8");
      }
        
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      int i = arrayOfByte2.length;
      char[] arrayOfChar = new char[i * 2];
      int j = 0;
      for (int k = 0; k < i; k++)
      {
        int m = arrayOfByte2[k];
        arrayOfChar[(j++)] = hexDigits[(m >>> 4 & 0xF)];
        arrayOfChar[(j++)] = hexDigits[(m & 0xF)];
      }
      return new String(arrayOfChar);
    }
    catch (Exception localException)
    {
    }
    return null;

  }
  
  // 测试主函数  
  public static void main(String args[]) {  
      // 原文  
      String plaintext = "product";
  //  plaintext = "123456";  
//      System.out.println("原始：" + plaintext);  
      System.out.println("普通MD5后：                                  " + MD5Util.MD5(plaintext)); 
//      System.out.println("普通MD5后：                                  " + MD5Util.md5Hex(plaintext));  
      System.out.println("普通MD5后：                                  " + MD5Util.MD5Salt(plaintext, "02@gndq8nzc&a8e8")); 
      System.out.println("MD5Support普通MD5后：" + MD5Support.MD5(plaintext,"02@gndq8nzc&a8e8"));
//      System.out.println("MD5Support普通MD5后：" + MD5Support.MD5(plaintext));  
/*      try {
		System.out.println("MD5+salt：" + MD5Support.MD5("123456","kh@&py$4vl"));
	} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
		e.printStackTrace();
	}*/
      


        
        
        
                  
        
  } 
}
