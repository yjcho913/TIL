package com.scsa.JAVA20191105;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
			/*
		   	FileReader fr = new FileReader(aPath);
		   
		   	// File과 FileReader 클래스를 둘 다 쓸 수 있음!
		   	File f = new File(aPath);
		   	FileReader fr = new FileReader(f);
		   	*/
	   
		//파일의 속성을 얻어오는 클래스
		//File f = new File(String path);
		//File f = new File("a.txt");
		File f = new File("C:\\Users\\student\\Desktop\\java_source\\JavaApp\\src\\com\\scsa\\JAVA20191105\\a.txt");//기본
		//  '\\' ---> '\'가 확장(기능)문자가 아니라 파일과 디렉토리를 구분하는 역할의 문자로 사용!!
		   
		System.out.println("f파일(디렉토리)존재 유무: "+ f.exists());
		
		
	    File f2 = new File("c:/users/student/Desktop/java_source/JavaApp/src/com/scsa/JAVA20191105/a.txt");//기본
	         f2 = new File("src/com/scsa/JAVA20191105/a.txt");//생략된 경로(이클립스내에서 가능)
	         f2 = new File("."); //   . 경로 : current directory (현재경로)
	         f2 = new File(".."); //  .. 경로 : parent directory (부모경로)
	         f2 = new File("../.."); //  .. 경로 : parent directory (부모경로)
		        		
		//경로정보 얻어오기
		System.out.println("f2.getPath()==> "+ f2.getPath());
		System.out.println("f2.getAbsolutePath()==> "+ f2.getAbsolutePath());
		System.out.println("f2.getCanonicalPath()==> "+ f2.getCanonicalPath());
		   
		
		//b.txt 파일 속성 참조 ==> File f3으로 표현?
		//File f3 = new File("src/com/encore/j0503/b.txt");
		//또?
		File f3 = new File("bin/com/scsa/JAVA20191105/a.txt");
		   
		System.out.println("f3파일(디렉토리)존재 유무: "+ f3.exists());
		   
		if(f3.isFile()) {//f3이 파일이면 true
			System.out.println("f3은 파일!!");
		}
		
		if(f3.isDirectory()) {//f3이 디렉토리(폴더)라면 true
			System.out.println("f3은 디렉토리(폴더)!!");
		}
		   
		
		   //문제) song폴더에 c.txt파일을 생성하시오.
		   
		   //※참고: FileWriter, FileOutputStream은 파일을 생성하는 기능을 갖는다!!
		   
		   //new FileReader("c.txt"); //----> 없는 파일의 경우 에러발생!!
		   //new FileWriter("c.txt"); //----> 없는 파일의 경우 파일생성!!
		   
		   //new FileWriter("song/c.txt"); //---> 존재하지 않는 폴더에 대해 에러 발생!!
		   // ===> 해결방법)  File클래스를 사용 ---> 폴더를 생성하는 기능 메소드 존재. 
		   //                                     mkdirs()
		   
		String path="song/gildong/juwon";
		String fileName="c.txt";
		   
		File f4 = new File(path);
		   
		if(f4.exists()) {//디렉토리가 존재한다면
			System.out.println("#디렉토리가 이미 존재합니다!!");
		}else {//폴더(디렉토리)가 존재하지 않는다면
			f4.mkdirs();
			System.out.println("#디렉토리를 새로 생성함!!");
		}
		
		FileWriter fw = new FileWriter(path+"/"+fileName);
		//명시된 파일을 생성!!
		
		fw.close();//자원 반환
		   
	   /*
	   File과 DataBase 사용이유? 데이터를 (프로그램 실행과 상관없이)지속적으로 저장,관리하기 위해서.
	   File과 DataBase 공통점? 데이터를 (서로다른 프로그램, 개발자)공유!!
	    */
		
		//c.txt파일 삭제!!
		File f5 = new File("song/gildong/juwon/c.txt");
		System.out.println("c.txt파일삭제: "+ f5.delete());//삭제 성공시 true!!
		
		//juwon폴더 삭제!!
		File f6 = new File("song/gildong/juwon");
		System.out.println("f6디렉토리삭제: "+ f6.delete());//삭제 성공시 true!!
		                              //--->  빈 폴더 삭제 가능!! 
		
	   }//main
	}
