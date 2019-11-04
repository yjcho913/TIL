package com.scsa.JAVA20191104;

import java.util.ArrayList;
import java.util.Iterator;

/*
	MemberMenu.java 
	  - ���(�� �����ϴ�) Ŭ����
	  - ������� ArrayList<Member> members;//��������� ����
	      int no;//���Ϳ� �ԷµǴ� Member���� �������� ��ȣ�ο�
	  - ����޼ҵ�(��ɸ޼ҵ�) : �߰�,     ��ȸ ,   ����,    ����        <=== ������ ���� [���]
	                        insert  select  update  delete
	                      (create   find    modify   remove )
*/
public class MemberMenu {
	ArrayList<Member> members;
	int no;
	
	public MemberMenu(){
		members = new ArrayList<Member>();
		no = 0;
	}
	void create(String name, int age, String job) {
		members.add(new Member(++no, name, age, job));
	}
	
	void find() {
//		 #��� ���
//		 1: [ȫ�浿,13,�л�]
//		 2: [���ֿ�,14,�л�]
//		 3: [������,15,ȭ��]
		System.out.println("#��� ���");
		Iterator<Member> iter = members.iterator();
		while(iter.hasNext()) {
			Member member = iter.next();
			System.out.println(member.getNo() + ": [" + member.getName() + "," + member.getAge() + "," + member.getJob() + "]");
		}
	}
	
	void modify(int no, int age, String job) {
		members.get(no).setAge(age);
		members.get(no).setJob(job);
	}
	
	void remove(int no) {
		members.remove(no);
	}
}
