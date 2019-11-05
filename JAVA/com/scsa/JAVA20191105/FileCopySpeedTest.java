package com.scsa.JAVA20191105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * 파일 크기 : 1,972,978  bytes

	========== FILE INPUTSTREAM (BYTE 단위) ===========
	파일복사 소요시간 : 22868
	
	========== FILE READER (문자 단위) ===========
	파일복사 소요시간 : 153
	
	========== BUFFERED READER (문자 단위) ===========
	파일복사 소요시간 : 27
	
	========== FILE INPUTSTREAM (BYTE 단위 / 배열 사용) ===========
	파일복사 소요시간 : 47
		
 */

public class FileCopySpeedTest {
	// 여러 파일 입출력 객체들의 읽고 쓰는 속도를 비교
	FileInputStream fis, fis2;
	FileOutputStream fos, fos2;
	
	FileReader fr;
	FileWriter fw;
	
	BufferedReader br;
	BufferedWriter bw;
	
	String aPath = "src/com/scsa/JAVA20191105/a.txt";
	String bPath = "src/com/scsa/JAVA20191105/b.txt";
	String goldpigPath = "image/goldpig.jpg";
	String pigPath = "image/pig.jpg";
	String pig2Path = "image/pig2.jpg";
	
	public FileCopySpeedTest() throws Exception {
		int i;
		long start;
		long end;
		String str;
		
		System.out.println("========== FILE INPUTSTREAM (BYTE 단위) ===========");
		fis = new FileInputStream(aPath);
		fos = new FileOutputStream(bPath);
		
		
		start = System.currentTimeMillis();
		while((i=fis.read()) != -1) { // 1바이트 읽고 1바이트 쓰기
			fos.write(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("파일복사 소요시간 : " + (end - start));
		// 보통 'finally' 블록 안에 수행
		fis.close();
		fos.close();
		
		
		System.out.println("========== FILE READER (문자 단위) ===========");
		fr = new FileReader(aPath);
		fw = new FileWriter(bPath);
		
		start = System.currentTimeMillis();
		while((i=fr.read()) != -1) { // 1바이트 읽고 1바이트 쓰기
			fw.write(i);
		}
		end = System.currentTimeMillis();
		System.out.println("파일복사 소요시간 : " + (end - start));
		
		fw.close();
		fr.close();
		
		
		System.out.println("========== BUFFERED READER (문자 단위) ===========");
		// new BufferedReader(Reader in)
		// 기본 Buffer 크기 : 512 BYTES
		br = new BufferedReader(new FileReader(aPath));
		bw = new BufferedWriter(new FileWriter(bPath));
		
		// 반환타입 : String
		// 반환할 게 없으면, null 리턴
		start = System.currentTimeMillis();
		while((str = br.readLine()) != null) {
			bw.write(str);
		}
		end = System.currentTimeMillis();
		System.out.println("파일복사 소요시간 : " + (end - start));
		
		bw.close();
		br.close();
		
		
		System.out.println("========== FILE INPUTSTREAM (BYTE 단위 / 배열 사용) ===========");
		fis2 = new FileInputStream(aPath);
		fos2 = new FileOutputStream(bPath);
		byte[] b = new byte[1024];
		
		start = System.currentTimeMillis();
		while((i=fis2.read(b)) != -1) { // 1바이트 읽고 1바이트 쓰기
			fos2.write(b, 0, i);
		}
		end = System.currentTimeMillis();
		System.out.println("파일복사 소요시간 : " + (end - start));
		
		fis2.close();
		fos2.close();
		
		
		System.out.println("========== BUFFERED READER (문자 단위 / 이미지도 가능) ===========");
		// new BufferedReader(Reader in)
		br = new BufferedReader(new FileReader(goldpigPath));
		bw = new BufferedWriter(new FileWriter(pigPath));
		
		start = System.currentTimeMillis();
		while((str = br.readLine()) != null) {
			bw.write(str);
		}
		end = System.currentTimeMillis();
		System.out.println("파일복사 소요시간 : " + (end - start));
		
		bw.close();
		br.close();
		
		
		System.out.println("========== FILE INPUTSTREAM (BYTE 단위 / 배열 사용 / 이미지도 가능) ===========");
		fis2 = new FileInputStream(aPath);
		fos2 = new FileOutputStream(bPath);
		
		start = System.currentTimeMillis();
		while((i=fis2.read(b)) != -1) { // 1바이트 읽고 1바이트 쓰기
			fos2.write(b, 0, i);
		}
		end = System.currentTimeMillis();
		System.out.println("파일복사 소요시간 : " + (end - start));
		
		fis2.close();
		fos2.close();
	}
	
	
	public static void main(String[] args) throws Exception{
		new FileCopySpeedTest();
	}
}
