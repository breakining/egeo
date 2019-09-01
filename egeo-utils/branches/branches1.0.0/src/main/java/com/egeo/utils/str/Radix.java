package com.egeo.utils.str;

import java.util.HashMap;
import java.util.Map;

public class Radix {
	private int radix;
	private char[] chars;
	private Map<Character, Integer> number = new HashMap<Character, Integer>();

	public Radix(String letter){
		if (letter == null)
			throw new IllegalArgumentException("letter must not be null!");
		this.radix = letter.length();
		this.chars = letter.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			number.put(chars[i], i);
		}
	}

	public String parse(long num) {
		if (num == 0)
			return Character.valueOf(chars[0]).toString();
		StringBuilder s = new StringBuilder();
		append(s, num);
		return s.toString();
	}

	private void append(StringBuilder s, long num) {
		if (num == 0)
			return;
		s.insert(0, chars[Long.valueOf(num % radix).intValue()]);
		append(s, num / radix);
	}

	public long parse(String str) throws IllegalArgumentException {
		if (str == null)
			throw new NullPointerException("argument must not be null!");
		char[] chars = str.toCharArray();
		int[] nums = new int[chars.length];
		for (int i = 0; i < chars.length; i++)
			nums[i] = char2int(chars[i]);
		long result = 0;
		long multiple = 1;
		for (int i = nums.length; i-- > 0;) {
			long num = nums[i];
			result += num * multiple;
			multiple = multiple * radix;
		}
		return result;
	}

	private int char2int(char c) {
		Integer i = number.get(c);
		if (i == null)
			throw new IllegalArgumentException("illegal character '" + c + "'!");
		return i.intValue();
	}
}
