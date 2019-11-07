package com.scsa.JAVA20191105;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class SimpleNotePad extends Frame implements ActionListener{
	
	TextArea ta;
	
	MenuBar bar;
	  Menu menu_file;
	     MenuItem item_open;
	     MenuItem item_save;
	     MenuItem item_exit;	     
	  Menu menu_help;
	  
	JFileChooser chooser;
	
	
    public SimpleNotePad() {
	  setTitle("자바메모장");
	
	  chooser = new JFileChooser();
	  
	  bar = new MenuBar();
	    menu_file = new Menu("File");
	       item_open = new MenuItem("열기");
	       item_save = new MenuItem("저장");
	       item_exit = new MenuItem("종료");
	       
	    menu_help = new Menu("Help");
	    
	    menu_file.add(item_open);
	    menu_file.add(item_save);
	    menu_file.addSeparator();//구분선 추가
	    menu_file.add(item_exit);
	    
	  bar.add(menu_file);   
	  bar.add(menu_help);
	  
	  setMenuBar(bar);	  
	  
	  ta = new TextArea();
	  
	  
	  add("Center",ta);
	  
	  setBounds(200,100, 600,600);
	  setVisible(true);
	  addWindowListener(new WindowAdapter() {
		   @Override
		public void windowClosing(WindowEvent e) {
		    System.exit(0);
		}
	   });
	  
	  item_open.addActionListener(this);
	  item_save.addActionListener(this);
	  item_exit.addActionListener(this);
	}//생성자
    
    
    //FROM(읽기객체): 파일   ------>  TO : TextArea
    public void openFile() {
    	//chooser.showOpenDialog(Component parent);
    	//parent: 어떤 컴포넌트 위에 Dialog를 위치시킬지
    	int t= chooser.showOpenDialog(this);
		FileReader fr = null;

    	try {
			if(t == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();//선택된 파일의 정보 얻기
				fr = new FileReader(f);
				char []cbuf = new char[1024];
				int i;
				
				//파일 이름을 프레임의 title에 표시
				setTitle("자바메모장 - [" + f.getName() + "]");
				
				ta.setText("");
				while((i = fr.read(cbuf))!= -1) {
					//ta.setText(String str);	//이전 텍스트에 overwrite
					//ta.append(String str);	//이전 텍스트에 덧붙이기
					//String str = new String(value, offset, count);
					
					String str = new String(cbuf, 0, i);	// char[] ---> String
					ta.append(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr!=null) fr.close();
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
    }
    
    //FROM: TextArea  ----> TO(쓰기객체) : 파일
    public void saveFile() {
    	int t = chooser.showSaveDialog(this);
    	FileWriter fw = null;
    	
		if(t == JFileChooser.APPROVE_OPTION) {
			try {
				//존재하지 않는다면 파일 생성
				File f = chooser.getSelectedFile();//선택된 파일의 정보 얻기
				setTitle("자바메모장 - [" + f.getName() + "]");
				fw = new FileWriter(f);
				fw.write(ta.getText());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(fw != null) fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	Object ob = e.getSource();
    	if(ob == item_open) {
    	   openFile();	
    	}else if(ob == item_save) {
    		saveFile();
    	}else if(ob == item_exit) {
    		System.exit(0);
    	}
    	
    }//actionPerformed
    
    
    public static void main(String[] args) {
		new SimpleNotePad();
	}

}