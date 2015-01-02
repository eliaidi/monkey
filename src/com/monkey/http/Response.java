package com.monkey.http;

public interface Response {

	/**
	 * 发送静态资源
	 */
	public void sendStaticResource() throws Exception;

	/**
	 * 设置request对象
	 * 
	 * @param request
	 *            类型Request
	 */
	public void setRequest(Request request);
}
