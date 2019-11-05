package com.scsa.JAVA20191105;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputOutputTest {
	public static void main(String[] args) throws Exception {
		
		String aPath = "src/com/scsa/JAVA20191105/a.txt";
		String bPath = "src/com/scsa/JAVA20191105/b.txt";
		int i;

		//문제1) a.txt 파일을 읽어 콘솔(화면)에 출력하시오.
		System.out.println("=============== 문제 1 ===============");
		// 파일을 byte 단위로 입력
		FileInputStream fis = new FileInputStream(aPath);
		
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//
//		// 더이상 읽을 바이트가 없을 때 -1 리턴
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//		fis.close();
		
		while((i=fis.read()) != -1) {
			System.out.println(i);
		}
		fis.close();
		
		
		//문제2) a.txt 파일을 읽어서 b.txt파일에 출력하시오 ===> FileCopy!
		System.out.println("=============== 문제 2 ===============");
		FileInputStream fis2 = new FileInputStream(aPath);
		// b.txt 파일을 생성후 출력을 실행
		FileOutputStream fos2 = new FileOutputStream(bPath);
		
		while((i=fis2.read()) != -1) {
			fos2.write(i);
		}
		fos2.close();
		fis2.close();
		System.out.println("파일 복사 성공!");
	}
}
