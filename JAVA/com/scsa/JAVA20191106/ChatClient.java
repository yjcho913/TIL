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
	//������ Center ---> JTextArea (������ ���� �޽����� ���)
	//������ South  ---> JTextField (�������� ���� �޽���)
	
	JTextArea ta;//JScrollPane�ʿ��� ������Ʈ: JList, JTable, JTextArea
	JScrollPane scroll_ta;
	Button bt_changeName;
	
	JTextField tf_send;
	
	JPanel southp;
	
	BufferedReader in;
	OutputStream out;
	String nickName;
	
    public ChatClient() {
    	setTitle("��ȭ��");
        ta = new JTextArea();
        ta.setFont(new Font("����ü", Font.BOLD, 20));
        ta.setLineWrap(true);//�ʺ�(����)�� �Ѿ�� �ؽ�Ʈ�� �ִٸ� �ڵ����� �ٹٲ� 
        scroll_ta = new JScrollPane(ta);//��ũ�ѹٰ� �����Ǵ� TextArea!!
        tf_send = new JTextField(15);
        tf_send.setFont(new Font("����ü", Font.BOLD, 20));
        bt_changeName = new Button("��ư (��:��ȭ����)");
                  
      
        southp = new JPanel();
        southp.add(tf_send);
        southp.add(bt_changeName);
        
        add("Center",scroll_ta);
        add("South",southp);
      
        setBounds(300,200,   600,600);
        nickName = JOptionPane.showInputDialog(this, "��ȭ�� : ");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        connectProcess();
        toServer("100|" + nickName);	//���� �ϸ�, in�� out �ʱ�ȭ�� �ȵǾ��ֱ� ������ nullpointerexception
        new Thread(this).start();
        tf_send.addActionListener(this);
        bt_changeName.addActionListener(this);

	}//������
    
    
    public void connectProcess() {//�������ϰ� �����ϴ� �۾�
    	try {
			Socket s = new Socket("localhost", 5000);
			System.out.println("���� ���� ����");
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//connectProcess
    
    
    public void toServer(String msg) {//�������� �޽��� ������
    	try {
			out.write((msg+"\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//toServer
    
    
//    public void fromServer(String msg) {//������ �޽��� �ϱ�
//    	while(true) {
//    		in.readLine();
//    	}
//    }
    
    public void run() {
    	// �������̵��޼ҵ� ---> throws Exception �Ұ�
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
			// �ؽ�Ʈ �ʵ忡 '����' �Է��� ������ ��
			String toMsg = tf_send.getText();
			if(toMsg.trim().length() == 0) return;
			toServer("200|" + toMsg);
			tf_send.setText("");
		}
		else if(ob == bt_changeName) {
	        nickName = JOptionPane.showInputDialog(this, "��ȭ�� : ");
			toServer("150|" + nickName);
		}
	}
    
    public static void main(String[] args) {
		new ChatClient();
	}//main
}