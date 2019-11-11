package com.scsa.JAVA20191108;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest extends DefaultHandler{//implements ContentHandler{ 
   //SAX: 이벤트 기반의 파서
   //SAXParseException  <== XML문서에 관련된 에러(Well-formed하지 못한 문서)
   //                                       (valid하지 못한 문서)

   SAXParserFactory factory;
   SAXParser parser;
	
   public SAXTest() {
	 try {  
	  factory = SAXParserFactory.newInstance();
	  parser = factory.newSAXParser();
	  //parser.parse("SAX파싱하고자하는 XML문서URL");
	  //parser.parse(String uri, DefaultHandler dh);
	  parser.parse("1107/sample.xml", this);//this: 핸들러 메소드(콜백메소드)의 위치
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
   }//생성자
   
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