package com.scsa.JAVA20191029;

/*
<������ ����>
1. ������ 4�� ������ �������� 0�̰�
   ������ 100 ���� ������ �������� 0�� �ƴ� ���.

2. ������ 400���� ������ �������� 0�� ���.

  ������)
    ���� ������ �����϶�  ----> true
    ���� ������ ����϶�  ----> false
  ----> class�� : LeapYearTest
    main()�޼ҵ峻�� ����: int year=2019;
 
 ����) ���ǹ�, �ݺ��� ���X
 */

public class LeapYearTest {
	public static void main(String[] args) {
		int year = 2019;

		System.out.println("result : "+ ((year%4 == 0 && year%100 != 0)||(year%400 == 0)));
	}
}