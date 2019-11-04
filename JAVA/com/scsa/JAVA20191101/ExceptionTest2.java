package com.scsa.JAVA20191101;

// UnChecked Exception

/*
(num1, num2)
------------
(10, 5)
(ab, cd)	// NumberFormatException
(10, )		// ArrayIndexOutOfBoundsException
(10, 0)		// ArithmeticException

// ��� java.lang�� ��������! �θ� �ڽ� ���� ����!
 */

public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			System.out.println("�Ű������� ���� �ΰ��� ��");
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			
			System.out.println("num1 = " + num1+ ", num2 = " + num2);
			System.out.println("num1�� num2�� ���� �� = " + (num1/num2));
			System.out.println("�������� �� ����Ǿ����ϴ�!");			
		} catch(NumberFormatException e) {
			System.out.println("# ���ڸ� �Է��ϼ���!");
			return;		// return �� �־, finally�� �ݵ�� ����!
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("# �� ���� ���� �Է��ϼ���!");
			return;		// return �� �־, finally�� �ݵ�� ����!
		} catch(ArithmeticException e) {
			System.out.println("# 0���� ���� �� �����ϴ�!");
			return;		// return �� �־, finally�� �ݵ�� ����!
		} catch(Exception e) {
			// ���� Exception���� �θ� Ŭ����!!
			// ��� ����ó���� ���⼭ �ϰڴ� Ȥ��
			// ������ ���ܴ� ���⼭ ó���ϰڴ�!
			System.out.println("# ��� ���� ó��");
		} finally {
			System.out.println("** ���� �߻��� ������� ������ ���� ���� = finally **");
		}
		
		System.out.println("������ ����");
	}
}
