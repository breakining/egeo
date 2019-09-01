package com.egeo.utils.encrypt;



public class Mycrypt {
	private String key;
	public static Mycrypt getInstance(){
		return new Mycrypt();
	}
	public static Mycrypt getInstance(String key){
		if(key == null)
			return new Mycrypt();
		if(key.length()<16){
			StringBuffer s = new StringBuffer(key);
			for(int i = 0 ; i <= 15 - key.length() ; i++){
				s.append("0");
			}
			key = s.toString();
		}
		if(key.length()>16)
			key = key.substring(0,16);
		
		Mycrypt encrypt = new Mycrypt(key);
		return encrypt;
	}
	private Mycrypt(){
		key = "shangguannan-key";
	}
	private Mycrypt(String key){
		this.key = key;
	}
	public String encrypt(String data){
		return AES.encrypt(data, key);
	}
	public String decrypt(String data){
		return AES.decrypt(data, key);
	}
}
