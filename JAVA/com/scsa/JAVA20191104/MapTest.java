package com.scsa.JAVA20191104;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Person{
	//*** 기본 JAVABEANS ***//
	
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
	
	
	// 우클릭 - Source - Generate toString()
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	}

	// 우클릭 - Source - Generate Getters and Setters
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
		- 키와 값의 쌍으로 저장
		- 키값은 중복되지 않음 (만약 동일한 키값이 입력되면 overwrite)
		- key는 변수, value는 저장할 데이터를 의미
		- key는 보통 문자열(String)을, value는 Object를 주로 사용
		- 예외) Properties 클래스의 경우 key : String, value : String
		- HashMap
		- HashTable (동기화 코드 추가)
		- 참고) ArrayList, Vector(동기화 코드추가)
		---> 멀티 스레드 환경에서 잘못된 연산을 하는 것을 방지하려면,
		   	 동기화 코드가 추가된 클래스를 사용해야 함
	 */
	public static void main(String[] args) {
		// Map<K, V>
		Map<String, String> map = new HashMap<>();
		
		// 데이터 입력
		// map.put(String key,  String value)
		map.put("k1", "HONG");
		map.put("k2", "KIM");
		map.put("k3", "LEE");
		map.put("k4", "CHO");
		map.put("k1", "GILL");
//		map.put("k5", 3000);	//에러. 선언된 제네릭의 자료형만 입력 가능.
		
		// 데이터 조회
		// map.get(Object key);
		System.out.println("k3 >>> " + map.get("k3"));
		System.out.println("k1 >>> " + map.get("k1"));	// "GILL"로 overwrite
		System.out.println("Map의 요소 개수 >>> " + map.size());
		System.out.println("=================================");
		
		// key값을 모를 경우 전체 조회
		// set.toString : set의 요소들을 String으로 바꿔줌
		// 오버라이딩 메소드
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

		
		
		// 서로 다른 데이터 타입 저장 가능
		/*
		class Person{
			String name = "YU";
			int age = 13;
			String job = "student";
		}
		*/
		// Map<String, Object>
		// Object이기 때문에 down casting은 해줘야 함!
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
