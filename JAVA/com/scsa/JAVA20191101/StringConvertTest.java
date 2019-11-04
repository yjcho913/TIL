package com.scsa.JAVA20191101;

public class StringConvertTest {
	// 여러 문자열을 이어 붙인다면,
	// '+' 보다는 append가 성능면에서 더 좋음
	// '+' 할때마다 StringBuffer 객체 생성해야하기 때문!!
	
	   public void convert1() {
		  String s1="우리나라"; 
		  String s2="대한민국만세!!";
		  s1 = s1+s2;
		  /*
		     String클래스: 고정(길이)문자열!!
		     1. String클래스 객체 생성
		     2. 문자열변환을 위해서 임시로 StringBuffer클래스 객체생성
		     3. append()메소드 호출
		     4. StringBuffer객체를 String객체로 변환
		     5. 임시생성된 StringBuffer객체를 소멸.
		   */
		  
		  System.out.println(s1);
	   }	
	   public void convert2() {
		  StringBuffer s1 = new StringBuffer("우리나라"); 
		  s1.append("대한민국만세!!");
		  /*
		     StringBuffer클래스: 가변(길이)문자열!!
		     1. StringBuffer클래스 객체 생성
		     2. append()메소드 실행.
		  */
		  System.out.println(s1);
	   }	
	   public static void main(String[] args) {
		  StringConvertTest sct = new StringConvertTest();
		    sct.convert1();
		    System.out.println("==================");
		    sct.convert2();
	   }	
}
