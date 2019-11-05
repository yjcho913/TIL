package com.scsa.JAVA20191105;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteArrayTest {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("src/com/scsa/JAVA20191105/c.txt");
		
		//c.txt 파일에 내용: abcdefghi (9개의 문자)
		//System.out.println(fis.read());	// 97출력
		// fis.read(byte[] b);	// fis로 부터 읽은 바이트를 byte[] 배열에 저장
								// 리턴 값은 읽은 byte의 수
		byte[] b = new byte[5];
		
		System.out.println(fis.read(b));	//5 출력
		System.out.println(fis.read(b));	//4 출력
		System.out.println(fis.read(b));	//-1 출력
		
		
		
		byte [] b2 = {97,98,99,100,101};
		FileOutputStream fos = new FileOutputStream("src/com/scsa/JAVA20191105/d.txt");
		fos.write(b2);
		//d.txt--> abcde
		
		int i;
		while((i=fis.read(b)) != -1) {
			fos.write(b);
		}
		//d.txt---> abcdefghie
		//b2 초기값 = {0,0,0,0,0}
		//i=5 첫번째 실행 {97, 98, 99, 100, 101}
		//i=4 두번째 실행 {102, 103, 104, 105, 101}
		
		while((i=fis.read(b)) != -1) {
			fos.write(b,0,i);
		}
		//d.txt---> abcdefghi
		//fos.write(byte []b, int offset, int length);
		//offset:(복사)시작위치    length:복사할 byte수
		//예) fos.write(b,0,3);  배열b[]의 0인덱스 부터 3개 복사
		//예) fos.write(b,2,2);  배열b[]의 2인덱스 부터 2개 복사
		
	}
}