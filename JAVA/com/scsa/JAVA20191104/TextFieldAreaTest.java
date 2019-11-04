package com.scsa.JAVA20191104;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
	// TextField : ���� �Է�
	TextField tf1, tf2;
	// TextArea : ������ �Է�
	TextArea ta;
	Label la;
	Panel southp;	// "South"������ �ΰ� �̻��� ������Ʈ�� ���̱� ���� 'panel' ���
	Panel northp;
	
	public TextFieldAreaTest() {
		
		setTitle("TextFieldArea�׽�Ʈ");
		
		// ������Ʈ �ʱ�ȭ
		// tf1�� columns ���� �ǹ̰� ����. ������ ���̿� ���� ��������
		// ���� ������ ���ؼ��� panel�� ���ƾ� ��.
		tf1 = new TextField(15);
		// �ʺ� ����. frame�� �ƴ� panel�� ��ġ�ϱ� ������ column�� ���ǹ���
		// tf2 = new TextField(columns);	
		tf2 = new TextField(15);
		ta = new TextArea();
		la = new Label("�����̸�: ");
		
		// panel ���� �� �ʱ�ȭ
		southp = new Panel();
		southp.setLayout(new FlowLayout());
		southp.add(la);
		southp.add(tf2);
		
		northp = new Panel();
		// panel�� �⺻ layout : FlowLayout!
		// frame�� �⺻ layout : BorderLayout!
		northp.add(tf1);
		
		// ������Ʈ ��ġ
		setLayout(new BorderLayout());
		add("North", northp);
		add("Center", ta);
		add("South", southp);
		
		// ������ ���� : Background
		// ���ڻ� ���� : Foreground
		// northp.setBackground(Color c);
		// Color Ŭ���� �ȿ��� static field�� ���ǵǾ� ����
		northp.setBackground(Color.GREEN);
		southp.setBackground(Color.PINK);
		southp.setForeground(Color.RED);
		
		
		
		// ������
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextFieldAreaTest();
	}
}
