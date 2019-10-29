package com.scsa.JAVA20191029;

/*
<윤년의 조건>
1. 연도를 4로 나누어 나머지가 0이고
   연도를 100 으로 나누어 나머지가 0이 아닌 경우.

2. 연도를 400으로 나누어 나머지가 0인 경우.

  결과출력)
    만약 연도가 윤년일때  ----> true
    만약 연도가 평년일때  ----> false
  ----> class명 : LeapYearTest
    main()메소드내에 변수: int year=2019;
 
 제약) 조건문, 반복문 사용X
 */

public class LeapYearTest {
	public static void main(String[] args) {
		int year = 2019;

		System.out.println("result : "+ ((year%4 == 0 && year%100 != 0)||(year%400 == 0)));
	}
}