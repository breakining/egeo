package com.egeo.utils;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;


public class ListDemo {
  public static void main(String args[]){
      for (int i = 0; i < 220; i++) {
          deletePicture();
    }
    }
  
  public static void deletePicture(){
	  
	  
    //设置好账号的ACCESS_KEY和SECRET_KEY
      String ACCESS_KEY = "GhtmR1oL55DGQJA52bs4Urlz4ZrOMuWplIfDU_9U";
      String SECRET_KEY = "VRuNtYcpS4HrVC4FcuCnjhkHan9uH0ssWSGsm1eA";
      Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

      //实例化一个BucketManager对象
      BucketManager bucketManager = new BucketManager(auth);

      //要列举文件的空间名
      String bucket = "51gouxiang";

      try {
        //调用listFiles方法列举指定空间的指定文件
        //参数一：bucket    空间名
        //参数二：prefix    文件名前缀
        //参数三：marker    上一次获取文件列表时返回的marker
        //参数四：limit     每次迭代的长度限制，最大1000，推荐值100
        //参数五：delimiter 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        FileListing fileListing = bucketManager.listFiles(bucket,null,null,222243,null);
        FileInfo[] items = fileListing.items;
        for(FileInfo fileInfo:items){
          System.out.println(fileInfo.key.substring(fileInfo.key.indexOf(".")+1));
          String string = fileInfo.key.substring(fileInfo.key.lastIndexOf("."));
          if(string.equals(".ts")){
        	  DeleteFileByInterface.deletePicture(fileInfo.key);
          }
          
          
        }
      } catch (QiniuException e) {
        //捕获异常信息
        Response r = e.response;
        System.out.println(r.toString());
      }
  }
}