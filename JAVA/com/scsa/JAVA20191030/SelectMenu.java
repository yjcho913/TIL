package com.scsa.JAVA20191030;

import java.io.IOException;

/*
문제1) 아래와 같은 실행을 할 수 있게 프로그램을 작성하시오.
     (do~while문 사용, main()메소드내에 정의, 
      System.in.read()메소드 사용)

[실행결과]
===========================
<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 1
#검색결과: 0

<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 2
#1증가하였습니다.

<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 2
#1증가하였습니다.

<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 2
#1증가하였습니다.

<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 1
#검색결과: 3

<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 3
#1감소하였습니다.

<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 1
#검색결과: 2

<<메뉴>>
1.검색 2.증가 3.감소 4.종료
번호==> 4

-- END --
 */

public class SelectMenu {	
	public static void main(String[] args) throws IOException {
		int num = 0;
		int input = 0;
		
		System.out.println("===========================");
		do {
			System.out.println("1.검색 2.증가 3.감소 4.종료");
			System.out.print("번호==> ");
			input = System.in.read() - '0';
			System.in.read();
			System.in.read();
			
			switch(input) {
				case 1:
					System.out.println("#검색결과: " + num);
					break;
				case 2:
					num++;
					System.out.println("#1증가하였습니다.");
					break;
				case 3:
					num--;
					System.out.println("#1감소하였습니다.");
					break;
				default:
					System.out.println();
			}
		}while(input != 4);
		System.out.println("-- END --");
	}
}
