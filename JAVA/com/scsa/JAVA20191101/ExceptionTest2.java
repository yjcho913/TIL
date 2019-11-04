package com.scsa.JAVA20191101;

// UnChecked Exception

/*
(num1, num2)
------------
(10, 5)
(ab, cd)	// NumberFormatException
(10, )		// ArrayIndexOutOfBoundsException
(10, 0)		// ArithmeticException

// 모두 java.lang에 속해있음! 부모 자식 관계 없음!
 */

public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			System.out.println("매개변수로 맏은 두개의 수");
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			
			System.out.println("num1 = " + num1+ ", num2 = " + num2);
			System.out.println("num1을 num2로 나눈 몫 = " + (num1/num2));
			System.out.println("나눗셈이 잘 실행되었습니다!");			
		} catch(NumberFormatException e) {
			System.out.println("# 숫자만 입력하세요!");
			return;		// return 이 있어도, finally는 반드시 실행!
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("# 두 개의 수를 입력하세요!");
			return;		// return 이 있어도, finally는 반드시 실행!
		} catch(ArithmeticException e) {
			System.out.println("# 0으로 나눌 수 없습니다!");
			return;		// return 이 있어도, finally는 반드시 실행!
		} catch(Exception e) {
			// 위의 Exception들의 부모 클래스!!
			// 모든 예외처리를 여기서 하겠다 혹은
			// 나머지 예외는 여기서 처리하겠다!
			System.out.println("# 모든 예외 처리");
		} finally {
			System.out.println("** 예외 발생과 상관없이 무조건 실행 영역 = finally **");
		}
		
		System.out.println("마지막 문장");
	}
}
