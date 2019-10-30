package com.scsa.JAVA20191030;

abstract class Shape{
	// 선언된 메소드에는 abstract 붙이기
	// interface와 다르게, 자유롭게 접근제한자 사용 가능
	// 접근 제한자 : default
	abstract void draw();
}

class Rectangle extends Shape{
	@Override
	void draw() {
		System.out.println("DRAW RECTANGLE");
	}
}
class Circle extends Shape{
	@Override
	// default 보다 범위가 넓은 접근 제한자
	protected void draw() {
		System.out.println("DRAW CIRCLE");
	}
}
class Triangle extends Shape{
	@Override
	// default 보다 범위가 넓은 접근 제한자
	public void draw() {
		System.out.println("DRAW TRIANGLE");
	}
}

public class AbstractClassTest {
	// main은 static이 붙었고, drawTest는 static이 없기 때문에 다른 메모리 상에 위치
	// new를 통해서만 호출이 가능
	// public static void drawTest()로 선언한다면, new 없이 호출 가능
	public static void drawTest(Shape s) {
		s.draw();
	}
	
	public static void main(String[] args) {
		// Shape s = new Rectangle();
		// "자식은 부모다!", 자식은 부모로 형변환 가능
		drawTest(new Rectangle());
		drawTest(new Circle());
		drawTest(new Triangle());
	}
}