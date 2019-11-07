package com.scsa.JAVA20191106;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	
	public static void main(String[] args) throws Exception {
		
		//Socket cs = new Socket(String host, int port);
		//host : ������ �ּ�(ip)	
		//[3] "localhost" == "127.0.0.1". ���� ���� ����
		//��������õ�. ������ accept()�޼ҵ尡 ����
		Socket s = new Socket("70.12.60.50", 5000);
		
		//[4] ������ ���� ����� ��ü ����(write, read �ϱ� ���� �غ��۾�)
		OutputStream out = s.getOutputStream();
		InputStream is = s.getInputStream();
		// �ٴ����� �о���� ���� --> BufferedReader
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
	
		//[6]read
		String fromMsg = in.readLine();
		System.out.println("������ ���� �޼��� >>> " + fromMsg);
		
		//[7]write
		out.write("���ɸ޴�\n".getBytes());
	}
}
