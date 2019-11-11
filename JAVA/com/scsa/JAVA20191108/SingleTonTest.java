package com.scsa.JAVA20191108;

class Abc{
	
	private static Abc instance; //인스턴스: 특정클래스 객체  
	
    private Abc() {    	
	}
    
    public static Abc getInstance() {
       if(instance == null) {	
    	  instance = new Abc();
    	}
    	return instance;
    }
}

public class SingleTonTest {	
//싱글톤(singleton)방식 ----> 메모리 낭비 방지
//특정 클래스에 대해서 한 개의 메모리만 생성해서 공유
	
	public static void main(String[] args) {
	 
//		Abc  a1 = new Abc();
//		Abc  a2 = new Abc();
//		Abc  a3 = new Abc();
		
		Abc  a1 = Abc.getInstance();
		Abc  a2 = Abc.getInstance();
		Abc  a3 = Abc.getInstance();
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
	}
}