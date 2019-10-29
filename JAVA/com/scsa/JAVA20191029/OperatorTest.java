package com.scsa.JAVA20191029;

public class OperatorTest {
	public static void main(String[] args) {
		int su1 = 40;
		int su2 = 30;
		
		// "¾È³ç" + 10 + 20 -> "¾È³ç10" + 20 -> "¾È³ç1020"
		// 10 + 20 + "¾È³ç" -> 30 + "¾È³ç" -> "30¾È³ç"
		
		System.out.println("su1 + su2 = " + (su1+su2));
		System.out.println("su1 - su2 = " + (su1-su2));
		System.out.println("su1 * su2 = " + (su1*su2));
		System.out.println("su1 / su2 = " + (su1/su2));
		System.out.println("su1 % su2 = " + (su1%su2));
		
		int x = 10;
		int y = 20;
		int z = 30;
		boolean flag = true;
		
		if((x > y) && ((y < z) && (flag = false))) ;
		System.out.println("flag = " + flag);
	}
}