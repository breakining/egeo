package com.egeo.utils;

import com.qiniu.util.Auth;

public class getQiNiuToken {
  
  /**指定保存到七牛的文件名--同名上传会报错  {"error":"file exists"}*/
  /** {"hash":"FrQF5eX_kNsNKwgGNeJ4TbBA0Xzr","key":"aa1.jpg"} 正常返回 key为七牛空间地址 http://imagetest.i.haierzhongyou.com/aa1.jpg */
  //上传文件的路径
  /*String FilePath ="src/1.jpg";*/

  public static String getqiNiuToken(){
      /**基本配置*/
      //设置好账号的ACCESS_KEY和SECRET_KEY
      String ACCESS_KEY = "GhtmR1oL55DGQJA52bs4Urlz4ZrOMuWplIfDU_9U";
      String SECRET_KEY = "VRuNtYcpS4HrVC4FcuCnjhkHan9uH0ssWSGsm1eA";
      //要上传的空间--目前用的测试空间--上线要修改
      String bucketname = "51fugj";
      
      //密钥配置
      Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
      String uploadToken = auth.uploadToken(bucketname);
      
    return uploadToken;
    
  }

}
