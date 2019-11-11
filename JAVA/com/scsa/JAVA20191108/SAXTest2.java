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
	  
	  parser.parse("1107/books.xml", this);//SAX파싱!!
	  
/*
 미션1: books.xml을 SAX Parsing하여 모든 책제목을 화면에 출력하시오.
  
  결과화면)
    #도서목록
      C언어
      LinuxServer
      JavaProgramming
      XMLBible  
      
 힌트)
    <title>              JavaProgramming       </title>
    -------              ---------------       ---------
   startElement()호출          characters()호출              endElement()호출 

  미션2: books.xml을 SAX Parsing하여 특정 저자의 책제목을 화면에 출력하시오.
	  결과화면)
       #도서목록(저자:홍길동)
        C언어
        XMLBible  
 */  
	  
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
   }//생성자
   
   
   
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
