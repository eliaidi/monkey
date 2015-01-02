package com.monkey.util;

import java.awt.Color;

/**
 * 状态常量类
 * 
 * @author 廖陈特
 * 
 */
public interface Const {
	
	public final static ServerConfig CONFIG = new ServerConfig();

	public final static String ROOT = System.getProperty("user.dir");

	public final static String SHUTDOWN_COMMOND = "/SHUTDOWN";

	public final static String LOG_PATH = ROOT + "/logs";

	public final static String WEB_ROOT = ROOT + "/app";

	public final static String ERROR_PATH = ROOT + "/error";

	public final static String ERROR_404 = ERROR_PATH + "/404.html";

	public final static String MANAGE_PATH = "/manage";

	public final static String MANAGE_INDEX_HTML = MANAGE_PATH + "/Manage.html";

	/*响应协议头内容*/
	public final static String RESPONSE_TREATY_200 = "HTTP/1.1 200 OK";
	
	/* 控制台常量 */
	public final static Color SERVICE_SUCCESS_STATUS_COLOR = Color.GREEN;

	public final static Color SERVICE_FAIL_STATUS_COLOR = Color.RED;
}
