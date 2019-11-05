package com.scsa.JAVA20191105;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	String name = "CHO";
	// transient : 데이터가 전달되지 않음
	transient int age = 25;
	String job = "student";
}

public class ObjectWriteTest {
	// 파일에 객체를 출력 ---> Object OutputStream
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
		
		oos.close();	//자원 반환
		System.out.println("객체 쓰기 성공!");
		// java.io.NotSerializableException
		// 일렬로 나열되어있지 않은 클래스는 입력하기 위해 'implements Serializable' 이 필요
		// String 클래스는 자동으로 생성
		
	}
}
