package com.scsa.JAVA20191030;

import java.io.IOException;

/*
1. Gugudan.java
  - ��� ����
    ==> ���Է�
        int inputDan(){
             read() �Ǵ� readLine()
        }
    
    ==> �����
        void outputDan(int dan){
           //���޹��� dan�� ���� ���
        }
    
    ==> ��ӿ���
        char continueDan(){
           read() �Ǵ� readLine()
        }
 */

public class Gugudan {
	int inputDan() throws IOException {
		int dan;
		
		System.out.print("���ϴ� ��? ");
		dan = System.in.read() - '0';
		System.in.read();
		System.in.read();
		System.out.println();
		
		return dan;
	}
	
	void outputDan(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
		System.out.println();
	}
	
	char continueDan() throws IOException {
		char con;
		
		System.out.print("���(y/n)? ");
		con = (char)System.in.read();
		System.in.read();
		System.in.read();
		System.out.println();

		return con;
	}
}
