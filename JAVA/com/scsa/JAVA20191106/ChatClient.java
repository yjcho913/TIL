package com.scsa.JAVA20191106;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable, ActionListener{
	//프레임 Center ---> JTextArea (서버가 보낸 메시지를 출력)
	//프레임 South  ---> JTextField (서버에게 보낼 메시지)
	
	JTextArea ta;//JScrollPane필요한 컴포넌트: JList, JTable, JTextArea
	JScrollPane scroll_ta;
	Button bt_changeName;
	
	JTextField tf_send;
	
	JPanel southp;
	
	BufferedReader in;
	OutputStream out;
	String nickName;
	
    public ChatClient() {
    	setTitle("대화방");
        ta = new JTextArea();
        ta.setFont(new Font("굴림체", Font.BOLD, 20));
        ta.setLineWrap(true);//너비(가로)를 넘어가는 텍스트가 있다면 자동으로 줄바꿈 
        scroll_ta = new JScrollPane(ta);//스크롤바가 지원되는 TextArea!!
        tf_send = new JTextField(15);
        tf_send.setFont(new Font("굴림체", Font.BOLD, 20));
        bt_changeName = new Button("버튼 (라벨:대화명변경)");
                  
      
        southp = new JPanel();
        southp.add(tf_send);
        southp.add(bt_changeName);
        
        add("Center",scroll_ta);
        add("South",southp);
      
        setBounds(300,200,   600,600);
        nickName = JOptionPane.showInputDialog(this, "대화명 : ");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        connectProcess();
        toServer("100|" + nickName);	//위에 하면, in과 out 초기화가 안되어있기 때문에 nullpointerexception
        new Thread(this).start();
        tf_send.addActionListener(this);
        bt_changeName.addActionListener(this);

	}//생성자
    
    
    public void connectProcess() {//서버소켓과 연결하는 작업
    	try {
			Socket s = new Socket("localhost", 5000);
			System.out.println("서버 연결 성공");
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//connectProcess
    
    
    public void toServer(String msg) {//서버에게 메시지 보내기
    	try {
			out.write((msg+"\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//toServer
    
    
//    public void fromServer(String msg) {//서버의 메시지 일기
//    	while(true) {
//    		in.readLine();
//    	}
//    }
    
    public void run() {
    	// 오버라이딩메소드 ---> throws Exception 불가
    	try {
			while(true) {
				String fromMsg = in.readLine();
				ta.append(fromMsg + "\n");
				ta.setCaretPosition(ta.getText().length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//fromServer ---> run

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == tf_send) {
			// 텍스트 필드에 '엔터' 입력이 들어왔을 때
			String toMsg = tf_send.getText();
			if(toMsg.trim().length() == 0) return;
			toServer("200|" + toMsg);
			tf_send.setText("");
		}
		else if(ob == bt_changeName) {
	        nickName = JOptionPane.showInputDialog(this, "대화명 : ");
			toServer("150|" + nickName);
		}
	}
    
    public static void main(String[] args) {
		new ChatClient();
	}//main
}