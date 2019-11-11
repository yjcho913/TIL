package com.scsa.JAVA20191108;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMTest5 {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	Document doc;
	
	public DOMTest5() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			// DTD�� ��õ� ������ �����ϰ�� ���� �������� ��� --> ����
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			
			//text ----> memory ��ȯ
			doc = builder.parse("src/com/scsa/JAVA20191108/books3.xml");
			
			//=================== DOM ���α׷��� ���� ===================//
			System.out.println("DOM Parsing ����!");
			/*
				(�̼�) books.xml�� ù��° ������ å ���� ���
			*/
			Element root = doc.getDocumentElement();	//books
			Node book = root.getFirstChild();
			Node title = book.getFirstChild();
			System.out.println("ù��° ������ >>> " + title.getTextContent());
			
			// DTD�� �Ұ�����! ---> DTD�� ���� ������ ó���� �� �ִ� ����� �ʿ�
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DOMTest5();
	}
}