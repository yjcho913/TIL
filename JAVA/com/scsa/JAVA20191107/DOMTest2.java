package com.scsa.JAVA20191107;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest2 {
	// 공장
	DocumentBuilderFactory factory;
	// 일꾼
	DocumentBuilder builder;
	
	Document doc;
	
	public DOMTest2() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//=================== DOM 프로그래밍 시작 ===================//
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			
			// Document - 위치, 신
			Element root = doc.getDocumentElement();
			documentRecur(doc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void documentRecur(Node n) {
		switch(n.getNodeType()) {
			case Node.ELEMENT_NODE:
				String tagName = n.getNodeName();
				System.out.print("<" +  tagName);
				// 속성 구하기
				NamedNodeMap nmap = n.getAttributes();
				for (int i = 0; i < nmap.getLength(); i++) {
					Node attr = nmap.item(i);
					System.out.print(attr.getNodeName() + "='" + attr.getNodeValue() + "'");
				}
				System.out.print(">");
				NodeList nlst = n.getChildNodes();
				for (int i = 0; i < nlst.getLength(); i++) {
					documentRecur(nlst.item(i));
				}
				System.out.print("</" + tagName + ">");
				break;
			case Node.TEXT_NODE:
				System.out.print(n.getNodeValue());
				break;
			case Node.COMMENT_NODE:
				System.out.print("<!-- " + n.getNodeValue() + " -->");
			case Node.DOCUMENT_NODE:
				NodeList nlst2 = n.getChildNodes();
				for (int i = 0; i < nlst2.getLength(); i++) {
					documentRecur(nlst2.item(i));
				}
				break;
		}
	}//documentRecurr
	
	public static void main(String[] args) {
		new DOMTest2();
	}
}
