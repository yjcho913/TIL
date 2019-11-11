package com.scsa.JAVA20191108;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest6 {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	Document doc;
	
	public DOMTest6() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//text ----> memory 변환
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			
			//=================== DOM 프로그래밍 시작 ===================//
			System.out.println("DOM Parsing 성공!");
			/*
				(미션) books.xml의 모든 도서의 제목을 출력
				(출력형태)
					#도서목록
					c언어
					LinuxServer
					JavaProgramming
					XMLBible
			*/
			
			//Element doc.getElementById(String elementId);	//elementId : id 속성값
			//NodeList doc.getElementsByTagName(String tagname);
			System.out.println("#도서목록");
			NodeList titleList = doc.getElementsByTagName("title");
			for(int i=0; i<titleList.getLength(); i++) {
				System.out.println(" " + titleList.item(i).getTextContent());
			}
			
			/*
				(미션) books.xml의 모든 도서의 정보 출력
				(출력형태)
				#도서목록
				 c언어 :홍길동[15000]
				 LinuxServer :김철수[25000]
				 JavaProgramming :이영희[26000]
				 XMLBible :홍길동[19000]
			 */
			System.out.println("========================================");
			NodeList authorList = doc.getElementsByTagName("author");
			NodeList priceList = doc.getElementsByTagName("price");
			System.out.println("#도서목록");
			for(int i=0; i<titleList.getLength(); i++) {
				System.out.println(" " + titleList.item(i).getTextContent() 
									   + " :" + authorList.item(i).getTextContent()
						 			   + "[" + priceList.item(i).getTextContent() + "]");
			}
			
			
			/*
				(미션) books.xml의 특정 저자의 도서 정보 출력
				(출력형태)
				#[홍길동] 저자의 도서
				 c언어 :홍길동[15000]
				 XMLBible :홍길동[19000]
			 */
			System.out.println("========================================");
			String authorName = "홍길동";
			System.out.println("#[" + authorName + "] 저자의 도서");
			for(int i=0; i<titleList.getLength(); i++) {
				if(authorList.item(i).getTextContent().equals(authorName)){
					System.out.println(" " + titleList.item(i).getTextContent());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DOMTest6();
	}
}