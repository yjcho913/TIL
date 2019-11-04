package com.scsa.JAVA20191104;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends Frame implements ActionListener{
	
	Button bt;
	// Button 클래스의 메소드 중 add ~ Listener() 메소드 찾기
	// ===> addActionListener()
	// ActionListener 인터페이스 상속, 구현(오버라이딩)
	
	public EventTest() {
		bt = new Button("나 버튼");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300, 300);
		setVisible(true);
		bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new EventTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트 처리부, Event Handler Method
		// 버튼일 눌렸을 때 처리할 기능 정의
		System.out.println("HELLO BUTTON!");
		System.exit(0);
	}
}
