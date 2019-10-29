package com.scsa.JAVA20191029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class GetAgeTest {
	public static void main(String[] args) throws IOException {
		// �ܼ��� ���� �ֹι�ȣ�� �Է¹ް�, �׿� �ش�Ǵ� ���̸� ȭ�� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�ֹι�ȣ�� �Է����ּ���");
		String str = br.readLine();
		
		// ���� ���
		int subyear = 1900;
		String birth = str.substring(0, 2);
		if(str.charAt(7) >= '3') subyear = 2000;
		
		// ���� ���� ���
		// ��¥ ���� class : Date, Calendar
		// Calendar : �߻� Ŭ���� --> new�� ���� ����!
		Calendar cal = Calendar.getInstance();
		int curyear = cal.get(Calendar.YEAR);
		
		int age = curyear - Integer.parseInt(birth) - subyear + 1;
		System.out.println("����� ���̴� "+age+"�� �Դϴ�.");
	}
}