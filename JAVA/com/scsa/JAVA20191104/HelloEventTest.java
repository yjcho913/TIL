package com.scsa.JAVA20191104;

/*
	<HelloEventTest.java>
	- �������
	   1. '�ȳ�'��ư�� Ŭ������ ��
	      ==> ��� �ؽ�Ʈ�ʵ忡 "�ڹ��ʱ޾ȳ�~!!"(�ڹ��ʱ� Checkbox���ý�)
	          ��� �ؽ�Ʈ�ʵ忡 "�ڹ��߱޾ȳ�~!!"(�ڹ��߱� Checkbox���ý�)
	          ��� �ؽ�Ʈ�ʵ忡 "�ڹٰ�޾ȳ�~!!"(�ڹٰ�� Checkbox���ý�)
	                  
	   2. '�����'��ư�� Ŭ������ ��
	      ==> ��� �ؽ�Ʈ�ʵ��� ���� �����
	          
	   3. '����'��ư�� Ŭ������ ��
	      ==> (����)���α׷� ����
	          JavaApplication ����   
 */

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
	������Ʈ�� ��� �ο� ===> ��� ó��!
	
	1. �̺�Ʈ �ҽ� �м�
		- �̺�Ʈ �ҽ� �ĺ� : TextField tf;
							 Checkbox cb1, cb2, cb3; 
  							 Button bt_hello, bt_clear, bt_exit;
  		- Button --> ��ư�� Ŭ������ ��
  				 --> add ~ Listener() �޼ҵ� ã��
  	
  	2. addActionListener() ---> ActionListener �������̽�!
  	3. �̺�Ʈ�ҽ���.addActionListener(�̺�Ʈ�ڵ鷯��ġ);
 */

public class HelloEventTest extends Frame implements ActionListener{
	TextField tf;
	Checkbox cb1, cb2, cb3; 
  	Button bt_hello, bt_clear, bt_exit;
  
  	Panel northp, centerp, southp;
	
  	CheckboxGroup grade;
  
  	public HelloEventTest() {
  		setTitle("�ȳ��̺�Ʈ");
	  
  		tf = new TextField(15);
	
  		grade = new CheckboxGroup();
	
  		// 'grade' ��� �׷�! --> �ϳ��� ���� ����
  		cb1 = new Checkbox("�ڹ��ʱ�",grade,true);
  		cb2 = new Checkbox("�ڹ��߱�",grade,false);
  		cb3 = new Checkbox("�ڹٰ��",grade,false);

  		bt_hello = new Button("�ȳ�");
  		bt_clear = new Button("�����");
  		bt_exit = new Button("����");
	
  		northp = new Panel();
  		northp.setBackground(Color.YELLOW);
  		northp.add(tf);
	  
  		centerp = new Panel();
	  	centerp.setLayout(new GridLayout(3,1));
	  	centerp.add(cb1);
	  	centerp.add(cb2);
	  	centerp.add(cb3);
	  
	  	southp = new Panel();
	  	southp.setBackground(Color.PINK);
	  	southp.add(bt_hello);
	  	southp.add(bt_clear);
	  	southp.add(bt_exit);
	
	  	add("North",northp);
	  	add("Center",centerp);
	  	add("South",southp);
	
	  	setSize(300,300);
	  	setVisible(true);
	  	
	  	bt_hello.addActionListener(this);
	  	bt_clear.addActionListener(this);
//	  	bt_exit.addActionListener(this);
	  	// �͸��� ���� Ŭ������ Ȱ���ϸ� ������ ��ư�� ���� �׼� ���ǰ� ����
	  	// if�� �ʿ���� ������ �޼ҵ� ���� ����
	  	bt_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�͸��� ����Ŭ���� ���");
				System.exit(0);
			}
		});
	  	
	  	addWindowListener(new WindowAdapter() {
	  		public void windowClosing(WindowEvent e) {
	  			System.exit(0);
	  		}
		});
	  	
	  	
  }//������
  	
	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ �ڵ鷯(ó����)
		
		// �Ű����� e�� ���� �̺�Ʈ �ҽ��� ������ ���� �� ����
		Object ob = e.getSource();			// �̺�Ʈ �ҽ��� �ּ�(���۷���) ��ȯ
		// ob = 601ȣ �Ǵ� 602ȣ �Ǵ� 603ȣ
		String str = e.getActionCommand();	// **��ư�� ���** Label �ؽ�Ʈ ��ȯ
		// str = "�ȳ�" �Ǵ� "�����" �Ǵ� "����"
		
		
		if(ob == bt_hello) { // �ּ� ���̱� ������ '==' ���!
			System.out.println("�ȳ� ���");
			
			String selectedTxt = grade.getSelectedCheckbox().getLabel();
			tf.setText("HELLO " + selectedTxt);			// �ؽ�Ʈ �� ����
			// String s = tf.getText();		// �ؽ�Ʈ �� ������
		}
		else if(ob == bt_clear) {
			System.out.println("���� �����");
			tf.setText("");
		}
		else if(ob == bt_exit) {
			System.out.println("���α׷� ����");
			System.exit(0);
		}
	}
	
  	public static void main(String[] args) {
  		new HelloEventTest();
  	}
}