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
			
			//text ----> memory ��ȯ
			doc = builder.parse("src/com/scsa/JAVA20191107/books.xml");
			
			//=================== DOM ���α׷��� ���� ===================//
			System.out.println("DOM Parsing ����!");
			/*
				(�̼�) books.xml�� ��� ������ ������ ���
				(�������)
					#�������
					c���
					LinuxServer
					JavaProgramming
					XMLBible
			*/
			
			//Element doc.getElementById(String elementId);	//elementId : id �Ӽ���
			//NodeList doc.getElementsByTagName(String tagname);
			System.out.println("#�������");
			NodeList titleList = doc.getElementsByTagName("title");
			for(int i=0; i<titleList.getLength(); i++) {
				System.out.println(" " + titleList.item(i).getTextContent());
			}
			
			/*
				(�̼�) books.xml�� ��� ������ ���� ���
				(�������)
				#�������
				 c��� :ȫ�浿[15000]
				 LinuxServer :��ö��[25000]
				 JavaProgramming :�̿���[26000]
				 XMLBible :ȫ�浿[19000]
			 */
			System.out.println("========================================");
			NodeList authorList = doc.getElementsByTagName("author");
			NodeList priceList = doc.getElementsByTagName("price");
			System.out.println("#�������");
			for(int i=0; i<titleList.getLength(); i++) {
				System.out.println(" " + titleList.item(i).getTextContent() 
									   + " :" + authorList.item(i).getTextContent()
						 			   + "[" + priceList.item(i).getTextContent() + "]");
			}
			
			
			/*
				(�̼�) books.xml�� Ư�� ������ ���� ���� ���
				(�������)
				#[ȫ�浿] ������ ����
				 c��� :ȫ�浿[15000]
				 XMLBible :ȫ�浿[19000]
			 */
			System.out.println("========================================");
			String authorName = "ȫ�浿";
			System.out.println("#[" + authorName + "] ������ ����");
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