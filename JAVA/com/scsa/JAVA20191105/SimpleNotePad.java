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
    	//parent: � ������Ʈ ���� Dialog�� ��ġ��ų��?
    	int t= chooser.showOpenDialog(this);
    	chooser.getSelectedFile();//���õ� ������ ���� ���
    }
    
    //FROM: TextArea  ----> TO(���ⰴü) : ����
    public void saveFile() {
    	chooser.showSaveDialog(this);
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