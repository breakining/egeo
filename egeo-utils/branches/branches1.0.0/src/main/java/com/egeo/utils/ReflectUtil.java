package com.egeo.utils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.egeo.utils.str.StringUtils;

public class ReflectUtil {

	/**
	 * 将map转化为java对象
	 * @param map
	 * @param clazz
	 * @param switchNameMethod 是否转化命名规范(_-->驼峰)
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T map2JavaBean(Map<String,String> map,Class<T> clazz,boolean switchNameMethod) throws InstantiationException, SecurityException, IllegalAccessException{
		Object o=clazz.newInstance();
		Set<String> keySet=map.keySet();
		for(Iterator<String> it=keySet.iterator();it.hasNext();){
			String key=it.next();
			String value=map.get(key);
			String fieldName=key;
			if(switchNameMethod)
				fieldName=StringUtils.parse2Camel(fieldName);
			Field f;
			try {
				f = clazz.getDeclaredField(fieldName);
				boolean accessible=f.isAccessible();
				f.setAccessible(true);
				setValue(o,f,value);
				f.setAccessible(accessible);
			} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
				//e.printStackTrace();
				System.out.println("变量"+fieldName+"不存在");
			}
		}
		
		return (T) o;
	}

	private static void setValue(Object instance, Field field, String fieldValue) throws IllegalArgumentException, IllegalAccessException {
		if(fieldValue==null)
			return;
		Class<?> fieldType=field.getType();
		//String fieldName=field.getName();
		//System.out.println("set===="+fieldType.getName()+"("+fieldName+")=="+fieldValue);
		if(fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)){
			field.setBoolean(instance, Boolean.parseBoolean(fieldValue));
		}else if(fieldType.equals(byte.class) || fieldType.equals(Byte.class)){
			field.setByte(instance, Byte.parseByte(fieldValue));
		}else if(fieldType.equals(char.class) || fieldType.equals(Character.class)){
			char c=fieldValue.length()==0?'\u0000':fieldValue.charAt(0);
			field.setChar(instance, c);
		}else if(fieldType.equals(double.class) || fieldType.equals(Double.class)){
			field.setDouble(instance, Double.parseDouble(fieldValue));
		}else if(fieldType.equals(float.class) || fieldType.equals(Float.class)){
			field.setFloat(instance, Float.parseFloat(fieldValue));
		}else if(fieldType.equals(int.class) || fieldType.equals(Integer.class)){
			field.setInt(instance, Integer.parseInt(fieldValue));
		}else if(fieldType.equals(long.class) || fieldType.equals(Long.class)){
			field.setLong(instance, Long.parseLong(fieldValue));
		}else if(fieldType.equals(short.class) || fieldType.equals(Short.class)){
			field.setShort(instance, Short.parseShort(fieldValue));
		}else{
			field.set(instance,fieldValue);
		}
	}
}
