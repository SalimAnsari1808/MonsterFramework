package com.demo.uility;

public class WaitUtil {

	public static void untilTimeComplete(long timeMilliSecond) {
		try {
			Thread.sleep(timeMilliSecond);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
