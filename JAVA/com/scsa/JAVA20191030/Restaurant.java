package com.scsa.JAVA20191030;

public class Restaurant implements MenuPan{
	// 오버라이딩 시에, 인터페이스의 접근제한자는 public!
	@Override
	public void 짜장면() {
		System.out.println("PRINT 짜장면");
	}

	@Override
	public void 짬뽕() {
		System.out.println("PRINT 짬뽕");
	}

	@Override
	public void 볶음밥() {
		// 빈 메소드 가능
	}
	
	// 해당 인터페이스 내에 없는 메소드 추가 가능
	public void 초밥() {
		System.out.println("PRINT 초밥");
	}
}
