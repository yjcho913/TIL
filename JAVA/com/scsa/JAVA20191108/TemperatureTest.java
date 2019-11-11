package com.scsa.JAVA20191108;

import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/*
		
�̼�) ȭ�鿡 �Ʒ��� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
   
  ���� ������ ����1��: 15�� ����� 15.0�� �Դϴ�.
 ===> ���� �ְ���  15.0��, ������� 5.0�� �Դϴ�.
 
 class��: TemperatureTest
 http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000
 
 */

public class TemperatureTest {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	Document doc;
	
	public TemperatureTest() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");
			
			//���� ������ ����1��: 15�� ����� 15.0�� �Դϴ�.
			//===> ���� �ְ���  16.0��, ������� 5.0�� �Դϴ�.
			String hour = "15";
			String day = "1";
			
			NodeList hourList = doc.getElementsByTagName("hour");
			NodeList dayList = doc.getElementsByTagName("day");
			NodeList tempList = doc.getElementsByTagName("temp");
			NodeList tmxList = doc.getElementsByTagName("tmx");
			NodeList tmnList = doc.getElementsByTagName("tmn");
			
			for(int i=0; i<hourList.getLength(); i++) {
				if(hourList.item(i).getTextContent().equals(hour) && dayList.item(i).getTextContent().equals(day)) {
					System.out.println("���� ������ ����1��: " + hour + "�� ����� " + tempList.item(i).getTextContent() + "�� �Դϴ�.");
					System.out.println("===> ���� �ְ���  " + tmxList.item(i).getTextContent() + "��, ������� " + tmnList.item(i).getTextContent() + "�� �Դϴ�.");
					break;
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TemperatureTest();
	}
}
