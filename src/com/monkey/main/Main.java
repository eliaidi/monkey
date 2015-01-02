package com.monkey.main;

import com.monkey.console.Console;
import com.monkey.console.monitor.ServerListener;
import com.monkey.console.monitor.impl.ServerListenerImpl;
import com.monkey.main.impl.HttpServerImpl;

public class Main {
	
	private HttpServer server = null;
	
	private Console console = null;
	
	public Main() {
		server = new HttpServerImpl();
		Thread serverThread = new Thread(new Runnable() {
			@Override
			public void run() {
				server.start();
			}
		});
		serverThread.start();
		ServerListener listener = new ServerListenerImpl();
		console = new Console(listener);
	}
	
	
	
	public static void main(String[] args) {
		new Main();
	}
}
