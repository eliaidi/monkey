package com.monkey.util;

/**
 * 服务器相关配置
 * 
 * @author 廖陈特
 * @deprecated 以后改用配置文件
 */
public class ServerConfig {

	private int port = 8080;

	private String address = "127.0.0.1";

	private int backlog = 5;

	/**
	 * 是否记录日志 true-是 flase-否 默认值为true
	 */
	private boolean isLog = true;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBacklog() {
		return backlog;
	}

	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\r\n");
		buffer.append("Listener Port : ");
		buffer.append(port);
		buffer.append("\r\n");
		buffer.append("Listener Address : ");
		buffer.append(address);
		buffer.append("\r\n");
		buffer.append("Server Backlog : ");
		buffer.append(backlog);
		buffer.append("\r\n");
		return buffer.toString();
	}

	public boolean isLog() {
		return isLog;
	}

	public void setLog(boolean isLog) {
		this.isLog = isLog;
	}
}
