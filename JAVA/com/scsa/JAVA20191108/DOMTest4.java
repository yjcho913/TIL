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
			//factory.setIgnoringElementContentWhitespace(true);	//별 의미 없음
			builder = factory.newDocumentBuilder();
			
			//text ----> memory 변환
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			
			//=================== DOM 프로그래밍 시작 ===================//
			System.out.println("DOM Parsing 성공!");
			/*
				(미션) books.xml의 첫번째 도서의 책 제목 출력
			*/
			Element root = doc.getDocumentElement();	//books
			Node ws1 = root.getFirstChild();
			Node book = ws1.getNextSibling();
			Node ws2 = book.getFirstChild();
			Node title = ws2.getNextSibling();
			System.out.println("첫번째 도서명 >>> " + title.getTextContent());
			// 공백이 있고 없고에 따라 코드가 달라짐 ---> 불편
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DOMTest4();
	}
}