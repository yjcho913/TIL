package com.scsa.JAVA20191105;

class MyThread3 extends Thread{
	
	
	public MyThread3() {
		//new Thread(String name);
	}
	public MyThread3(String name) {
		//new Thread(String name);
		super(name);
	}
	
	//스레드 특징 메소드 ---> run : start()메소드를 통해 호출해야 동시 실행이 가능!!
	public void run() {
       try {
		for(int i=1; i<11; i++) {
			   Thread.sleep(500);//0.5초 대기
			   System.out.println(getName()+" : "+ i);
		   }
	    } catch (InterruptedException e) {
		e.printStackTrace();
	   }
	}//run
}


public class ThreadTest2 {
   public static void main(String[] args) {
	   
	   //스레드의 기본이름 : Thread-0  Thread-1  Thread-2
	   //스레드에 이름 부여하기!!
	   //new Thread(String name)   name: 스레드 이름설정
	   
	   MyThread3 t1 = new MyThread3("THREAD01");
	   MyThread3 t2 = new MyThread3("THREAD02");
	   MyThread3 t3 = new MyThread3("THREAD03");
	   
	   //스레드 우선순위 부여(1~10) 10:우선순위 가장 높음,   기본값은 5
	   t1.setPriority(Thread.MAX_PRIORITY);//10
	   t2.setPriority(Thread.MIN_PRIORITY);//1
	   t3.setPriority(Thread.NORM_PRIORITY);//5
	   
	   //스레드 실행
	   t1.start();
	   t2.start();
	   t3.start();
   }
}
