package com.scsa.JAVA20191101;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Checked Exception
public class ExceptionTest {
	public static void main(String[] args) {
		// Ư�� ������ �о ������ �ֿܼ� ���
		// ������ ���� : �޼ҵ�
		
		// Unhandled exception type FileNotFoundException
		// --> Checked Exception
//		FileReader fr = new FileReader("");
		
		try {
			// �ڹ��� ���� ��δ� �����θ� ���� ���� ��Ģ
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// ��, '��Ŭ����' ������ JavaProject�� ������Ʈ������� ���� ����
			// ==> src/com/scsa/JAVA20191101/a.txt
			// ��θ� �� ���� \\ �� ����� ��
			FileReader fr = new FileReader("a.txt");
		}catch(FileNotFoundException e) {
			System.out.println("������ ã�� ���߽��ϴ�!");
			// ������ ���� �޽��� ��� ����
			e.printStackTrace();
			System.out.println("===������ �޽���===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("=======================================");
		
		
		try {
			// �ڹ��� ���� ��δ� �����θ� ���� ���� ��Ģ
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// ��, '��Ŭ����' ������ JavaProject�� ������Ʈ������� ���� ����
			// ==> src/com/scsa/JAVA20191101/a.txt
			// ��θ� �� ���� \\ �� ����� ��
			FileReader fr = new FileReader("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191101\\a.txt");
		}catch(FileNotFoundException e) {
			System.out.println("������ ã�� ���߽��ϴ�!");
			// ������ ���� �޽��� ��� ����
			e.printStackTrace();
			System.out.println("===������ �޽���===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("���� �б� ����!!");
		System.out.println("=======================================");

		
		try {
			// �ڹ��� ���� ��δ� �����θ� ���� ���� ��Ģ
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// ��, '��Ŭ����' ������ JavaProject�� ������Ʈ������� ���� ����
			// ==> src/com/scsa/JAVA20191101/a.txt
			// ��θ� �� ���� \\ �� ����� ��
			FileReader fr = new FileReader("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191101\\a.txt");
			
			// Unhandled exception type IOException
			fr.read();
		} catch(FileNotFoundException e) {
			System.out.println("������ ã�� ���߽��ϴ�!");
			// ������ ���� �޽��� ��� ����
			e.printStackTrace();
			System.out.println("===������ �޽���===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		} catch(IOException e) {
			System.out.println("����� ����");
			// ������ ���� �޽��� ��� ����
			e.printStackTrace();
			System.out.println("===������ �޽���===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("���� �б� ����!!");
		System.out.println("=======================================");
		
		
		try {
			// �ڹ��� ���� ��δ� �����θ� ���� ���� ��Ģ
			// C:\Users\student\Desktop\java_source\JavaApp\src\com\scsa\JAVA20191101\a.txt
			// ��, '��Ŭ����' ������ JavaProject�� ������Ʈ������� ���� ����
			// ==> src/com/scsa/JAVA20191101/a.txt
			// ��θ� �� ���� \\ �� ����� ��
			FileReader fr = new FileReader("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191101\\a.txt");
			
			// Unhandled exception type IOException
			int i;
			while((i=fr.read()) != -1) {
				System.out.println((char)i);
			}
		} catch(FileNotFoundException e) {
			System.out.println("������ ã�� ���߽��ϴ�!");
			// ������ ���� �޽��� ��� ����
			e.printStackTrace();
			System.out.println("===������ �޽���===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		} catch(IOException e) {
			System.out.println("����� ����");
			// ������ ���� �޽��� ��� ����
			e.printStackTrace();
			System.out.println("===������ �޽���===");
			System.out.println("e.toString() >>> " + e.toString());
			System.out.println("e >>> " + e);
			System.out.println("e.getMessage() >>> " + e.getMessage());
		}
		System.out.println("���� �б� ����!!");
		System.out.println("=======================================");
	}
}
