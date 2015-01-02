package com.monkey.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * 日志类
 * 
 * @author 廖陈特
 * 
 */
public class Log {

	private static File errorFile = new File(Const.LOG_PATH + "/error_log.log");

	private static File debugFile = new File(Const.LOG_PATH + "/debug_log.log");

	/**
	 * 记录错误日志
	 * 
	 * @param label
	 * @param message
	 */
	// public static void error(String label, String message) {
	// String content = "[ERROR]" + label + ":" + message + "\r\n";
	// FileWriter fw = null;
	// BufferedWriter writer = null;
	// try {
	// fw = new FileWriter(errorFile, true);
	// writer = new BufferedWriter(fw);
	// writer.append(content);
	// writer.flush();
	// } catch (IOException e) {
	// error(e);
	// } finally {
	// try {
	// fw.close();
	// writer.close();
	// } catch (IOException e) {
	// error(e);
	// }
	// }
	// }

	/**
	 * 记录错误日志
	 * 
	 * @param label
	 * @param message
	 */
	public static void error(String label, Exception ex) {
		String content = "[ERROR]" + label + ":" + ex.getMessage() + "\r\n";
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			fw = new FileWriter(errorFile, true);
			writer = new BufferedWriter(fw);
			writer.append(content);
			writer.append("\r\n");
			writer.flush();
		} catch (IOException e) {
			error(e);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				error(e);
			}
		}
	}

	/**
	 * 记录调试日志
	 * 
	 * @param label
	 * @param message
	 */
	public static void debug(String label, String message) {
		String content = "[DEBUG]" + label + ":" + message + "\r\n";
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			fw = new FileWriter(debugFile, true);
			writer = new BufferedWriter(fw);
			writer.append(content);
			writer.append("\r\n");
			writer.flush();
		} catch (IOException e) {
			error(e);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				error(e);
			}
		}
	}

	/**
	 * 服务端弹出窗报错
	 * 
	 * @param e
	 */
	private static void error(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage());
		System.exit(0);
	}
}
