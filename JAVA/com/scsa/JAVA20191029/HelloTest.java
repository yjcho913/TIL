package com.scsa.JAVA20191029;
/*
 * 패키지:	서로 관련있는 클래스들의 묶음
 * 			NameSpace(이름공간) 개념 - 이름 충돌 방지
 * 			JVM이 인식하는 폴더
 * 			자바에서는 2개 이상의 패키지명을 사용하는 것을 권장
 * 			현재 클래스의 위치를 표현
 */

import com.scsa.JAVA20191029.pack1.A;

// import : 현재 클래스에서 사용할 외부 클래스의 위치를 표현
// 형식 : import 패키지명.클래스명;

// import com.scsa.JAVA20191029.pack1.*;
// '*'의 의미 : pack1 패키지 밑의 모든 클래스를 현 클래스에서 사용하겠음

public class HelloTest {
	public static void main(String[] args) {
		System.out.println("Hellooooooooooooooooo!");
		A a = new A();
		a.hello();
	}
}
