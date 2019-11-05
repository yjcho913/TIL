package com.scsa.JAVA20191104;

import java.util.ArrayList;
import java.util.Iterator;

/*
	MemberMenu.java 
	  - 기능(을 정의하는) 클래스
	  - 멤버변수 ArrayList<Member> members;//사람정보를 저장
	      int no;//벡터에 입력되는 Member내에 순차적인 번호부여
	  - 멤버메소드(기능메소드) : 추가,     조회 ,   수정,    삭제        <=== 데이터 단위 [사람]
	                        insert  select  update  delete
	                      (create   find    modify   remove )
*/

public class MemberMenu {
	// CRUD 정의
	// MEMORY(FIELD), FILE SYSTEM, DATABASE에 데이터 저장!
	
	ArrayList<Member> members;
	static int no;
	
	public MemberMenu(){
		members = new ArrayList<Member>();
		no = 0;
	}
	void create(Member m) {
		members.add(m);
	}
	
	void find() {
//		 #멤버 목록
//		 1: [홍길동,13,학생]
//		 2: [김주원,14,학생]
//		 3: [김유신,15,화랑]
		System.out.println("#멤버 목록");
		Iterator<Member> iter = members.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
//		for(Member m : members) {
//			System.out.println(m);
//		}
	}
	
	void modify(int no, int age, String job) {
		members.get(no).setAge(age);
		members.get(no).setJob(job);
	}
	
	void remove(int no) {
		members.remove(no);
	}
}
