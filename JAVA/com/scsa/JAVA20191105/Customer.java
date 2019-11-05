package com.scsa.JAVA20191105;

public class Customer extends Thread{// 경쟁적인 모금자(Thread)
	
	Account account;
	
	public Customer(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		
		try {
			for(int i=1; i<=200; i++) {
				sleep(50);
				if(account.getTotal() >= 500000) break;
				account.deposit(1000);
				System.out.println(getName() + " : " + i + "회");
			}
		}catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}
