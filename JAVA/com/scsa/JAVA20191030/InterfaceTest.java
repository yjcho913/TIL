package com.scsa.JAVA20191030;

public class InterfaceTest {
	public static void main(String[] args) {
		MenuPan menu;
		// MenuPan을 상속받은 Restaurant 클래스로 메모리 할당
		menu = new Restaurant();
		
		menu.짜장면();
		menu.짬뽕();
//		menu.초밥();	// 에러 --> MenuPan 타입이기 때문
	}
}