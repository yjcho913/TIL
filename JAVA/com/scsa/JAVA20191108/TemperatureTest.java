package com.scsa.JAVA20191108;

import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/*
		
미션) 화면에 아래와 같이 출력하는 프로그램을 작성하시오.
   
  내일 강남구 역삼1동: 15시 기온은 15.0도 입니다.
 ===> 내일 최고기온  15.0도, 최저기온 5.0도 입니다.
 
 class명: TemperatureTest
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
			
			//내일 강남구 역삼1동: 15시 기온은 15.0도 입니다.
			//===> 내일 최고기온  16.0도, 최저기온 5.0도 입니다.
			String hour = "15";
			String day = "1";
			
			NodeList hourList = doc.getElementsByTagName("hour");
			NodeList dayList = doc.getElementsByTagName("day");
			NodeList tempList = doc.getElementsByTagName("temp");
			NodeList tmxList = doc.getElementsByTagName("tmx");
			NodeList tmnList = doc.getElementsByTagName("tmn");
			
			for(int i=0; i<hourList.getLength(); i++) {
				if(hourList.item(i).getTextContent().equals(hour) && dayList.item(i).getTextContent().equals(day)) {
					System.out.println("내일 강남구 역삼1동: " + hour + "시 기온은 " + tempList.item(i).getTextContent() + "도 입니다.");
					System.out.println("===> 내일 최고기온  " + tmxList.item(i).getTextContent() + "도, 최저기온 " + tmnList.item(i).getTextContent() + "도 입니다.");
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
