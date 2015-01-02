package com.monkey.http.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

import com.monkey.http.Request;
import com.monkey.http.Response;
import com.monkey.main.exception.ResourceNotFoundException;
import com.monkey.util.Const;
import com.monkey.util.Log;

/**
 * 
 * @author 廖陈特
 * 
 */
public class HttpResponse implements Response {

	/**
	 * 输出流
	 */
	private OutputStream out;

	/**
	 * Request对象
	 */
	private Request request;

	/**
	 * 构造函数
	 * 
	 * @param out
	 */
	public HttpResponse(OutputStream out) {
		this.out = out;
	}

	@Override
	public void sendStaticResource() throws Exception {
		File file = new File(request.getResourceUri());
		StringBuffer bufferHtml = new StringBuffer();
		BufferedReader br = null;
		InputStreamReader ist = null;
		FileInputStream fis = null;
		BufferedWriter bw = null;
		try {
			if (!(file.exists() && file.isFile())) {
				throw new ResourceNotFoundException(file.getPath());
			}
			fis = new FileInputStream(file);
			ist = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(ist);
			String htmlRow = br.readLine();
			while (htmlRow != null) {
				bufferHtml.append(htmlRow);
				htmlRow = br.readLine();
			}
			bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
			bw.write(bufferHtml.toString());
			bw.flush();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (br != null) {
				br.close();
			}
			if (ist != null) {
				ist.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
