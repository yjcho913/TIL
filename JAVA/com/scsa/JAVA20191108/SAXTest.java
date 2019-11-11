package com.scsa.JAVA20191108;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest extends DefaultHandler{//implements ContentHandler{ 
   //SAX: �̺�Ʈ ����� �ļ�
   //SAXParseException  <== XML������ ���õ� ����(Well-formed���� ���� ����)
   //                                       (valid���� ���� ����)

   SAXParserFactory factory;
   SAXParser parser;
	
   public SAXTest() {
	 try {  
	  factory = SAXParserFactory.newInstance();
	  parser = factory.newSAXParser();
	  //parser.parse("SAX�Ľ��ϰ����ϴ� XML����URL");
	  //parser.parse(String uri, DefaultHandler dh);
	  parser.parse("1107/sample.xml", this);//this: �ڵ鷯 �޼ҵ�(�ݹ�޼ҵ�)�� ��ġ
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
   }//������
   
   @Override
	public void startDocument() throws SAXException {
	   //System.out.println("startDocument");
	}
   
   @Override
	public void endDocument() throws SAXException {
	   //System.out.println("endDocument");
	}
   
   @Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	   //System.out.println("startElement");
	   System.out.print("<"+qName+">");
	}
   
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       //System.out.println("endElement");
    	System.out.print("</"+qName+">");
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    	//System.out.println("characters");
    	String str = new String(ch,start,length);
    	System.out.print(str);
    }
   
   
   public static void main(String[] args) {
	  new SAXTest();
   }
}