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
	문제1) bt버튼을 클릭하면 상단타이틀을 변경
			- 한번 누를 때마다 카운트 수를 표시
			---> 한번 클릭 : 스레드시계[1]
			---> 한번 클릭 : 스레드시계[2]
			---> 한번 클릭 : 스레드시계[3]
			
	문제2) la에 현재시간을 1초 단위로 출력하시오
			---> 15시 02분 30초 
*/

public class ThreadClock extends Frame implements ActionListener, Runnable{
	Label la;
	Panel p;
	Button bt;
	int count;
	
	public ThreadClock() throws InterruptedException {
	   setTitle("스레드시계");
	   la = new Label("");

	   p = new Panel();
       bt = new Button("클릭");
	   
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
		setTitle("스레드시계["+ ++count + "]");
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
			     String str=h+"시 "+m+"분 "+s+"초";
			     la.setText(str);
			   }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}