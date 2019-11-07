package com.scsa.JAVA20191106;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	
	public static void main(String[] args) throws Exception {
		
		//Socket cs = new Socket(String host, int port);
		//host : 서버의 주소(ip)	
		//[3] "localhost" == "127.0.0.1". 서버 소켓 생성
		//서버연결시도. 서버의 accept()메소드가 반응
		Socket s = new Socket("70.12.60.50", 5000);
		
		//[4] 소켓을 통한 입출력 객체 생성(write, read 하기 위한 준비작업)
		OutputStream out = s.getOutputStream();
		InputStream is = s.getInputStream();
		// 줄단위로 읽어오기 위해 --> BufferedReader
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
	
		//[6]read
		String fromMsg = in.readLine();
		System.out.println("서버가 보낸 메세지 >>> " + fromMsg);
		
		//[7]write
		out.write("점심메뉴\n".getBytes());
	}
}
