package com.scsa.JAVA20191030;

import java.io.IOException;

/*
����1) �Ʒ��� ���� ������ �� �� �ְ� ���α׷��� �ۼ��Ͻÿ�.
     (do~while�� ���, main()�޼ҵ峻�� ����, 
      System.in.read()�޼ҵ� ���)

[������]
===========================
<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 1
#�˻����: 0

<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 2
#1�����Ͽ����ϴ�.

<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 2
#1�����Ͽ����ϴ�.

<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 2
#1�����Ͽ����ϴ�.

<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 1
#�˻����: 3

<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 3
#1�����Ͽ����ϴ�.

<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 1
#�˻����: 2

<<�޴�>>
1.�˻� 2.���� 3.���� 4.����
��ȣ==> 4

-- END --
 */

public class SelectMenu {	
	public static void main(String[] args) throws IOException {
		int num = 0;
		int input = 0;
		
		System.out.println("===========================");
		do {
			System.out.println("1.�˻� 2.���� 3.���� 4.����");
			System.out.print("��ȣ==> ");
			input = System.in.read() - '0';
			System.in.read();
			System.in.read();
			
			switch(input) {
				case 1:
					System.out.println("#�˻����: " + num);
					break;
				case 2:
					num++;
					System.out.println("#1�����Ͽ����ϴ�.");
					break;
				case 3:
					num--;
					System.out.println("#1�����Ͽ����ϴ�.");
					break;
				default:
					System.out.println();
			}
		}while(input != 4);
		System.out.println("-- END --");
	}
}
