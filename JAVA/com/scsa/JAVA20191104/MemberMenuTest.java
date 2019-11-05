package com.scsa.JAVA20191104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	������)
	
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 1
	
	 �̸�: ȫ�浿
	 ����: 13
	 ����: �л�
	 
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 1
	
	 �̸�: ���ֿ�
	 ����: 14
	 ����: �л�
	 
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 1
	
	 �̸�: ������
	 ����: 15
	 ����: ȭ��
	 
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 2
	
	 #������
	 1: [ȫ�浿,13,�л�]
	 2: [���ֿ�,14,�л�]
	 3: [������,15,ȭ��]
	 
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 3
	
	 ������ ��ȣ: 3
	 ����: 19
	 ����: �屺
	 
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 2
	
	 #������
	 1: [ȫ�浿,13,�л�]
	 2: [���ֿ�,14,�л�]
	 3: [������,19,�屺]
	 
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 4
	
	 ������ ��ȣ: 2
	 
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 2
	
	 #������
	 1: [ȫ�浿,13,�л�]
	 3: [������,19,�屺]
	
	<����޴�>
	1.�߰� 2.�˻� 3.���� 4.���� 5.����
	��ȣ�Է�==> 5
	
	-- END --
*/

/*
PersonMenuTest.java  ---> main()
- �ݺ����� �޴����
- ArrayList�� �߰��� �������, ������ ��ȣ�� �������, ������ ��ȣ�� �Է��� �޴´�.
- ���õ� ��ȣ�� ���� PersonMenu�� �޼ҵ带 ȣ��.
*/

public class MemberMenuTest {
	// main()�޼ҵ� ����
	// main()�޼ҵ尡 ���ǵ� javaŬ������ JavaApplication�̶�� ��
	// ȭ�� ���, �ܼ� �Է�
	// �޴��� ���� ���� - ��� ��û
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		MemberMenu menu = new MemberMenu();
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		int num;
		String name;
		int age;
		String job;
		int no;
		
		while(true) {
			System.out.println("<��� �޴�>");
			System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");
			System.out.print("��ȣ�Է�==> ");
			// JAVA 7�������� String�� switch������ �� ����
			// parseInt ��� String���� �޾Ƶ���
			num = Integer.parseInt(in.readLine());
			System.out.println();
			
			switch(num) {
			case 1:
//				�̸�: ȫ�浿
//				����: 13
//				����: �л�
				System.out.print("�̸�: ");
				name = in.readLine();
				System.out.print("����: ");
				age = Integer.parseInt(in.readLine());
				System.out.print("����: ");
				job = in.readLine();
				Member mem = new Member(++(MemberMenu.no), name, age, job);
				menu.create(mem);
				break;
			case 2: 
				menu.find();
				break;
			case 3:
//				������ ��ȣ: 3
//				����: 19
//				����: �屺
				System.out.print("������ ��ȣ: ");
				no = Integer.parseInt(in.readLine());
				System.out.print("����: ");
				age = Integer.parseInt(in.readLine());
				System.out.print("����: ");
				job = in.readLine();
				menu.modify(no, age, job);
				break;
			case 4: 
				System.out.print("������ ��ȣ: ");
				no = Integer.parseInt(in.readLine());
				menu.remove(no);
				break;				
			}
			
			if(num == 5) {
				System.out.println("-- END --");
				break;
			}
			else System.out.println();

		}
	}
}
