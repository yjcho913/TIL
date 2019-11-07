package com.scsa.JAVA20191106;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/*
		[�ֵ� ����]
		- �ʿ��ڿ� : ServerSocket
		- ������ : accept()
		- ����ä�ο� ���� �����
			- ���write : ������ ������
			- �Է�read : ������ �б�
	*/
	
	public static void main(String[] args) throws Exception {
		
		//[1] ������ ����Ǵ� JVM�� ���� IP�� ��õ� port ��ȣ�� ���ϼ��񽺸� ����
		//ServerSocket ss = new ServerSocket(int port);
		ServerSocket ss = new ServerSocket(5000);
		
		//[2] Ŭ���̾�Ʈ�� (Socket)������ ���. Ŭ���̾�Ʈ ���ӽ� �ش� Socket ��ȯ
		Socket s = ss.accept();
		String addr = s.getInetAddress().getHostAddress();
		System.out.println("Ŭ���̾�Ʈ ���� ����! >>> " + addr);
		
		//[4] ������ ���� ����� ��ü ����(write, read �ϱ� ���� �غ��۾�)
		OutputStream out = s.getOutputStream();
		InputStream is = s.getInputStream();
		// �ٴ����� �о���� ���� --> BufferedReader
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		
		//[5]write
		//���๮�� �� �־���� ��!
		String toMsg = "���� �� ��̾��?\n";
		out.write(toMsg.getBytes());
		
		//[8]read
		String fromMsg = in.readLine();
		System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� >>> " + fromMsg);
	}
	// ������ : �� ����� ���� ����
}
