package com.scsa.JAVA20191029;
/*
 * ��Ű��:	���� �����ִ� Ŭ�������� ����
 * 			NameSpace(�̸�����) ���� - �̸� �浹 ����
 * 			JVM�� �ν��ϴ� ����
 * 			�ڹٿ����� 2�� �̻��� ��Ű������ ����ϴ� ���� ����
 * 			���� Ŭ������ ��ġ�� ǥ��
 */

import com.scsa.JAVA20191029.pack1.A;

// import : ���� Ŭ�������� ����� �ܺ� Ŭ������ ��ġ�� ǥ��
// ���� : import ��Ű����.Ŭ������;

// import com.scsa.JAVA20191029.pack1.*;
// '*'�� �ǹ� : pack1 ��Ű�� ���� ��� Ŭ������ �� Ŭ�������� ����ϰ���

public class HelloTest {
	public static void main(String[] args) {
		System.out.println("Hellooooooooooooooooo!");
		A a = new A();
		a.hello();
	}
}
