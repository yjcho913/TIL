package com.scsa.JAVA20191106;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogTest extends JFrame{
	
   public DialogTest() {
	 setTitle("��ȭ���� �׽�Ʈ");

	 setBounds(600,400, 300,300);//x,y    width,height
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
//	 1. �޽��� ��ȭ����
//	 void JOptionPane.showMessageDialog(Component parentComponent, Object message);
//	 JOptionPane.showMessageDialog(this, "��ȭ���ھȳ�~!!");
	 
//	 2. �Է� ��ȭ����  - ���� Promptâ
//	 String JOptionPane.showInputDialog(parentComponent, message)
//	 String movie = JOptionPane.showInputDialog(this, "�����ϴ� ��ȭ��?");
//	 System.out.println("��ȭ����: "+ movie);//Ȯ��,���,X��ư : �Էµ� ���ڿ� �Ǵ� ���ڿ�, null, null
	 
//	 3. Ȯ�� ��ȭ����
//	 int JOptionPane.showConfirmDialog(parentComponent, message)
	 int t  = JOptionPane.showConfirmDialog(this, "��������?");
	 System.out.println("T="+ t);//��,�ƴϿ�,���,X��ư   :  0,1,2,-1 
	 
   }//������
	
   public static void main(String[] args) {
	  new DialogTest();
   }
}


