package com.scsa.JAVA20191105;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadTest {
	//��ü �б�
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/com/scsa/JAVA20191105/person.ser"));
		
		Person p1 = (Person) ois.readObject();
		System.out.println("�̸� >>> " + p1.name);
		System.out.println("���� >>> " + p1.age);	//0 ���. <--- transient
		System.out.println("���� >>> " + p1.job);
		
		Person p2 = (Person) ois.readObject();
		System.out.println("�̸� >>> " + p2.name);
		System.out.println("���� >>> " + p2.age);	//0 ���. <--- transient
		System.out.println("���� >>> " + p2.job);
		
		System.out.println(ois.readInt());
		System.out.println(ois.readBoolean());
	}
}
