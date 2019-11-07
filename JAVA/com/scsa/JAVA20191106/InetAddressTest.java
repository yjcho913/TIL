package com.scsa.JAVA20191106;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		String host = "naver.com";
		//ȣ��Ʈ : ���񽺸� �����ϴ� �ܸ�(PC)
		InetAddress ia = InetAddress.getByName(host);	//static
		String name = ia.getHostName();	//�����θ�
		String addr = ia.getHostAddress();	//ip �ּ�
		System.out.println("ȣ��Ʈ�� >>> " + name);
		System.out.println("ȣ��Ʈ�ּ� >>> " + addr);
		System.out.println("=============================");
		InetAddress [] ias = ia.getAllByName(host);
		System.out.println("[" + host + "]�� ���� ip");
		for (int i = 0; i < ias.length; i++) {
			System.out.println(" " + ias[i].getHostAddress());
		}
		/*
		[naver.com]�� ���� ip
		 210.89.160.88
		 125.209.222.141
		 210.89.164.90
		 125.209.222.142
		*/
	}
}
