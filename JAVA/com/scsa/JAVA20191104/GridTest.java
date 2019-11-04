package com.scsa.JAVA20191104;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest extends Frame{ // this == Frame
	// GUI - 컴포넌트, 컨테이너의 조합 클래스
	// 컴포넌트의 선언 (컨테이너는 선언할 필요 없음)
	Button bt1, bt2, bt3, bt4, bt5;
	
	public GridTest() {
		// 상위 클래스(Frame) 생성자 호출
		super("GRID TEST");
		
		// 객체 생성
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		bt5 = new Button("5");
		
		// 속성 설정
		// 레이아웃 방식 설정
		// this.setLayout(new GridLayout(rows, cols));
		this.setLayout(new GridLayout(2, 3));
		
		// 컨테이너에 컴포넌트 붙이기
		// this 생략 가능
		this.add("North", bt1);
		this.add("East", bt2);
		this.add("South", bt3);
		this.add("West", bt4);
		this.add("Center", bt5);
		
		// 마무리 (컨테이너의 사이즈, 보이기 설정)
		// f.setSize(int width, int height);
		this.setSize(500, 300);
		this.setVisible(true);
		this.setTitle("Grid Test");
	}
	
	public static void main(String[] args) {
		// FlowTest ft = new FlowTest();
		// 만약 생성자 호출만 필요하다면,
		new GridTest();
	}
}
