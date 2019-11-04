package com.scsa.JAVA20191104;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 우측 상단의 x 버튼 클릭 ---> 프로그램 종료
//WindowListener(인터페이스)	---> WindowAdaptor(클래스)
// WindowAdaptor : WindowListener를 implement해서 만들어진 추상 클래스
// WindowListener의 메소드들이 정의되어 있음!
public class WindowCloseTest2 extends WindowAdapter{
	
	Frame f;
	
	public WindowCloseTest2() {
		f = new Frame();
		f.setSize(300,300);
		f.setVisible(true);
		
		// 이벤트소스.add~Listener(이벤트핸들러의 위치)
		f.addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest2();
	}
	
	// 모든 함수를 overriding할 필요 없음
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료");
		System.exit(0);
	}
}
