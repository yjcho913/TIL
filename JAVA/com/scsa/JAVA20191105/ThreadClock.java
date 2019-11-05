package com.scsa.JAVA20191105;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
	����1) bt��ư�� Ŭ���ϸ� ���Ÿ��Ʋ�� ����
			- �ѹ� ���� ������ ī��Ʈ ���� ǥ��
			---> �ѹ� Ŭ�� : ������ð�[1]
			---> �ѹ� Ŭ�� : ������ð�[2]
			---> �ѹ� Ŭ�� : ������ð�[3]
			
	����2) la�� ����ð��� 1�� ������ ����Ͻÿ�
			---> 15�� 02�� 30�� 
*/

public class ThreadClock extends Frame implements ActionListener, Runnable{
	Label la;
	Panel p;
	Button bt;
	int count;
	
	public ThreadClock() throws InterruptedException {
	   setTitle("������ð�");
	   la = new Label("");

	   p = new Panel();
       bt = new Button("Ŭ��");
	   
	   p.add(la);
	      
	   add("North",p);
	   add("South",bt);
	   
	   setSize(300,300);
	   setVisible(true);
	   
	   bt.addActionListener(this);
	   new Thread(this).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setTitle("������ð�["+ ++count + "]");
	}
	
	public static void main(String[] args) throws Exception{
	    new ThreadClock();
	}

	@Override
	public void run() {
		try {
			while(true) {
				 Thread.sleep(1000);  
			     Calendar cal = new GregorianCalendar();
			     int h=cal.get(Calendar.HOUR_OF_DAY);
			     int m=cal.get(Calendar.MINUTE);
			     int s=cal.get(Calendar.SECOND);
			     String str=h+"�� "+m+"�� "+s+"��";
			     la.setText(str);
			   }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}