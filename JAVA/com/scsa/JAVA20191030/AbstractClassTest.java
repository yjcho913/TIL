package com.scsa.JAVA20191030;

abstract class Shape{
	// ����� �޼ҵ忡�� abstract ���̱�
	// interface�� �ٸ���, �����Ӱ� ���������� ��� ����
	// ���� ������ : default
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
	// default ���� ������ ���� ���� ������
	protected void draw() {
		System.out.println("DRAW CIRCLE");
	}
}
class Triangle extends Shape{
	@Override
	// default ���� ������ ���� ���� ������
	public void draw() {
		System.out.println("DRAW TRIANGLE");
	}
}

public class AbstractClassTest {
	// main�� static�� �پ���, drawTest�� static�� ���� ������ �ٸ� �޸� �� ��ġ
	// new�� ���ؼ��� ȣ���� ����
	// public static void drawTest()�� �����Ѵٸ�, new ���� ȣ�� ����
	public static void drawTest(Shape s) {
		s.draw();
	}
	
	public static void main(String[] args) {
		// Shape s = new Rectangle();
		// "�ڽ��� �θ��!", �ڽ��� �θ�� ����ȯ ����
		drawTest(new Rectangle());
		drawTest(new Circle());
		drawTest(new Triangle());
	}
}