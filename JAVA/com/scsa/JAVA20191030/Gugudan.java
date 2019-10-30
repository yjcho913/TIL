package com.scsa.JAVA20191030;

import java.io.IOException;

/*
1. Gugudan.java
  - 기능 정의
    ==> 단입력
        int inputDan(){
             read() 또는 readLine()
        }
    
    ==> 단출력
        void outputDan(int dan){
           //전달받은 dan에 대한 출력
        }
    
    ==> 계속여부
        char continueDan(){
           read() 또는 readLine()
        }
 */

public class Gugudan {
	int inputDan() throws IOException {
		int dan;
		
		System.out.print("원하는 단? ");
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
		
		System.out.print("계속(y/n)? ");
		con = (char)System.in.read();
		System.in.read();
		System.in.read();
		System.out.println();

		return con;
	}
}
