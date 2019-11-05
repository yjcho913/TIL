package com.scsa.JAVA20191105;

public class TVContribution {
	public static void main(String[] args) {
		
		//모금함 객체 생성
		Account account = new Account();
		
		//모금자 모집
		Customer [] customers = new Customer[5];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(account);
		}
		
		//모금 시작
		for (int i = 0; i < customers.length; i++) {
			customers[i].start();
		}
		
		// 해당 스레드가 종료할때까지 기다리자
		try {
			for (int i = 0; i < customers.length; i++) {
				customers[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		//main : 데몬스레드(스레드의 일종)
		System.out.println("총 모금액 >>> " + account.getTotal());
		//500000원이 나오지 않음! ----> 돈이 새고 있음!
		//동기화가 필요함	---> 메소드 동기화
	}
}
