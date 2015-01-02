package com.monkey.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Single {

	private static Single single;

	private File file = new File(System.getProperty("user.dir") + "/config/Config.xml");

	private Single() {
		try {
			readFile();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private void readFile() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element documentroot = document.getRootElement();
		Document d1 = documentroot.getDocument();
		System.out.println(d1.getName());
	}

	public static Single newInstance() {
		if (single == null) {
			single = new Single();
		}
		return single;
	}
	
	public static void main(String[] args) {
		Single.newInstance();
	}
}
