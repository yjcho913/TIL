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
		System.out.println("ȣ��Ʈ >>> " + url.getHost());
		System.out.println("���� ���ϸ� >>> " + url.getFile());
		
		InputStream is = url.openStream();
		String fileName = "src/com/scsa/JAVA20191106/test.html";

		// �ڵ��� �����ؼ�, ������ �ʵ��� ������!
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		// open�� ����Ʈ�� �ѱ� ���� ���� �߻�
		// ������ FileWriter���� Charset �������ڰ� ����
		// ��� OutputStreamWriter�� ���
		FileOutputStream fos = new FileOutputStream(fileName);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		String str;
		
		while((str = br.readLine())!= null) {
			bw.write(str);
		}
		
	}
}
