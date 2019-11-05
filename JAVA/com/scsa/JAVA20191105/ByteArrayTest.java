package com.scsa.JAVA20191105;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteArrayTest {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("src/com/scsa/JAVA20191105/c.txt");
		
		//c.txt ���Ͽ� ����: abcdefghi (9���� ����)
		//System.out.println(fis.read());	// 97���
		// fis.read(byte[] b);	// fis�� ���� ���� ����Ʈ�� byte[] �迭�� ����
								// ���� ���� ���� byte�� ��
		byte[] b = new byte[5];
		
		System.out.println(fis.read(b));	//5 ���
		System.out.println(fis.read(b));	//4 ���
		System.out.println(fis.read(b));	//-1 ���
		
		
		
		byte [] b2 = {97,98,99,100,101};
		FileOutputStream fos = new FileOutputStream("src/com/scsa/JAVA20191105/d.txt");
		fos.write(b2);
		//d.txt--> abcde
		
		int i;
		while((i=fis.read(b)) != -1) {
			fos.write(b);
		}
		//d.txt---> abcdefghie
		//b2 �ʱⰪ = {0,0,0,0,0}
		//i=5 ù��° ���� {97, 98, 99, 100, 101}
		//i=4 �ι�° ���� {102, 103, 104, 105, 101}
		
		while((i=fis.read(b)) != -1) {
			fos.write(b,0,i);
		}
		//d.txt---> abcdefghi
		//fos.write(byte []b, int offset, int length);
		//offset:(����)������ġ    length:������ byte��
		//��) fos.write(b,0,3);  �迭b[]�� 0�ε��� ���� 3�� ����
		//��) fos.write(b,2,2);  �迭b[]�� 2�ε��� ���� 2�� ����
		
	}
}