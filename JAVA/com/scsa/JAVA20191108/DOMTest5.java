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
			// DTD에 명시된 내용을 제외하고는 전부 공백으로 취급 --> 제거
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			
			//text ----> memory 변환
			doc = builder.parse("src/com/scsa/JAVA20191108/books3.xml");
			
			//=================== DOM 프로그래밍 시작 ===================//
			System.out.println("DOM Parsing 성공!");
			/*
				(미션) books.xml의 첫번째 도서의 책 제목 출력
			*/
			Element root = doc.getDocumentElement();	//books
			Node book = root.getFirstChild();
			Node title = book.getFirstChild();
			System.out.println("첫번째 도서명 >>> " + title.getTextContent());
			
			// DTD가 불가피함! ---> DTD가 없을 때에도 처리할 수 있는 방법이 필요
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DOMTest5();
	}
}