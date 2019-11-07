package com.scsa.JAVA20191106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

public class Server implements Runnable {
	//외부 클래스
	//1. 소켓을 통한 접속서비스(접속대기)
	//2. 접속된 클라이언트들 관리(Vector 활용)
	
	ServerSocket ss;
	Vector<Service> v;
	
	static final String NEW_SESSION = "100";
	static final String NEW_MSG = "200";
	static final String CHANGE_NAME = "150";

	public Server(){
		v = new Vector<>();
		
		System.out.println("Server Start...");
		try {
			ss = new ServerSocket(5000); //[1]특정 포트 열어주기
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Thread(this).start();
		
	}//생성자
	
	public void run() {
		try {
			while(true) {
				Socket s = ss.accept(); //[2]접속
				v.add(new Service(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	class Service extends Thread{
		//내부클래스
		//소켓을 통한 입출력 서비스
		
		BufferedReader in;
		OutputStream out;
		String nickName;
		
		public Service(Socket s) {
			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				out = s.getOutputStream();
				start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			//클라이언트가 보내는 여러 메세지를 읽어주는 기능을 위의 accept와 별도로 실행 가능
			/*
			 * '100|' 초기 생성
			 * '150|' 대화명 변경
			 * '200|' 메시지 전달
			*/
			try {
				StringTokenizer st;
				String newNickName;
				
				while(true) {
					String fromMsg = in.readLine();
					st = new StringTokenizer(fromMsg, "|");
					
					switch(st.nextToken()) {
						case NEW_SESSION:
							nickName = st.nextToken();
							break;
						case NEW_MSG:
							messageAll("[" + nickName + "]▶ " + st.nextToken());
							break;
						case CHANGE_NAME:
							newNickName = st.nextToken();
							messageAll("##[" + nickName +"]님이 ["+newNickName+"]님으로 이름 변경하였습니다");
							nickName = newNickName;
							break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void messageTo(String msg) throws Exception {
			//특정 클라이언트 한개에게 메세지 보내기
			//실제 메세지 보내는 역할
			out.write((msg+"\n").getBytes());
		}
		
		public void messageAll(String msg) {
			// 벡터 안에 있는 모든 클라이언트에게 메세지 보내기
			for(int i=0; i<v.size(); i++) {
				try {
					Service ser = v.get(i);
					ser.messageTo(msg);
				} catch (Exception e) {
					System.out.println("# 클라이언트가 접속을 끊음");
					v.remove(i--);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
