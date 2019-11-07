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
	  setTitle("�ڹٸ޸���");
	
	  chooser = new JFileChooser();
	  
	  bar = new MenuBar();
	    menu_file = new Menu("File");
	       item_open = new MenuItem("����");
	       item_save = new MenuItem("����");
	       item_exit = new MenuItem("����");
	       
	    menu_help = new Menu("Help");
	    
	    menu_file.add(item_open);
	    menu_file.add(item_save);
	    menu_file.addSeparator();//���м� �߰�
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
	}//������
    
    
    //FROM(�бⰴü): ����   ------>  TO : TextArea
    public void openFile() {
    	//chooser.showOpenDialog(Component parent);
    	//parent: � ������Ʈ ���� Dialog�� ��ġ��ų��
    	int t= chooser.showOpenDialog(this);
		FileReader fr = null;

    	try {
			if(t == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();//���õ� ������ ���� ���
				fr = new FileReader(f);
				char []cbuf = new char[1024];
				int i;
				
				//���� �̸��� �������� title�� ǥ��
				setTitle("�ڹٸ޸��� - [" + f.getName() + "]");
				
				ta.setText("");
				while((i = fr.read(cbuf))!= -1) {
					//ta.setText(String str);	//���� �ؽ�Ʈ�� overwrite
					//ta.append(String str);	//���� �ؽ�Ʈ�� �����̱�
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
    
    //FROM: TextArea  ----> TO(���ⰴü) : ����
    public void saveFile() {
    	int t = chooser.showSaveDialog(this);
    	FileWriter fw = null;
    	
		if(t == JFileChooser.APPROVE_OPTION) {
			try {
				//�������� �ʴ´ٸ� ���� ����
				File f = chooser.getSelectedFile();//���õ� ������ ���� ���
				setTitle("�ڹٸ޸��� - [" + f.getName() + "]");
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