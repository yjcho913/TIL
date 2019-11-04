package com.scsa.JAVA20191101;

public class StringTest2 {
  public static void main(String[] args) {
	  String s1="java";
	  String s2="JaVA";
	  
	//문자열 s1,s2를 비교(문자열 내용비교)하시오
	  if(s1.equals(s2)) {
		  System.out.println("s1과 s2는 같은 문자열");
	  }else {
		  System.out.println("s1과 s2는 다른 문자열");
	  }
	  
	//대소문자 구분없이 s1과 s2철자를 비교하시오!!
	  System.out.println("s1을 전체 대문자로 변환 >>> "+ s1.toUpperCase());
	  System.out.println("s2을 전체 소문자로 변환 >>> "+ s2.toLowerCase());
	  System.out.println("대소문자 구분 없는 비교: " + s1.toUpperCase().equals(s2.toUpperCase()));
	  System.out.println("대소문자 구분 없는 비교: " + s1.equalsIgnoreCase(s2));
	  
	  
	  System.out.println("======= 문제 =======");	
	//문제) str문자열 안에 있는 숫자의 갯수를 화면에 출력하시오. 
    //     ----> 힌트) 문자열안의 각 문자들은 인덱스를 갖는다!!
	  String str="Java3Pro7gra9mm0ing";
	  int cnt = 0;
	  
	  for (int i = 0; i < str.length(); i++) {
		char ch = str.charAt(i);
		if(ch >= '0' && ch <= '9') cnt++;
	  }
	  System.out.println("숫자 개수 = " + cnt);
	  
	  
	  String str1="JavaProgramming";
	  System.out.println("=======byte배열 변환=======");	
	  byte []b = str1.getBytes();
//	  for (int i = 0; i < b.length; i++) {
//		System.out.println(b[i] + " " );
//	  }
	  // JDK5 버전 ---> 개선된 for문 제공
	  // 형식 ) for(자료형 변수명 : 배열명)
	  for(byte v : b) {
		  System.out.print(v + " ");
	  }
	  System.out.println();
	  
	  
	  System.out.println("=======byte배열을 문자열로 변환=======");
	  String str2 = new String(b);
	  System.out.println("STR2 >>> "+ str2);
	  
	  
	  System.out.println("=======char배열 변환=======");
	  char []ch = str1.toCharArray();
	  for(char c : ch) {
		  System.out.print(c + " ");
	  }
	  System.out.println();
	  
	  
	  System.out.println("=======char배열을 문자열로 변환=======");
	  String str3 = new String(ch);
	  System.out.println("STR3 >>> "+ str3);
 }
}
