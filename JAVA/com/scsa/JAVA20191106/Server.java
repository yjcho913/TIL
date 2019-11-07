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
	//�ܺ� Ŭ����
	//1. ������ ���� ���Ӽ���(���Ӵ��)
	//2. ���ӵ� Ŭ���̾�Ʈ�� ����(Vector Ȱ��)
	
	ServerSocket ss;
	Vector<Service> v;
	
	static final String NEW_SESSION = "100";
	static final String NEW_MSG = "200";
	static final String CHANGE_NAME = "150";

	public Server(){
		v = new Vector<>();
		
		System.out.println("Server Start...");
		try {
			ss = new ServerSocket(5000); //[1]Ư�� ��Ʈ �����ֱ�
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Thread(this).start();
		
	}//������
	
	public void run() {
		try {
			while(true) {
				Socket s = ss.accept(); //[2]����
				v.add(new Service(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	class Service extends Thread{
		//����Ŭ����
		//������ ���� ����� ����
		
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
			//Ŭ���̾�Ʈ�� ������ ���� �޼����� �о��ִ� ����� ���� accept�� ������ ���� ����
			/*
			 * '100|' �ʱ� ����
			 * '150|' ��ȭ�� ����
			 * '200|' �޽��� ����
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
							messageAll("[" + nickName + "]�� " + st.nextToken());
							break;
						case CHANGE_NAME:
							newNickName = st.nextToken();
							messageAll("##[" + nickName +"]���� ["+newNickName+"]������ �̸� �����Ͽ����ϴ�");
							nickName = newNickName;
							break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void messageTo(String msg) throws Exception {
			//Ư�� Ŭ���̾�Ʈ �Ѱ����� �޼��� ������
			//���� �޼��� ������ ����
			out.write((msg+"\n").getBytes());
		}
		
		public void messageAll(String msg) {
			// ���� �ȿ� �ִ� ��� Ŭ���̾�Ʈ���� �޼��� ������
			for(int i=0; i<v.size(); i++) {
				try {
					Service ser = v.get(i);
					ser.messageTo(msg);
				} catch (Exception e) {
					System.out.println("# Ŭ���̾�Ʈ�� ������ ����");
					v.remove(i--);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
