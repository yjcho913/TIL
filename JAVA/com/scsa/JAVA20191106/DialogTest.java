package com.scsa.JAVA20191106;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogTest extends JFrame{
	
   public DialogTest() {
	 setTitle("대화상자 테스트");

	 setBounds(600,400, 300,300);//x,y    width,height
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
//	 1. 메시지 대화상자
//	 void JOptionPane.showMessageDialog(Component parentComponent, Object message);
//	 JOptionPane.showMessageDialog(this, "대화상자안녕~!!");
	 
//	 2. 입력 대화상자  - 보통 Prompt창
//	 String JOptionPane.showInputDialog(parentComponent, message)
//	 String movie = JOptionPane.showInputDialog(this, "좋아하는 영화는?");
//	 System.out.println("영화제목: "+ movie);//확인,취소,X버튼 : 입력된 문자열 또는 빈문자열, null, null
	 
//	 3. 확인 대화상자
//	 int JOptionPane.showConfirmDialog(parentComponent, message)
	 int t  = JOptionPane.showConfirmDialog(this, "정말삭제?");
	 System.out.println("T="+ t);//예,아니오,취소,X버튼   :  0,1,2,-1 
	 
   }//생성자
	
   public static void main(String[] args) {
	  new DialogTest();
   }
}


