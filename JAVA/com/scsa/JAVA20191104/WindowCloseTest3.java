package com.scsa.JAVA20191104;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 우측 상단의 x 버튼 클릭 ---> 프로그램 종료
//WindowListener(인터페이스)	---> WindowAdaptor(클래스)

/*
class MyHandler extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.out.println("MY HANDLER");
		System.exit(0);
	}
}
*/

public class WindowCloseTest3 extends Thread{
	
	Frame f;
	
	public WindowCloseTest3() {
		f = new Frame();
		f.setSize(300,300);
		f.setVisible(true);
		
		// 이벤트소스.add~Listener(이벤트핸들러의 위치)
//		f.addWindowListener(new MyHandler());
		// 익명의 내부 클래스
		f.addWindowListener(new WindowAdapter(){
			// WindowAdapter : 추상 클래스 --> new 못함
			// new ??? extends WindowAdapter와 같은 의미!(WindowAdapter 클래스 생성 x)
			public void windowClosing(WindowEvent e) {
			System.out.println("MY HANDLER");
			System.exit(0);
		}});
		
//		f.addWindowListener(new WindowListener() {
		// implements WindowListener
//
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}});
	}
	
	public static void main(String[] args) {
		new WindowCloseTest3();
	}
}
