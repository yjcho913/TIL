package com.scsa.JAVA20191106;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/*
		[주된 업무]
		- 필요자원 : ServerSocket
		- 응답대기 : accept()
		- 소켓채널에 대한 입출력
			- 출력write : 데이터 보내기
			- 입력read : 데이터 읽기
	*/
	
	public static void main(String[] args) throws Exception {
		
		//[1] 서버가 실행되는 JVM에 갖는 IP에 명시된 port 번호로 소켓서비스를 시작
		//ServerSocket ss = new ServerSocket(int port);
		ServerSocket ss = new ServerSocket(5000);
		
		//[2] 클라이언트의 (Socket)접속을 대기. 클라이언트 접속시 해당 Socket 반환
		Socket s = ss.accept();
		String addr = s.getInetAddress().getHostAddress();
		System.out.println("클라이언트 접속 성공! >>> " + addr);
		
		//[4] 소켓을 통한 입출력 객체 생성(write, read 하기 위한 준비작업)
		OutputStream out = s.getOutputStream();
		InputStream is = s.getInputStream();
		// 줄단위로 읽어오기 위해 --> BufferedReader
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		
		//[5]write
		//개행문자 꼭 넣어줘야 함!
		String toMsg = "점심 뭐 드셨어요?\n";
		out.write(toMsg.getBytes());
		
		//[8]read
		String fromMsg = in.readLine();
		System.out.println("클라이언트가 보낸 메세지 >>> " + fromMsg);
	}
	// 문제점 : 한 사람만 접근 가능
}
