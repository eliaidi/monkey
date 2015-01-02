package com.monkey.http.impl;

import java.io.IOException;
import java.io.InputStream;

import com.monkey.http.HttpTreaty;
import com.monkey.http.Request;
import com.monkey.util.Const;
import com.monkey.util.Log;
import com.monkey.util.Util;

/**
 * 
 * @author 廖陈特
 * 
 */
public class HttpRequest implements Request {

	private InputStream input;

	/**
	 * 请求内容
	 */
	private String requestContent;

	/**
	 * 资源实际Uri
	 */
	private String resourceUri;

	/**
	 * HTTP报文封装对象
	 */
	private HttpTreaty http = new HttpTretyImpl();

	/**
	 * 构造函数
	 * 
	 * @param input
	 */
	public HttpRequest(InputStream input) throws Exception {
		this.input = input;
		this.readData();
		this.parse(requestContent);
	}

	/**
	 * 读取Http协议
	 */
	private void readData() throws Exception {
		StringBuffer buffer = new StringBuffer();
		byte[] datas = new byte[2048];
		int i = this.input.read(datas);
		for (byte base : datas) {
			buffer.append((char) base);
		}
		requestContent = buffer.toString();
	}

	/**
	 * 解析Http协议
	 */
	public void parse(String requestContent) {
		String type = searchType(this.requestContent);
		String uri = searchUri(this.requestContent);
		http.setType(type);
		http.setUri(uri);
		resourceUri = structureResourceUri(uri);
	}

	/**
	 * 查找请求类型
	 * 
	 * @param url
	 * @return
	 */
	private String searchType(String url) {
		String type = "";
		int endIndex = -1;
		endIndex = url.indexOf(" ");
		if (endIndex != -1) {
			type = url.substring(0, endIndex);
		}
		return type;
	}

	/**
	 * 查找Http协议中的Uri
	 * 
	 * @param url
	 * @return
	 */
	private String searchUri(String url) {
		String uri = "";
		int startIndex = -1;
		startIndex = url.indexOf(" ");
		int endIndex = -1;
		if (startIndex != -1) {
			endIndex = url.indexOf(" ", startIndex + 1);
			if (endIndex != -1) {
				uri = url.substring(startIndex + 1, endIndex);
			}
		}
		return uri;
	}

	/**
	 * 构造资源的实际Uri
	 * 
	 * @param refer
	 * @param uri
	 * @return
	 */
	private String structureResourceUri(String uri) {
		String resourceUri = null;
		if (Util.isRoot(uri)) {
			resourceUri = Const.MANAGE_INDEX_HTML;
		} else {
			resourceUri = uri;
		}
		return Const.WEB_ROOT + resourceUri;
	}

	public HttpTreaty getHttp() {
		return http;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}

}
