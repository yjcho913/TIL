package com.scsa.JAVA20191108;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest2 extends DefaultHandler{ 

   SAXParserFactory factory;
   SAXParser parser;   

   boolean titleState;//false
   
   public SAXTest2() {
	 try {  
	  factory = SAXParserFactory.newInstance();
	  parser = factory.newSAXParser();
	  
	  parser.parse("1107/books.xml", this);//SAX�Ľ�!!
	  
/*
 �̼�1: books.xml�� SAX Parsing�Ͽ� ��� å������ ȭ�鿡 ����Ͻÿ�.
  
  ���ȭ��)
    #�������
      C���
      LinuxServer
      JavaProgramming
      XMLBible  
      
 ��Ʈ)
    <title>              JavaProgramming       </title>
    -------              ---------------       ---------
   startElement()ȣ��          characters()ȣ��              endElement()ȣ�� 

  �̼�2: books.xml�� SAX Parsing�Ͽ� Ư�� ������ å������ ȭ�鿡 ����Ͻÿ�.
	  ���ȭ��)
       #�������(����:ȫ�浿)
        C���
        XMLBible  
 */  
	  
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
   }//������
   
   
   
   @Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	   if(titleState) {
	     String str = new String(ch,start,length);
	     System.out.println("str="+str);
	   }
	}
   
   @Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	   if(qName.equals("title")) titleState=true;
	}
   
   @Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	   if(qName.equals("title")) titleState=false;
	}
   
   
   public static void main(String[] args) {
	  new SAXTest2();
   }
}
