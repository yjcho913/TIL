package com.scsa.JAVA20191031;

class AA{
	public void hello() {
		System.out.println("HELLO");
	}
	public void method(CC c) {
		c.print();
	}
}

class CC{
	public void print() {
		System.out.println("PRINT CC");
	}
}

public class AnonymousTest {
	public static void main(String[] args) {
		// {} : 클래스 영역 괄호
		// 메소드 오버라이딩과 같은 개념
		AA a = new AA() {
			public void hello() {
				System.out.println("HELLOOOOOO");
			}
		};
		
		a.hello();	// HELOOOOOOO 출력
		System.out.println("===============");
		
		
		CC c = new CC();
		a.method(c);
		// 메소드 오버라이딩
		a.method(new CC() {
			public void print() {
				System.out.println("PRINT SCSA");
			}
		});
		System.out.println("===============");
		/*
		 위의 new CC(){}
		 --> CC : 클래스(추상 클래스)
		 	 class My extends CC{
		 	 	// 오버라이딩 메소드 구현
		 	 }
 		 --> CC : 인터페이스
		 	 class My implements CC{
		 	 	// 오버라이딩 메소드 구현
		 	 }
		 * 하지만 'My'가 필요없기 때문에 'anonymous' 가 붙는다!
		 */
	}
}
