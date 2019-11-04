package com.scsa.JAVA20191104;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Person{
	//*** �⺻ JAVABEANS ***//
	
	private String name = "YU";
	private int age = 13;
	private String job = "student";
	
	public Person() { // ctrl + spacebar + enter
	}
	
	public Person(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	
	// ��Ŭ�� - Source - Generate toString()
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	}

	// ��Ŭ�� - Source - Generate Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}

public class MapTest {
	/*
		<Map>
		- Ű�� ���� ������ ����
		- Ű���� �ߺ����� ���� (���� ������ Ű���� �ԷµǸ� overwrite)
		- key�� ����, value�� ������ �����͸� �ǹ�
		- key�� ���� ���ڿ�(String)��, value�� Object�� �ַ� ���
		- ����) Properties Ŭ������ ��� key : String, value : String
		- HashMap
		- HashTable (����ȭ �ڵ� �߰�)
		- ����) ArrayList, Vector(����ȭ �ڵ��߰�)
		---> ��Ƽ ������ ȯ�濡�� �߸��� ������ �ϴ� ���� �����Ϸ���,
		   	 ����ȭ �ڵ尡 �߰��� Ŭ������ ����ؾ� ��
	 */
	public static void main(String[] args) {
		// Map<K, V>
		Map<String, String> map = new HashMap<>();
		
		// ������ �Է�
		// map.put(String key,  String value)
		map.put("k1", "HONG");
		map.put("k2", "KIM");
		map.put("k3", "LEE");
		map.put("k4", "CHO");
		map.put("k1", "GILL");
//		map.put("k5", 3000);	//����. ����� ���׸��� �ڷ����� �Է� ����.
		
		// ������ ��ȸ
		// map.get(Object key);
		System.out.println("k3 >>> " + map.get("k3"));
		System.out.println("k1 >>> " + map.get("k1"));	// "GILL"�� overwrite
		System.out.println("Map�� ��� ���� >>> " + map.size());
		System.out.println("=================================");
		
		// key���� �� ��� ��ü ��ȸ
		// set.toString : set�� ��ҵ��� String���� �ٲ���
		// �������̵� �޼ҵ�
		Set<String> set = map.keySet();
		System.out.println("set >> " + set);
		System.out.println("set.toString() >> " + set.toString());
		
		Iterator<String> iter = set.iterator();
		System.out.println("set iterator >>> ");
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("=================================");

		
		
		// ���� �ٸ� ������ Ÿ�� ���� ����
		/*
		class Person{
			String name = "YU";
			int age = 13;
			String job = "student";
		}
		*/
		// Map<String, Object>
		// Object�̱� ������ down casting�� ����� ��!
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "CHO");
		map2.put("num", 100);
		map2.put("p", new Person());
		
		System.out.println("name >>> " + map2.get("name"));
		System.out.println("num >>> " + map2.get("num"));
		Person p = (Person)map2.get("p");
//		System.out.println("p name >>> " + p.name);
//		System.out.println("p age >>> " + p.age);
//		System.out.println("p job >>> " + p.job);
		System.out.println(p);
		System.out.println("=================================");
		
		
		Person person = new Person("CHO", 25, "student");
		map2.put("p", person);
		p = (Person)map2.get("p");
		System.out.println(p);
		System.out.println("=================================");
	}
}
