package com.scsa.JAVA20191105;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	String name = "CHO";
	// transient : �����Ͱ� ���޵��� ����
	transient int age = 25;
	String job = "student";
}

public class ObjectWriteTest {
	// ���Ͽ� ��ü�� ��� ---> Object OutputStream
	public static void main(String[] args) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/scsa/JAVA20191105/person.ser"));
		
		Person p = new Person();
		p.name = "KIM";
		p.age = 25;
		p.job = "student";
		//oos.writeObject(Object obj);
		oos.writeObject(new Person());
		oos.writeObject(p);
		oos.writeInt(1000);
		oos.writeBoolean(true);
		
		oos.close();	//�ڿ� ��ȯ
		System.out.println("��ü ���� ����!");
		// java.io.NotSerializableException
		// �Ϸķ� �����Ǿ����� ���� Ŭ������ �Է��ϱ� ���� 'implements Serializable' �� �ʿ�
		// String Ŭ������ �ڵ����� ����
		
	}
}
