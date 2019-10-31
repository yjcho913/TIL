package com.scsa.JAVA20191030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	String con;
	int dan;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int inputDan() throws IOException {
		
		System.out.print("원하는 단? ");
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
		System.out.print("계속(y/n)? ");
		con = br.readLine();
		System.out.println();
		return con;
	}
}
