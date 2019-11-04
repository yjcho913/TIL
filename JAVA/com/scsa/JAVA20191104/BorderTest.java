package com.scsa.JAVA20191104;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest {
	// GUI - 컴포넌트, 컨테이너의 조합 클래스
	// 컴포넌트, 컨테이너의 선언
	Button bt1, bt2, bt3, bt4, bt5;
	Frame f;
	
	public BorderTest() {
		// 객체 생성
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		bt5 = new Button("5");
		f = new Frame("BORDER TEST");	// TITLE
		
		// 속성 설정
		// 레이아웃 방식 설정
		f.setLayout(new BorderLayout());
		
		// 컨테이너에 컴포넌트 붙이기
		// 컨테이너명.add(위치, 컴포넌트);
		// 만약 bt1을 center에 다시 붙인다면, north의 버튼을 회수하고 center에 붙임
		// 5개를 다 할 필요 없음
		f.add("North", bt1);
		f.add("East", bt2);
		f.add("South", bt3);
		f.add("West", bt4);
		f.add("Center", bt5);
		
		// 마무리 (컨테이너의 사이즈, 보이기 설정)
		// f.setSize(int width, int height);
		f.setSize(300, 300);
		f.setVisible(true);
		f.setTitle("Border Test");
	}
	
	public static void main(String[] args) {
		// FlowTest ft = new FlowTest();
		// 만약 생성자 호출만 필요하다면,
		new BorderTest();
	}
}
