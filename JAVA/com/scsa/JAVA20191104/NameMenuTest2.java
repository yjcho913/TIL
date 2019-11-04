package com.scsa.JAVA20191104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		int num;
		NameMenu2 menu = new NameMenu2();
		
		do {
			System.out.println("<�̸��޴�>");
			System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");
			System.out.print("��ȣ�Է� ==> ");
			num = Integer.parseInt(in.readLine());
			System.out.println();
			
			switch(num) {
				case 1:
					System.out.print("�̸��Է�: ");
					String name = in.readLine();
					menu.insert(name);
					break;
				case 2: 
					menu.select();
					break;
				case 3:
					System.out.print("�����̸��Է�: ");
					String oldName = in.readLine();
					System.out.print("�����̸��Է�: ");
					String newName = in.readLine();
					menu.update(oldName, newName);
					break;
				case 4: 
					System.out.print("�����̸��Է�: ");
					String delName = in.readLine();
					menu.delete(delName);
					break;				
			}
			System.out.println();
		}while(num != 5);
		
		
		System.out.println("-- END --");
	}
}
