package com.egeo.utils.str;

import com.egeo.utils.net.HostUtils;

/**
 * @author guannan.shang
 * @date 2014-11-20 14:31:39
 */
public class UUID {
	private static Radix radix62 = new Radix("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
	private static String ip = null;
	static {
		String ip = HostUtils.getHostIP();
		String[] ss = ip.split("\\.");
		if (ss.length == 4) {
			long l = 0;
			l = 1000 + Long.parseLong(ss[0]);
			l = l * 1000 + Long.parseLong(ss[1]);
			l = l * 1000 + Long.parseLong(ss[2]);
			l = l * 1000 + Long.parseLong(ss[3]);
			Radix radix = new Radix("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
			UUID.ip = radix.parse(l);
		}
	}

	public static String uuid() {
		String s = java.util.UUID.randomUUID().toString();
		char[] cc = s.toCharArray();
		char[] cc2 = new char[32];
		int i = 0;
		for (char c : cc) {
			if (c != '-')
				cc2[i++] = c;
		}
		return new String(cc2);
	}

	public static String[] uuid(int i) {
		if (i < 1)
			return null;
		String as[] = new String[i];
		while (i-- > 0)
			as[i] = uuid();
		return as;
	}

	public static String uuidRadix62() {
		IdCreator creator = new IdCreatorNoChar(6);

		String next = creator.next();
		long l = Long.valueOf(next);
		return ip + radix62.parse(l);
	}
}
