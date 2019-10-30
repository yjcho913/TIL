package com.scsa.JAVA20191030;

class My{
	String name;

	My(){//기본 생성자
		this("CHO");
	}
	
/*
	// 마우스 우클릭 -> Source -> Generate Constructors using Fields
	public My(String name) {
		// 부모 생성자 호출, default로 생성됨
		// 부모 멤버에 대한 메모리 할당을 위해 호출
		super();
		this.name = name;
	}
*/
	
	My(String name){//오버로딩 생성자
		
//		name = name;		// null 출력
							// 지역변수 name = 지역변수 name
		
		// 멤버 변수와 지역 변수를 구분
		this.name = name;
	}
}

public class ThisTest {
	public static void main(String[] args) {
		My m = new My();
		System.out.println("name : " + m.name);
	}
}