package com.scsa.JAVA20191106;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("호스트 >>> " + url.getHost());
		System.out.println("서비스 파일명 >>> " + url.getFile());
		
		InputStream is = url.openStream();
		String fileName = "src/com/scsa/JAVA20191106/test.html";

		// 코덱을 지정해서, 깨지지 않도록 해주자!
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		// open된 사이트의 한글 깨짐 현상 발생
		// 하지만 FileWriter에는 Charset 설정인자가 없음
		// 대신 OutputStreamWriter를 사용
		FileOutputStream fos = new FileOutputStream(fileName);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		String str;
		
		while((str = br.readLine())!= null) {
			bw.write(str);
		}
		
	}
}
