package com.monkey.http;

public interface Request {

	/**
	 * 返回Http报文
	 * 
	 * @return HttpTreaty
	 */
	public HttpTreaty getHttp();

	/**
	 * 返回实际资源URI
	 * 
	 * @return String
	 */
	public String getResourceUri();
}
