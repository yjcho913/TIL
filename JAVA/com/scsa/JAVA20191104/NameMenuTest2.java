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
			System.out.println("<이름메뉴>");
			System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("번호입력 ==> ");
			num = Integer.parseInt(in.readLine());
			System.out.println();
			
			switch(num) {
				case 1:
					System.out.print("이름입력: ");
					String name = in.readLine();
					menu.insert(name);
					break;
				case 2: 
					menu.select();
					break;
				case 3:
					System.out.print("기존이름입력: ");
					String oldName = in.readLine();
					System.out.print("변경이름입력: ");
					String newName = in.readLine();
					menu.update(oldName, newName);
					break;
				case 4: 
					System.out.print("삭제이름입력: ");
					String delName = in.readLine();
					menu.delete(delName);
					break;				
			}
			System.out.println();
		}while(num != 5);
		
		
		System.out.println("-- END --");
	}
}
