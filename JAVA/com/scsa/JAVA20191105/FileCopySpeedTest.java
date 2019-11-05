package com.scsa.JAVA20191105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * ���� ũ�� : 1,972,978  bytes

	========== FILE INPUTSTREAM (BYTE ����) ===========
	���Ϻ��� �ҿ�ð� : 22868
	
	========== FILE READER (���� ����) ===========
	���Ϻ��� �ҿ�ð� : 153
	
	========== BUFFERED READER (���� ����) ===========
	���Ϻ��� �ҿ�ð� : 27
	
	========== FILE INPUTSTREAM (BYTE ���� / �迭 ���) ===========
	���Ϻ��� �ҿ�ð� : 47
		
 */

public class FileCopySpeedTest {
	// ���� ���� ����� ��ü���� �а� ���� �ӵ��� ��
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
		
		System.out.println("========== FILE INPUTSTREAM (BYTE ����) ===========");
		fis = new FileInputStream(aPath);
		fos = new FileOutputStream(bPath);
		
		
		start = System.currentTimeMillis();
		while((i=fis.read()) != -1) { // 1����Ʈ �а� 1����Ʈ ����
			fos.write(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("���Ϻ��� �ҿ�ð� : " + (end - start));
		// ���� 'finally' ��� �ȿ� ����
		fis.close();
		fos.close();
		
		
		System.out.println("========== FILE READER (���� ����) ===========");
		fr = new FileReader(aPath);
		fw = new FileWriter(bPath);
		
		start = System.currentTimeMillis();
		while((i=fr.read()) != -1) { // 1����Ʈ �а� 1����Ʈ ����
			fw.write(i);
		}
		end = System.currentTimeMillis();
		System.out.println("���Ϻ��� �ҿ�ð� : " + (end - start));
		
		fw.close();
		fr.close();
		
		
		System.out.println("========== BUFFERED READER (���� ����) ===========");
		// new BufferedReader(Reader in)
		// �⺻ Buffer ũ�� : 512 BYTES
		br = new BufferedReader(new FileReader(aPath));
		bw = new BufferedWriter(new FileWriter(bPath));
		
		// ��ȯŸ�� : String
		// ��ȯ�� �� ������, null ����
		start = System.currentTimeMillis();
		while((str = br.readLine()) != null) {
			bw.write(str);
		}
		end = System.currentTimeMillis();
		System.out.println("���Ϻ��� �ҿ�ð� : " + (end - start));
		
		bw.close();
		br.close();
		
		
		System.out.println("========== FILE INPUTSTREAM (BYTE ���� / �迭 ���) ===========");
		fis2 = new FileInputStream(aPath);
		fos2 = new FileOutputStream(bPath);
		byte[] b = new byte[1024];
		
		start = System.currentTimeMillis();
		while((i=fis2.read(b)) != -1) { // 1����Ʈ �а� 1����Ʈ ����
			fos2.write(b, 0, i);
		}
		end = System.currentTimeMillis();
		System.out.println("���Ϻ��� �ҿ�ð� : " + (end - start));
		
		fis2.close();
		fos2.close();
		
		
		System.out.println("========== BUFFERED READER (���� ���� / �̹����� ����) ===========");
		// new BufferedReader(Reader in)
		br = new BufferedReader(new FileReader(goldpigPath));
		bw = new BufferedWriter(new FileWriter(pigPath));
		
		start = System.currentTimeMillis();
		while((str = br.readLine()) != null) {
			bw.write(str);
		}
		end = System.currentTimeMillis();
		System.out.println("���Ϻ��� �ҿ�ð� : " + (end - start));
		
		bw.close();
		br.close();
		
		
		System.out.println("========== FILE INPUTSTREAM (BYTE ���� / �迭 ��� / �̹����� ����) ===========");
		fis2 = new FileInputStream(aPath);
		fos2 = new FileOutputStream(bPath);
		
		start = System.currentTimeMillis();
		while((i=fis2.read(b)) != -1) { // 1����Ʈ �а� 1����Ʈ ����
			fos2.write(b, 0, i);
		}
		end = System.currentTimeMillis();
		System.out.println("���Ϻ��� �ҿ�ð� : " + (end - start));
		
		fis2.close();
		fos2.close();
	}
	
	
	public static void main(String[] args) throws Exception{
		new FileCopySpeedTest();
	}
}
