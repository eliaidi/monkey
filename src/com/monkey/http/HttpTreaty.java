package com.monkey.http;

/**
 * HTTP协议接口
 * 
 * @author 廖陈特
 * 
 */
public interface HttpTreaty {

	/**
	 * 返回消息头
	 * 
	 * @return
	 */
	public String getHead();

	/**
	 * 设置消息头
	 * 
	 * @param head
	 */
	public void setHead(String head);

	/**
	 * 返回内容体
	 * 
	 * @return
	 */
	public String getContent();

	/**
	 * 设置内容体
	 * 
	 * @param content
	 */
	public void setContent(String content);

	/**
	 * 设置请求类型get or post
	 * 
	 * @param type
	 */
	public void setType(String type);

	/**
	 * 返回请求类型
	 * 
	 * @return
	 */
	public String getType();

	/**
	 * 设置URI
	 * 
	 * @param uri
	 */
	public void setUri(String uri);

	/**
	 * 返回Uri
	 * 
	 * @return
	 */
	public String getUri();

}
