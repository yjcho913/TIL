package com.scsa.JAVA20191106;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		String host = "naver.com";
		//호스트 : 서비스를 제공하는 단말(PC)
		InetAddress ia = InetAddress.getByName(host);	//static
		String name = ia.getHostName();	//도메인명
		String addr = ia.getHostAddress();	//ip 주소
		System.out.println("호스트명 >>> " + name);
		System.out.println("호스트주소 >>> " + addr);
		System.out.println("=============================");
		InetAddress [] ias = ia.getAllByName(host);
		System.out.println("[" + host + "]의 서버 ip");
		for (int i = 0; i < ias.length; i++) {
			System.out.println(" " + ias[i].getHostAddress());
		}
		/*
		[naver.com]의 서버 ip
		 210.89.160.88
		 125.209.222.141
		 210.89.164.90
		 125.209.222.142
		*/
	}
}
