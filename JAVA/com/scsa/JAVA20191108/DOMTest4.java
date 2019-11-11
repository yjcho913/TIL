package com.scsa.JAVA20191108;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMTest4 {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	Document doc;
	
	public DOMTest4() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			//factory.setIgnoringElementContentWhitespace(true);	//�� �ǹ� ����
			builder = factory.newDocumentBuilder();
			
			//text ----> memory ��ȯ
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			
			//=================== DOM ���α׷��� ���� ===================//
			System.out.println("DOM Parsing ����!");
			/*
				(�̼�) books.xml�� ù��° ������ å ���� ���
			*/
			Element root = doc.getDocumentElement();	//books
			Node ws1 = root.getFirstChild();
			Node book = ws1.getNextSibling();
			Node ws2 = book.getFirstChild();
			Node title = ws2.getNextSibling();
			System.out.println("ù��° ������ >>> " + title.getTextContent());
			// ������ �ְ� ���� ���� �ڵ尡 �޶��� ---> ����
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DOMTest4();
	}
}