package com.monkey.main.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import com.monkey.http.Request;
import com.monkey.http.Response;
import com.monkey.http.impl.HttpRequest;
import com.monkey.http.impl.HttpResponse;
import com.monkey.main.HttpServer;
import com.monkey.main.counter.HttpRequestCounter;
import com.monkey.main.exception.ResourceNotFoundException;
import com.monkey.util.Const;
import com.monkey.util.Log;
import com.monkey.util.ServerConfig;

/**
 * HTML服务器实现类
 * 
 * @author 廖陈特
 * 
 */
public class HttpServerImpl implements HttpServer {

	private boolean shutdown = false;

	private HttpRequestCounter counter = HttpRequestCounter.getCurrentCounter();

	/**
	 * 启动服务
	 */
	public void start() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(Const.CONFIG.getPort(),
					Const.CONFIG.getBacklog(),
					InetAddress.getByName(Const.CONFIG.getAddress()));
			Log.debug("Server Start", Const.CONFIG.toString());
			while (!shutdown) {
				counter.increase();
				Socket socket = null;
				socket = serverSocket.accept();
				InputStream ins = null;
				OutputStream out = null;
				ins = socket.getInputStream();
				out = socket.getOutputStream();
				try {
					Request request = new HttpRequest(ins);
					shutdown = Const.SHUTDOWN_COMMOND.equals(request.getHttp()
							.getUri());
					if (shutdown) {
						Log.debug("Http Request Counter ", counter.getCounter()
								+ "次");
						Log.debug("Server Close", "Html Server Destory!");
						socket.close();
						return;
					}
					Response response = new HttpResponse(out);
					response.setRequest(request);
					response.sendStaticResource();
					socket.close();
				} catch (ResourceNotFoundException e) {
					Log.error("404", e);
				} catch (Exception e) {
					Log.error("500", e);
				}
			}

		} catch (Exception e) {
			Log.error("Exception", e);
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					Log.error("Exception", e);
				}
			}
		}
	}
}
