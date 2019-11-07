package com.scsa.JAVA20191107;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DOMTest {
	// 공장
	DocumentBuilderFactory factory;
	// 일꾼
	DocumentBuilder builder;
	
	Document doc;
	
	public DOMTest() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//=================== DOM 프로그래밍 시작 ===================//
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			System.out.println("DOM Parsing 성공!");
			
			// Document - 위치, 신
			Element root = doc.getDocumentElement();
			System.out.println("root element 명 >>> " + root.getTagName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DOMTest();
	}
}
