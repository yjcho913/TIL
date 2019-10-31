package com.scsa.JAVA20191030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	String con;
	int dan;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int inputDan() throws IOException {
		
		System.out.print("���ϴ� ��? ");
		dan = Integer.parseInt(br.readLine());
		System.out.println();
		
		return dan;
	}
	
	public void outputDan(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
		System.out.println();
	}
	
	public String continueDan() throws IOException {
		System.out.print("���(y/n)? ");
		con = br.readLine();
		System.out.println();
		return con;
	}
}
