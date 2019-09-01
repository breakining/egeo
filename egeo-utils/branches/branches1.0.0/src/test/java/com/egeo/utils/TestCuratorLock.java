package com.egeo.utils;

import com.egeo.utils.zk.CuratorLock;

public class TestCuratorLock {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String path = CuratorLock.getLock();
		while (true) {
			System.out.println(path);
			Thread.sleep(5000);
		}
	}
}