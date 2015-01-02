package com.monkey.util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * 工具类(公共方法)
 * 
 * @author 廖陈特
 * 
 */
public class Util {

	public static Pattern patternHttpUri = Pattern.compile("^(/.*)*$");

	public static boolean isNotNull(Object o) {
		boolean notNull = false;
		if (null != o && !"".equals(o)) {
			notNull = true;
		}
		return notNull;
	}

	/**
	 * 判断是否请求根路径
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isRoot(Object o) {
		boolean isRoot = false;
		if (null != o && ("".equals(o) || "/".equals(o))) {
			isRoot = true;
		}
		return isRoot;
	}

	/**
	 * 判断是否是有效链接
	 * 
	 * @param uri
	 * @return
	 */
	public static boolean isActionLink(String uri) {
		Matcher matcher = Util.patternHttpUri.matcher(uri);
		return matcher.matches();
	}
	
	public static void readXml(String fileName) {
		 SAXReader reader = new SAXReader();
		 try {
			Document document = reader.read(new File(fileName));
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
	}
	
	
}
