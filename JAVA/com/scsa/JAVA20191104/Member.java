package com.scsa.JAVA20191104;

/*
	Member.java    ----> �ڹٺ���(���� �����ִ� �Ӽ����� ǥ��(����)�ϴ� Ŭ����)
	  - private�Ӽ�: ��ȣ,�̸�,����,����
	  - ������(���û���)
	  - public ���͸޼ҵ�, ���͸޼ҵ�
*/

// �Ϲ������� public class MemberVO�� �����ϱ⵵ ��
public class Member {
	// ���� �����ִ� �Ӽ� ����

	private int no;
	private String name;
	private int age;
	private String job;
	
	public Member() {};

	public Member(int no, String name, int age, String job) {
		super();	// �����Ϸ��� �ڵ� �߰�
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
