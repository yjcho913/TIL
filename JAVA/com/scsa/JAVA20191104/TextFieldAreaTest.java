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
	// TextField : 한줄 입력
	TextField tf1, tf2;
	// TextArea : 여러줄 입력
	TextArea ta;
	Label la;
	Panel southp;	// "South"영역에 두개 이상의 컴포넌트를 붙이기 위해 'panel' 사용
	Panel northp;
	
	public TextFieldAreaTest() {
		
		setTitle("TextFieldArea테스트");
		
		// 컴포넌트 초기화
		// tf1의 columns 값은 의미가 없음. 영역의 길이에 따라 유동적임
		// 길이 설정을 위해서는 panel에 놓아야 함.
		tf1 = new TextField(15);
		// 너비 지정. frame이 아닌 panel에 위치하기 때문에 column이 유의미함
		// tf2 = new TextField(columns);	
		tf2 = new TextField(15);
		ta = new TextArea();
		la = new Label("파일이름: ");
		
		// panel 선언 및 초기화
		southp = new Panel();
		southp.setLayout(new FlowLayout());
		southp.add(la);
		southp.add(tf2);
		
		northp = new Panel();
		// panel의 기본 layout : FlowLayout!
		// frame의 기본 layout : BorderLayout!
		northp.add(tf1);
		
		// 컴포넌트 배치
		setLayout(new BorderLayout());
		add("North", northp);
		add("Center", ta);
		add("South", southp);
		
		// 바탕색 설정 : Background
		// 글자색 설정 : Foreground
		// northp.setBackground(Color c);
		// Color 클래스 안에는 static field가 정의되어 있음
		northp.setBackground(Color.GREEN);
		southp.setBackground(Color.PINK);
		southp.setForeground(Color.RED);
		
		
		
		// 마무리
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextFieldAreaTest();
	}
}
