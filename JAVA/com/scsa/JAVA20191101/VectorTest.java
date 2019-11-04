package com.scsa.JAVA20191101;

import java.util.Enumeration;
import java.util.Vector;

class A{
	void hello() {
		System.out.println("HELLO!!!");
	}
}

public class VectorTest {	
	public static void main(String[] args) {
		// 가변길이 배열, 참조(주소)를 담는 배열
//		Vector v = new Vector();	// 기본 방크기 : 10
		Vector v = new Vector(5); 	// 방크기 5로 지정	
		System.out.println("벡터의 방 크기 >>> "+ v.capacity());	// 10 출력
		System.out.println("============================");
		
		// 데이터 담기
		//v.add(Object e);						: 데이터 순차적 집어넣기
		//v.add(int index, Object element);		: 데이터 끼워넣기
		v.add(100);				// new Integer(100)
		v.add(true);			// new Boolean(true)
		v.add("HELLO VECTOR");	// new String("HELLO VECTOR")
		v.add(new A());
		A a = new A();
		v.add(a);
		v.add(3.14);
		
		
		// 데이터 출력
		Enumeration enu = v.elements();
		// enu = [100, true, "HELLO VECTOR", ...];
		System.out.println("사이즈 확장 후 벡터의 방 크기 >>> "+ v.capacity());	// 10 출력
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		System.out.println("============================");
		
		
		// 인덱스를 통한 전체 데이터 출력
		for (int i = 0; i < v.size(); i++) {
			System.out.println("인덱스[" + i + "] >>> " + v.get(i));
		}
		
		
		// 문제 ) 4번째(인덱스 3)로 입력한 A 클래스의 hello() 메소드 호출
		// get의 리턴타입 : Object
		Object ob = v.get(3);
		((A)ob).hello();
		// A a2 = (A)ob;
		// a2.hello();
		
		
		// JDK5부터 제네릭 사용 ---> 명료성 UP
		// Vector<A> v2 = new Vector<A>();
		// JDK7부터 뒤의 <>는 자료형의 명시 생략 가능
		// 앞으로 해당 자료형만 저장할 것임!
		Vector<A> v2 = new Vector<>();
		v2.add(a);
//		v2.add("HELLO");	//에러, A 자료형만 가능
		
		// get의 리턴타입 : A
		v2.get(0).hello();
		
		
		// 삭제
		Vector<String> v3 = new Vector<>();
		v3.add("CHO");
		v3.add("KIM");
		v3.add("LEE");
		
		for(String str : v3) {
			System.out.println(str);
		}
		
		System.out.println("KIM이 포함되어있습니까? >>> " + v3.contains("KIM"));
		System.out.println("PARK이 포함되어있습니까? >>> " + v3.contains("PARK"));
		
		// KIM 삭제 (인덱스 사용)
		v3.remove(1);
		System.out.println("=== KIM 삭제 후 출력 ===");
		for(String str : v3) {
			System.out.println(str);
		}
		// LEE 삭제 (요소 사용)
		v3.remove("LEE");
		System.out.println("=== LEE 삭제 후 출력 ===");
		for(String str : v3) {
			System.out.println(str);
		}
		
		
	}
}
