package com.scsa.JAVA20191030.p2;

import com.scsa.JAVA20191030.p1.Parent;

public class Other {
	void callTest() {
		Parent p = new Parent();
		p.m1();
//		p.m2();		// 에러 - protected
//		p.m3();		// 에러 - default
//		p.m4();		// 에러 - private
	}
}
