package com.scsa.JAVA20191101;

import javax.management.RuntimeErrorException;

// 사용자 정의 예외

class MyException extends Exception{
	public MyException(String msg) {
		// Exception 객체 : ERROR 메시지 존재
		super(msg);
	}
}

public class ExceptionTest3 {
	public static void main(String[] args) throws MyException {
		boolean condition = true;
		
		if(condition) {
			MyException my = new MyException("사용자 정의 예외");
			throw my;
			
			// 주로 사용하는 throw Exception : 
//			throw new RuntimeException("WRONG!!");
		}
	}
}
