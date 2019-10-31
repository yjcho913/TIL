package com.scsa.JAVA20191031;

class Base{
	int num1;
	static int num2;	// 클래스 변수, static 변수
}

class A{
	void increment() {
		Base b = new Base();
		b.num1++;
		Base.num2++;
	}
}

class B{
	int num3;
	void increment() {
		Base b = new Base();
		b.num1++;
		Base.num2++;
		num3 = b.num1;
	}
}

public class StaticTest {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		a.increment();
		b.increment();
		
		System.out.println("Base num1 : " + b.num3);		// 1 출력
		System.out.println("Base num2 : " + Base.num2);		// 2 출력
	}
}
