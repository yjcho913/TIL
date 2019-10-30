package com.scsa.JAVA20191030;

class Abc{
	/*
	 * 멤버변수 (field)는 초기값(기본값)이 존재
	 * 지역변수는 초기값 X	--> 초기화 후 사용해야 함
	 <기본값>
	 정수 : 0
	 실수 : 0.0
	 논리 : false
	 문자 : '\u0000' 
	 class 타입 : null
	 */
	int num;
	boolean bool;
	String str;
	
	// 생성자 : 초기화(값 할당) 메소드
	// 기본 생성자 : 인자가 없는 생성자
	Abc(){
		// 보통 멤버필드에 대한 초기화
		num = 10;
		bool = true;
		str = "CHO";
		System.out.println("기본 생성자");
	}
	
	// 오버로딩 생성자
	Abc(String name){
		str = name;
		System.out.println("오버로딩 생성자");
	}
	
	void print() {
		// int sum;	// 초기화하지 않아 compile error
		int sum = 100;
		
		System.out.println("PRINT sum : " + sum);
		System.out.println("PRINT int : " + num);
		System.out.println("PRINT boolean : " + bool);
		System.out.println("PRINT string : " + str);
	}
}

public class ConstructorTest {
	public static void main(String[] args) {
		// new --> 메모리 할당 + 생성자 호출
		// 메모리 할당 시 단 한번 호출!
		Abc abc = new Abc();	
		abc.print();
		System.out.println("=============");

		Abc abc2 = new Abc("CHOOOOOO");
		abc2.print();
		System.out.println("=============");
	}
}