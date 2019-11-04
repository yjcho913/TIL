package com.scsa.JAVA20191104;

/*
	<HelloEventTest.java>
	- 기능정의
	   1. '안녕'버튼을 클릭했을 때
	      ==> 상단 텍스트필드에 "자바초급안녕~!!"(자바초급 Checkbox선택시)
	          상단 텍스트필드에 "자바중급안녕~!!"(자바중급 Checkbox선택시)
	          상단 텍스트필드에 "자바고급안녕~!!"(자바고급 Checkbox선택시)
	                  
	   2. '지우기'버튼을 클릭했을 때
	      ==> 상단 텍스트필드의 내용 지우기
	          
	   3. '종료'버튼을 클릭했을 때
	      ==> (응용)프로그램 종료
	          JavaApplication 종료   
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
	컴포넌트에 기능 부여 ===> 기능 처리!
	
	1. 이벤트 소스 분석
		- 이벤트 소스 후보 : TextField tf;
							 Checkbox cb1, cb2, cb3; 
  							 Button bt_hello, bt_clear, bt_exit;
  		- Button --> 버튼을 클릭했을 때
  				 --> add ~ Listener() 메소드 찾기
  	
  	2. addActionListener() ---> ActionListener 인터페이스!
  	3. 이벤트소스명.addActionListener(이벤트핸들러위치);
 */

public class HelloEventTest extends Frame implements ActionListener{
	TextField tf;
	Checkbox cb1, cb2, cb3; 
  	Button bt_hello, bt_clear, bt_exit;
  
  	Panel northp, centerp, southp;
	
  	CheckboxGroup grade;
  
  	public HelloEventTest() {
  		setTitle("안녕이벤트");
	  
  		tf = new TextField(15);
	
  		grade = new CheckboxGroup();
	
  		// 'grade' 라는 그룹! --> 하나만 선택 가능
  		cb1 = new Checkbox("자바초급",grade,true);
  		cb2 = new Checkbox("자바중급",grade,false);
  		cb3 = new Checkbox("자바고급",grade,false);

  		bt_hello = new Button("안녕");
  		bt_clear = new Button("지우기");
  		bt_exit = new Button("종료");
	
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
	  	// 익명의 내부 클래스를 활용하면 각각의 버튼에 대한 액션 정의가 가능
	  	// if문 필요없이 각각의 메소드 정의 가능
	  	bt_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("익명의 내부클래스 사용");
				System.exit(0);
			}
		});
	  	
	  	addWindowListener(new WindowAdapter() {
	  		public void windowClosing(WindowEvent e) {
	  			System.exit(0);
	  		}
		});
	  	
	  	
  }//생성자
  	
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 핸들러(처리부)
		
		// 매개변수 e를 통해 이벤트 소스의 정보를 얻어올 수 있음
		Object ob = e.getSource();			// 이벤트 소스의 주소(레퍼런스) 반환
		// ob = 601호 또는 602호 또는 603호
		String str = e.getActionCommand();	// **버튼의 경우** Label 텍스트 반환
		// str = "안녕" 또는 "지우기" 또는 "종료"
		
		
		if(ob == bt_hello) { // 주소 비교이기 때문에 '==' 사용!
			System.out.println("안녕 출력");
			
			String selectedTxt = grade.getSelectedCheckbox().getLabel();
			tf.setText("HELLO " + selectedTxt);			// 텍스트 값 설정
			// String s = tf.getText();		// 텍스트 값 얻어오기
		}
		else if(ob == bt_clear) {
			System.out.println("글자 지우기");
			tf.setText("");
		}
		else if(ob == bt_exit) {
			System.out.println("프로그램 종료");
			System.exit(0);
		}
	}
	
  	public static void main(String[] args) {
  		new HelloEventTest();
  	}
}