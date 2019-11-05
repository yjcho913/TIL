package com.scsa.JAVA20191105;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
			/*
		   	FileReader fr = new FileReader(aPath);
		   
		   	// File�� FileReader Ŭ������ �� �� �� �� ����!
		   	File f = new File(aPath);
		   	FileReader fr = new FileReader(f);
		   	*/
	   
		//������ �Ӽ��� ������ Ŭ����
		//File f = new File(String path);
		//File f = new File("a.txt");
		File f = new File("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191105\\a.txt");//�⺻
		//  '\\' ---> '\'�� Ȯ��(���)���ڰ� �ƴ϶� ���ϰ� ���丮�� �����ϴ� ������ ���ڷ� ���!!
		   
		System.out.println("f����(���丮)���� ����: "+ f.exists());
		
		
	    File f2 = new File("c:/users/student/Desktop/java_source/JavaApp/src/com/scsa/JAVA20191105/a.txt");//�⺻
	         f2 = new File("src/com/scsa/JAVA20191105/a.txt");//������ ���(��Ŭ���������� ����)
	         f2 = new File("."); //   . ��� : current directory (������)
	         f2 = new File(".."); //  .. ��� : parent directory (�θ���)
	         f2 = new File("../.."); //  .. ��� : parent directory (�θ���)
		        		
		//������� ������
		System.out.println("f2.getPath()==> "+ f2.getPath());
		System.out.println("f2.getAbsolutePath()==> "+ f2.getAbsolutePath());
		System.out.println("f2.getCanonicalPath()==> "+ f2.getCanonicalPath());
		   
		
		//b.txt ���� �Ӽ� ���� ==> File f3���� ǥ��?
		//File f3 = new File("src/com/encore/j0503/b.txt");
		//��?
		File f3 = new File("bin/com/scsa/JAVA20191105/a.txt");
		   
		System.out.println("f3����(���丮)���� ����: "+ f3.exists());
		   
		if(f3.isFile()) {//f3�� �����̸� true
			System.out.println("f3�� ����!!");
		}
		
		if(f3.isDirectory()) {//f3�� ���丮(����)��� true
			System.out.println("f3�� ���丮(����)!!");
		}
		   
		
		   //����) song������ c.txt������ �����Ͻÿ�.
		   
		   //������: FileWriter, FileOutputStream�� ������ �����ϴ� ����� ���´�!!
		   
		   //new FileReader("c.txt"); //----> ���� ������ ��� �����߻�!!
		   //new FileWriter("c.txt"); //----> ���� ������ ��� ���ϻ���!!
		   
		   //new FileWriter("song/c.txt"); //---> �������� �ʴ� ������ ���� ���� �߻�!!
		   // ===> �ذ���)  FileŬ������ ��� ---> ������ �����ϴ� ��� �޼ҵ� ����. 
		   //                                     mkdirs()
		   
		String path="song/gildong/juwon";
		String fileName="c.txt";
		   
		File f4 = new File(path);
		   
		if(f4.exists()) {//���丮�� �����Ѵٸ�
			System.out.println("#���丮�� �̹� �����մϴ�!!");
		}else {//����(���丮)�� �������� �ʴ´ٸ�
			f4.mkdirs();
			System.out.println("#���丮�� ���� ������!!");
		}
		
		FileWriter fw = new FileWriter(path+"/"+fileName);
		//��õ� ������ ����!!
		
		fw.close();//�ڿ� ��ȯ
		   
	   /*
	   File�� DataBase �������? �����͸� (���α׷� ����� �������)���������� ����,�����ϱ� ���ؼ�.
	   File�� DataBase ������? �����͸� (���δٸ� ���α׷�, ������)����!!
	    */
		
		//c.txt���� ����!!
		File f5 = new File("song/gildong/juwon/c.txt");
		System.out.println("c.txt���ϻ���: "+ f5.delete());//���� ������ true!!
		
		//juwon���� ����!!
		File f6 = new File("song/gildong/juwon");
		System.out.println("f6���丮����: "+ f6.delete());//���� ������ true!!
		                              //--->  �� ���� ���� ����!! 
		
	   }//main
	}
