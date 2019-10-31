package com.scsa.JAVA20191031;

public class Car {
	String carName;
	int wheelNum;
	int velocity;
	
	public Car() {}
	
	// �����ε� ������
	// �⺻�����ڸ� ����ϰ� �ʹٸ� �������� ��
	public Car(String carName, int wheelNum, int velocity) {
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}
	
	// equals()�� toString() �޼ҵ�� �������̵� �޼ҵ� (�ڽ� �޼ҵ�)
	// �ֻ�����ü�� Object�� ���ǵǾ� ����
	// ��� ������ ���� ����
	// ������ �ǵ��� �ٿʹ� �ٸ� ����� ���� �� ����
	public boolean equals(Car c) {
		if(this.carName == c.carName &&
		   this.wheelNum == c.wheelNum &&
		   this.velocity == c.velocity) {
			return true;
		}
		return false;
	}

	// ��Ŭ�� - Source - Generate toString()
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", wheelNum=" + wheelNum + ", velocity=" + velocity + "]";
	}
	
	
	public static void main(String[] args) {
		Car c1 = new Car("Sonata", 4, 100);
		Car c2 = new Car("Avante", 4, 200);
		Car c3 = c1;	// �ּ� ����
		Car c4 = new Car("Sonata", 4, 100);
		
		System.out.println(c1.toString());
		// ��ü�� ����ϸ�, toString() �޼ҵ带 �ڵ� ȣ��
		System.out.println("c1 ��� : " + c1);
		System.out.println(c2.toString());
		System.out.println("===============");
		
		
		System.out.print("c1�� c2�� ��ü �ּ�");
		if(c1 == c2) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ�");
		}
		
		// c1�� �ּҸ� c3�� ����
		System.out.print("c1�� c3�� ��ü �ּ�");
		if(c1 == c3) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ�");
		}
		System.out.println("===============");

		
		System.out.print("c1�� c2�� ��ü ����");
		if(c1.equals(c2)) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ�");
		}
		
		System.out.print("c1�� c4�� ��ü ����");
		if(c1.equals(c4)) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ�");
		}
		System.out.println("===============");

		
		/*
		�ڡڡڡڡ� Ŭ���� Ÿ���� c1�� c2 �� ��� �ڡڡڡڡ�
		1. (��ü) �ּ� ��
		- � ������(==) ���
		- c1 == c2
		
		2. ���� ��
		- equals() �޼ҵ� ���
		- c1.equals(c2)
		
		* String�� Ŭ���� Ÿ��
		 */
	}
}