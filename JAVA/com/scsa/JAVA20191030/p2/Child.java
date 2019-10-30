package com.scsa.JAVA20191030.p2;

import com.scsa.JAVA20191030.p1.Parent;

public class Child extends Parent{
	void callTest() {
		m1();
		m2();
//		m3();	//에러 - default
//		m4();	//에러 - private
	}
}
