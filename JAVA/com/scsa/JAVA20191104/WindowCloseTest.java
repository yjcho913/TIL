package com.scsa.JAVA20191104;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 우측 상단의 x 버튼 클릭 ---> 프로그램 종료
// WindowListener
public class WindowCloseTest extends Frame implements WindowListener{
	
	
	public WindowCloseTest() {
		setSize(300,300);
		setVisible(true);
		
		// 이벤트소스.add~Listener(이벤트핸들러의 위치)
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("프로그램 종료");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
