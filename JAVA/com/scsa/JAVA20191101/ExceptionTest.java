package com.scsa.JAVA20191101;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Checked Exception
public class ExceptionTest {
	public static void main(String[] args) {
		// 특정 파일을 읽어서 내용을 콘솔에 출력
		// 예외의 단위 : 메소드
		
		// Unhandled exception type FileNotFoundException
		// --> Checked Exception
//		FileReader fr = new FileReader("");
		
		try {
			// 자바의 파일 경로는 절대경로를 쓰는 것이 원칙
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// 단, '이클립스' 내에서 JavaProject만 프로젝트명까지는 생략 가능
			// ==> src/com/scsa/JAVA20191101/a.txt
			// 경로를 쓸 때는 \\ 로 해줘야 함
			FileReader fr = new FileReader("a.txt");
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다!");
			// 기존의 에러 메시지 출력 가능
			e.printStackTrace();
			System.out.println("===간단한 메시지===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("=======================================");
		
		
		try {
			// 자바의 파일 경로는 절대경로를 쓰는 것이 원칙
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// 단, '이클립스' 내에서 JavaProject만 프로젝트명까지는 생략 가능
			// ==> src/com/scsa/JAVA20191101/a.txt
			// 경로를 쓸 때는 \\ 로 해줘야 함
			FileReader fr = new FileReader("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191101\\a.txt");
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다!");
			// 기존의 에러 메시지 출력 가능
			e.printStackTrace();
			System.out.println("===간단한 메시지===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("파일 읽기 성공!!");
		System.out.println("=======================================");

		
		try {
			// 자바의 파일 경로는 절대경로를 쓰는 것이 원칙
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// 단, '이클립스' 내에서 JavaProject만 프로젝트명까지는 생략 가능
			// ==> src/com/scsa/JAVA20191101/a.txt
			// 경로를 쓸 때는 \\ 로 해줘야 함
			FileReader fr = new FileReader("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191101\\a.txt");
			
			// Unhandled exception type IOException
			fr.read();
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다!");
			// 기존의 에러 메시지 출력 가능
			e.printStackTrace();
			System.out.println("===간단한 메시지===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		} catch(IOException e) {
			System.out.println("입출력 에러");
			// 기존의 에러 메시지 출력 가능
			e.printStackTrace();
			System.out.println("===간단한 메시지===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("파일 읽기 성공!!");
		System.out.println("=======================================");
		
		
		try {
			// 자바의 파일 경로는 절대경로를 쓰는 것이 원칙
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// 단, '이클립스' 내에서 JavaProject만 프로젝트명까지는 생략 가능
			// ==> src/com/scsa/JAVA20191101/a.txt
			// 경로를 쓸 때는 \\ 로 해줘야 함
			FileReader fr = new FileReader("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191101\\a.txt");
			
			// Unhandled exception type IOException
			int i;
			while((i=fr.read()) != -1) {
				System.out.println((char)i);
			}
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다!");
			// 기존의 에러 메시지 출력 가능
			e.printStackTrace();
			System.out.println("===간단한 메시지===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		} catch(IOException e) {
			System.out.println("입출력 에러");
			// 기존의 에러 메시지 출력 가능
			e.printStackTrace();
			System.out.println("===간단한 메시지===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("파일 읽기 성공!!");
		System.out.println("=======================================");
	}
}
