package com.scsa.JAVA20191030;

public class Child extends Parent{
	
	int i = 33;
	int j = 22;
	
	// 부모의 메소드를 올바르게 오버라이딩했는지 확인해 줌
	@Override
	void print() {
		// 부모의 메소드를 참조 받고, 뒤에 덧붙이겠음1
		// super.print();
		
		// 부모의 메소드를 완전히 재정의!
		System.out.println("Print Child");
	}
	
	void goodBye() {
		System.out.println("GOOD BYE");
	}
}
