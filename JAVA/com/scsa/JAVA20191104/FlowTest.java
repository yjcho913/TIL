package com.scsa.JAVA20191104;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
	// GUI - 컴포넌트, 컨테이너의 조합 클래스
	// 컴포넌트, 컨테이너의 선언
	Button bt1, bt2, bt3;
	Frame f;
	
	public FlowTest() {
		// 객체 생성
		bt1 = new Button("행복버튼1");
		bt2 = new Button("행복버튼2");
		bt3 = new Button("행복버튼3");
		f = new Frame();
		
		// 속성 설정
		// 레이아웃 방식 설정
		f.setLayout(new FlowLayout());
		
		// 컨테이너에 컴포넌트 붙이기
		// 컨테이너명.add(컴포넌트);
		f.add(bt1);
		f.add(bt2);
		f.add(bt3);
		
		// 마무리 (컨테이너의 사이즈, 보이기 설정)
		// f.setSize(int width, int height);
		f.setSize(300, 300);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		// FlowTest ft = new FlowTest();
		// 만약 생성자 호출만 필요하다면,
		new FlowTest();
	}
}
