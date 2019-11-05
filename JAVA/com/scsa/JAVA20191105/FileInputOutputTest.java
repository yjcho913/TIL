package com.scsa.JAVA20191105;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputOutputTest {
	public static void main(String[] args) throws Exception {
		
		String aPath = "src/com/scsa/JAVA20191105/a.txt";
		String bPath = "src/com/scsa/JAVA20191105/b.txt";
		int i;

		//����1) a.txt ������ �о� �ܼ�(ȭ��)�� ����Ͻÿ�.
		System.out.println("=============== ���� 1 ===============");
		// ������ byte ������ �Է�
		FileInputStream fis = new FileInputStream(aPath);
		
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//
//		// ���̻� ���� ����Ʈ�� ���� �� -1 ����
//		System.out.println(fis.read());
//		System.out.println(fis.read());
//		fis.close();
		
		while((i=fis.read()) != -1) {
			System.out.println(i);
		}
		fis.close();
		
		
		//����2) a.txt ������ �о b.txt���Ͽ� ����Ͻÿ� ===> FileCopy!
		System.out.println("=============== ���� 2 ===============");
		FileInputStream fis2 = new FileInputStream(aPath);
		// b.txt ������ ������ ����� ����
		FileOutputStream fos2 = new FileOutputStream(bPath);
		
		while((i=fis2.read()) != -1) {
			fos2.write(i);
		}
		fos2.close();
		fis2.close();
		System.out.println("���� ���� ����!");
	}
}
