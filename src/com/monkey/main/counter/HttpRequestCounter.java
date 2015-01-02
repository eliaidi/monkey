package com.monkey.main.counter;

/**
 * Http请求计数器
 * 
 * @author 廖陈特
 * 
 */
public class HttpRequestCounter {

	private long counter = 0;

	private static HttpRequestCounter httpRequestCounter = null;

	private HttpRequestCounter() {
	}

	public static HttpRequestCounter getCurrentCounter() {
		if (httpRequestCounter == null) {
			httpRequestCounter = new HttpRequestCounter();
		}
		return httpRequestCounter;
	}

	public long getCounter() {
		return counter;
	}

	public void increase() {
		counter++;
	}

	public void decrease() {
		counter--;
	}
}
