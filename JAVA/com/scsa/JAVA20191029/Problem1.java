package com.scsa.JAVA20191029;

import java.util.Calendar;

// ȭ�鿡 �Ʒ��� ���� ���� �ð��� ����Ͻÿ�.
// 2019�� 10�� 29�� 15�� 55�� 32�� (ȭ����)

public class Problem1 {
	public static void main(String[] args) {
		String days[] = {".", "��", "��", "ȭ", "��", "��", "��", "��"};
		Calendar cal = Calendar.getInstance();
		String day = days[cal.get(Calendar.DAY_OF_WEEK)];
		System.out.println(cal.get(Calendar.YEAR)+"�� " + 
				(cal.get(Calendar.MONTH)+1)+"�� " + 
				cal.get(Calendar.DAY_OF_MONTH)+"�� " + 
				cal.get(Calendar.HOUR_OF_DAY)+"�� " + 
				cal.get(Calendar.MINUTE)+"�� " + 
				cal.get(Calendar.SECOND)+"�� " + 
				"("+day+"����)" );
	}
}
