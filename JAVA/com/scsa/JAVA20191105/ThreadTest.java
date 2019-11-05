package com.scsa.JAVA20191105;

class MyThread extends Thread{
	// MyThread는 Thread객체
	
	@Override
	public void run(){ 
		//스레드 특성 메소드
		//동시 실행할(다른 메소드와는 별도로 기다리지 않고 실행할) 문장들
		for(int i=1; i<11; i++) {//1~10
			//Thread.sleep(long millis);
			//'throws' 못함 <--- 오버라이딩 메소드이고 부모가 Exception을 throws하고있지 않음
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("나는 스레드 111 >>> " + i);
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run(){ 
		//스레드 특성 메소드
		//동시 실행할(다른 메소드와는 별도로 기다리지 않고 실행할) 문장들
		for(int i=1; i<11; i++) {//1~10
			//Thread.sleep(long millis);
			//'throws' 못함 <--- 오버라이딩 메소드이고 부모가 Exception을 throws하고있지 않음
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("나는 스레드 222222 >>> " + i);
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		//t: 스레드 객체
		MyThread t = new MyThread();
		//r: Runnable 객체
		MyThread2 r = new MyThread2();
//		Thread t2 = new Thread(Runnable r)
		Thread t2 = new Thread(r);
		
		// start()를 호출하면 스케쥴러가 스레드를 Runnable 상태로 바꿔줌
		// Runnable과 Running 상태를 오가며 하나의 스레드가 한줄씩 코드 실행
		t.start();
		t2.start();
		
		// 메인도 하나의 스레드처럼 동시 실행!
		for(int i=1; i<20; i++) {
			long saveTime = System.currentTimeMillis();
		    long currTime = 0;
		    long delayTime = 300;
	        while( currTime - saveTime < delayTime){
	            currTime = System.currentTimeMillis();
	        }
			System.out.println("나는 메인 >>> "+ i);
		}
	}
}
