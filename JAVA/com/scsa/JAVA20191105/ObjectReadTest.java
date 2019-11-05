package com.scsa.JAVA20191105;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadTest {
	//객체 읽기
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/com/scsa/JAVA20191105/person.ser"));
		
		Person p1 = (Person) ois.readObject();
		System.out.println("이름 >>> " + p1.name);
		System.out.println("나이 >>> " + p1.age);	//0 출력. <--- transient
		System.out.println("직업 >>> " + p1.job);
		
		Person p2 = (Person) ois.readObject();
		System.out.println("이름 >>> " + p2.name);
		System.out.println("나이 >>> " + p2.age);	//0 출력. <--- transient
		System.out.println("직업 >>> " + p2.job);
		
		System.out.println(ois.readInt());
		System.out.println(ois.readBoolean());
	}
}
