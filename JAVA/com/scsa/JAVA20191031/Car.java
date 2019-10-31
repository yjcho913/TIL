package com.scsa.JAVA20191031;

public class Car {
	String carName;
	int wheelNum;
	int velocity;
	
	public Car() {}
	
	// 오버로딩 생성자
	// 기본생성자를 사용하고 싶다면 명시해줘야 함
	public Car(String carName, int wheelNum, int velocity) {
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}
	
	// equals()와 toString() 메소드는 오버라이딩 메소드 (자식 메소드)
	// 최상위객체인 Object에 정의되어 있음
	// 없어도 에러가 나지 않음
	// 하지만 의도한 바와는 다른 결과가 나올 수 있음
	public boolean equals(Car c) {
		if(this.carName == c.carName &&
		   this.wheelNum == c.wheelNum &&
		   this.velocity == c.velocity) {
			return true;
		}
		return false;
	}

	// 우클릭 - Source - Generate toString()
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", wheelNum=" + wheelNum + ", velocity=" + velocity + "]";
	}
	
	
	public static void main(String[] args) {
		Car c1 = new Car("Sonata", 4, 100);
		Car c2 = new Car("Avante", 4, 200);
		Car c3 = c1;	// 주소 복사
		Car c4 = new Car("Sonata", 4, 100);
		
		System.out.println(c1.toString());
		// 객체를 출력하면, toString() 메소드를 자동 호출
		System.out.println("c1 출력 : " + c1);
		System.out.println(c2.toString());
		System.out.println("===============");
		
		
		System.out.print("c1과 c2의 객체 주소");
		if(c1 == c2) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		
		// c1의 주소를 c3이 복사
		System.out.print("c1과 c3의 객체 주소");
		if(c1 == c3) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		System.out.println("===============");

		
		System.out.print("c1과 c2의 객체 내용");
		if(c1.equals(c2)) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		
		System.out.print("c1과 c4의 객체 내용");
		if(c1.equals(c4)) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		System.out.println("===============");

		
		/*
		★★★★★ 클래스 타입의 c1과 c2 비교 방법 ★★★★★
		1. (객체) 주소 비교
		- 등가 연산자(==) 사용
		- c1 == c2
		
		2. 내용 비교
		- equals() 메소드 사용
		- c1.equals(c2)
		
		* String도 클래스 타입
		 */
	}
}