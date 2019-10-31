package com.scsa.JAVA20191031;

class NestingClass{ // 외부 클래스, outer 클래스, top-level 클래스
	int i = 11;
	
	void varPrintNesting() {
		System.out.println("i = " + i);
//		System.out.println("j = " + j);	// 에러
		// j를 가져오기 위해 객체 생성을 해야 함
		
		NestedClass nested = new NestedClass();
		System.out.println("j = " + nested.j);
		nested.varPrintNested();
		// 보통은 외부에 정의하고, 호출
	}
	
	class NestedClass{ // 내부 클래스, inner 클래스
		int j = 22;
		void varPrintNested() {
			System.out.println("j : " + j);
			System.out.println("i : " + i);
		}
	}
}
public class NestedClassTest { 
	public static void main(String[] args) {
		
		// 외부 클래스
		NestingClass nesting = new NestingClass();
		nesting.varPrintNesting();
		System.out.println("===============");
		
		// 내부 클래스도 호출 가능 (이런 경우 없음..)
		// 외부클래스명.내부클래스명 참조변수명;
		NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		nested.varPrintNested();
	}
}
