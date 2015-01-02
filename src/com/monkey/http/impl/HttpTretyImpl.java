package com.monkey.http.impl;

import com.monkey.http.HttpTreaty;

/**
 * HTTP协议类
 * 
 * @author 廖陈特
 * 
 */
public class HttpTretyImpl implements HttpTreaty {

	private String head;

	private String content;

	private String type;

	private String uri;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getType() {
		return type;
	}

	public String getUri() {
		return uri;
	}
}
