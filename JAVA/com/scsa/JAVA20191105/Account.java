package com.scsa.JAVA20191105;

public class Account {
	private int total;
	
	public synchronized void deposit(int account) {
		total += account;
	}
	
	public int getTotal() {
		return total;
	}
}
