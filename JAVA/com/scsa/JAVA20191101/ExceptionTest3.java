package com.scsa.JAVA20191101;

import javax.management.RuntimeErrorException;

// ����� ���� ����

class MyException extends Exception{
	public MyException(String msg) {
		// Exception ��ü : ERROR �޽��� ����
		super(msg);
	}
}

public class ExceptionTest3 {
	public static void main(String[] args) throws MyException {
		boolean condition = true;
		
		if(condition) {
			MyException my = new MyException("����� ���� ����");
			throw my;
			
			// �ַ� ����ϴ� throw Exception : 
//			throw new RuntimeException("WRONG!!");
		}
	}
}
