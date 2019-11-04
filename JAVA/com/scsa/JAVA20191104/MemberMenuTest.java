package com.scsa.JAVA20191104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	실행결과)
	
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 1
	
	 이름: 홍길동
	 나이: 13
	 직업: 학생
	 
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 1
	
	 이름: 김주원
	 나이: 14
	 직업: 학생
	 
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 1
	
	 이름: 김유신
	 나이: 15
	 직업: 화랑
	 
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 2
	
	 #멤버목록
	 1: [홍길동,13,학생]
	 2: [김주원,14,학생]
	 3: [김유신,15,화랑]
	 
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 3
	
	 수정할 번호: 3
	 나이: 19
	 직업: 장군
	 
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 2
	
	 #멤버목록
	 1: [홍길동,13,학생]
	 2: [김주원,14,학생]
	 3: [김유신,19,장군]
	 
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 4
	
	 삭제할 번호: 2
	 
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 2
	
	 #멤버목록
	 1: [홍길동,13,학생]
	 3: [김유신,19,장군]
	
	<멤버메뉴>
	1.추가 2.검색 3.수정 4.삭제 5.종료
	번호입력==> 5
	
	-- END --
*/

public class MemberMenuTest {
	/*
		PersonMenuTest.java  ---> main()
	  - 반복적인 메뉴출력
	  - ArrayList에 추가할 사람정보, 수정할 번호와 사람정보, 삭제할 번호의 입력을 받는다.
	  - 선택된 번호에 따라 PersonMenu의 메소드를 호출.
	*/

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		MemberMenu menu = new MemberMenu();
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		int num;
		String name;
		int age;
		String job;
		int no;
		
		while(true) {
			System.out.println("<멤버 메뉴>");
			System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("번호입력==> ");
			num = Integer.parseInt(in.readLine());
			System.out.println();
			
			switch(num) {
			case 1:
//				이름: 홍길동
//				나이: 13
//				직업: 학생
				System.out.print("이름: ");
				name = in.readLine();
				System.out.print("나이: ");
				age = Integer.parseInt(in.readLine());
				System.out.print("직업: ");
				job = in.readLine();
				menu.create(name, age, job);
				break;
			case 2: 
				menu.find();
				break;
			case 3:
//				수정할 번호: 3
//				나이: 19
//				직업: 장군
				System.out.print("수정할 번호: ");
				no = Integer.parseInt(in.readLine());
				System.out.print("나이: ");
				age = Integer.parseInt(in.readLine());
				System.out.print("직업: ");
				job = in.readLine();
				menu.modify(no, age, job);
				break;
			case 4: 
				System.out.print("삭제할 번호: ");
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
