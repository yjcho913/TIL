package com.scsa.JAVA20191101;

public class StringTest {//문자열String클래스의 기능 살펴보기
   public static void main(String[] args) {
	
		//String 문자열 : 문자들의 나열!!
		String str = "JavaProgramming";
		//인덱스 	  012345678901234
		
		//문자열 길이(문자 갯수)
		System.out.println("str 문자열 길이 >>> "+ str.length());
		
		//부분문자열 ----> "Pro"문자열 얻기
		//str.substring(beginIndex, endIndex);
		//beginIndex(포함)	/	endIndex(비포함)
		System.out.println("str.substring(4, 7) >>> "+ str.substring(4, 7));
		
		//부분문자열 ----> "Programming"문자열 얻기
		//str.substring(beginIndex); : 시작인덱스 ~ 끝인덱스 
		System.out.println("str.substring(4) >>> "+ str.substring(4));

		//특정인덱스의 문자 얻어오기: char str.charAt(int index)
		System.out.println("str.charAt(4) >>> "+ str.charAt(4));

		//특정문자의 인덱스 얻어오기: int str.indexOf(int ch)
		System.out.println("str.indexOf('P') >>> "+ str.indexOf('P'));

		//str에서 부분 문자열 "Programming"을 구하시오.(indexOf()사용)
		System.out.println("str.substring(str.indexOf('P')) >>> "+ str.substring(str.indexOf('P')));

		//첫번째 'a'문자의 인덱스를 구하시오
		System.out.println("str.indexOf('a') >>> "+ str.indexOf('a'));

		//세번째 'a'문자의 인덱스를 구하시오
		System.out.println("str.indexOf(\"am\") >>> "+ str.indexOf("am"));

		//마지막 'a'문자의 인덱스를 구하시오 (lastIndexOf()메소드: 뒤에서 부터 문자 검사)
		System.out.println("str.lastIndexOf('a') >>> "+ str.lastIndexOf('a'));

		//문자열 치환(대체) 'a' ---> 'o'
		//replace는 str을 변경해주지는 않음! 변경된 내용물을 반환하는 것 뿐
		System.out.println("str.replace('a', 'o') >>> "+ str.replace('a', 'o'));
		System.out.println("str >>> "+ str);

		//"JavaProgramming " ---> "자바Programming"으로 변경하시오.(replace()메소드사용)
		System.out.println(str.replace("JAVA", "자바"));
		System.out.println("str >>> "+ str);
		
		//문자열에 공백 추가!! str앞에 공백2개 , 뒤에 공백2개 추가
		str = "  " + str + "  ";
		System.out.println("str >>> "+ str);
		System.out.println("str 문자열 길이 >>> " + str.length());
		
		//공백 제거!!(문자열 앞뒤 연속된 공백제거)
		//trim도 str을 변경해주지는 않음! 변경된 내용물을 반환하는 것 뿐
		str = str.trim();
		System.out.println("str >>> " + str);
		System.out.println("str 문자열 길이 >>> " + str.length());
	}
}
