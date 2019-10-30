package com.scsa.JAVA20191030;

public class InheritanceTest {
	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.hello();
		p.hello("YJ");
		p.print();
		System.out.println("=============");
		
		Child c = new Child();
		c.hello();
		// Parent에는 toString 메소드가 없지만, 컴파일러가 자동으로 Object 클래스를 상속 받음
		System.out.println(c.toString());
		// 오버라이딩된 메소드
		c.print();
		System.out.println("=============");

		Parent p2 = new Child();
		p2.hello("YJ");
		// p2.goodBye();	// 오버라이딩 메소드가 아니기 때문에 에러
		p2.print();			// 자식의 오버라이딩 메소드
		System.out.println("i = " + p2.i);	// 필드는 오버라이딩과 무관! 따라서 부모의 i 출력
		System.out.println("=============");

		/*
		 기본 : 부모 레퍼런스 통해 자식 호출 불가
		 예외 : 자식의 오버라이딩 메소드
		 */
		
		Child c2;
		// c2 = (Child) p;	// p가 Child와 다른 메모리를 할당받음 --> runtime error
		c2 = (Child) p2;	// p2가 Child와 같은 메모리를 할당받았기 때문에 가능
		c2.goodBye();		// 오버라이딩 메소드가 아니어도 Child로 탈바꿈했기 때문에 가능
		System.out.println("i = " + c2.i);
		System.out.println("=============");

	}
}
