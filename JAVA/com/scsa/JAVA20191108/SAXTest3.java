package com.scsa.JAVA20191108;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest3 extends DefaultHandler {//implements ErrorHandler{

   SAXParserFactory factory;
   SAXParser parser;
	
   public SAXTest3() {
	 try {  
	  factory = SAXParserFactory.newInstance();
	  factory.setValidating(true);
	    //valid(DTD�� ��������)üũ�� �ϰڴ�!!
	  
	  parser = factory.newSAXParser();
	  //parser.parse("1107/books.xml", this);
	  parser.parse("1107/books3.xml", this);
	    System.out.println("SAX�Ľ� ����!!");
	 }catch(Exception e) {
		 //e.printStackTrace();
	 }
   }//������
   
   @Override
   public void error(SAXParseException e) throws SAXException {
	 //DTD �Ǵ� XML Schema ������ �����ϴ� XML������  Valid���� ��������
	 //(��ȿ���� ���� XML�����߽߰�) ȣ��
	   System.out.println("error --> "+
	     "���������� DTD �Ǵ� XMLSchema�� ��ġ���� ����!!");
	   System.out.println(e.getMessage());
   }
   
   @Override
   public void fatalError(SAXParseException e) throws SAXException {
	 //XML Spec(XML����)�� ��ġ���� �ʴ� ����. well-formed���� ���� XML���� �߽߰�
	   System.out.println("fatalError ---> XML������ ��߳�!!");
	   System.out.println(e.getMessage());
   }
   
   
   public static void main(String[] args) {
	  new SAXTest3();
   }
}
