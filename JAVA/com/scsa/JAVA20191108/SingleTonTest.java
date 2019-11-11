package com.scsa.JAVA20191108;

class Abc{
	
	private static Abc instance; //�ν��Ͻ�: Ư��Ŭ���� ��ü  
	
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
//�̱���(singleton)��� ----> �޸� ���� ����
//Ư�� Ŭ������ ���ؼ� �� ���� �޸𸮸� �����ؼ� ����
	
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