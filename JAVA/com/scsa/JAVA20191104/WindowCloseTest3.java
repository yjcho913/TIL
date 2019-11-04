package com.scsa.JAVA20191104;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// ���� ����� x ��ư Ŭ�� ---> ���α׷� ����
//WindowListener(�������̽�)	---> WindowAdaptor(Ŭ����)

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
		
		// �̺�Ʈ�ҽ�.add~Listener(�̺�Ʈ�ڵ鷯�� ��ġ)
//		f.addWindowListener(new MyHandler());
		// �͸��� ���� Ŭ����
		f.addWindowListener(new WindowAdapter(){
			// WindowAdapter : �߻� Ŭ���� --> new ����
			// new ??? extends WindowAdapter�� ���� �ǹ�!(WindowAdapter Ŭ���� ���� x)
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
