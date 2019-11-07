package com.scsa.JAVA20191107;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DOMTest {
	// ����
	DocumentBuilderFactory factory;
	// �ϲ�
	DocumentBuilder builder;
	
	Document doc;
	
	public DOMTest() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//=================== DOM ���α׷��� ���� ===================//
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			System.out.println("DOM Parsing ����!");
			
			// Document - ��ġ, ��
			Element root = doc.getDocumentElement();
			System.out.println("root element �� >>> " + root.getTagName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DOMTest();
	}
}
