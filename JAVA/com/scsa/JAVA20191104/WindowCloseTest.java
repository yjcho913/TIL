package com.scsa.JAVA20191104;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// ���� ����� x ��ư Ŭ�� ---> ���α׷� ����
// WindowListener
public class WindowCloseTest extends Frame implements WindowListener{
	
	
	public WindowCloseTest() {
		setSize(300,300);
		setVisible(true);
		
		// �̺�Ʈ�ҽ�.add~Listener(�̺�Ʈ�ڵ鷯�� ��ġ)
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
		System.out.println("���α׷� ����");
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
