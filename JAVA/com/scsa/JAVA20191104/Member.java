package com.scsa.JAVA20191104;

/*
	Member.java    ----> 자바빈즈(서로 관련있는 속성들을 표현(저장)하는 클래스)
	  - private속성: 번호,이름,나이,직업
	  - 생성자(선택사항)
	  - public 게터메소드, 세터메소드
*/

// 일반적으로 public class MemberVO로 정의하기도 함
public class Member {
	// 서로 관련있는 속성 정의

	private int no;
	private String name;
	private int age;
	private String job;
	
	public Member() {};

	public Member(int no, String name, int age, String job) {
		super();	// 컴파일러가 자동 추가
		this.no = no;
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	
	@Override
	public String toString() {
		return no + ": [" + name + "," + age + "," + job + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
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
