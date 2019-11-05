package com.scsa.JAVA20191105;

class MyThread3 extends Thread{
	
	
	public MyThread3() {
		//new Thread(String name);
	}
	public MyThread3(String name) {
		//new Thread(String name);
		super(name);
	}
	
	//������ Ư¡ �޼ҵ� ---> run : start()�޼ҵ带 ���� ȣ���ؾ� ���� ������ ����!!
	public void run() {
       try {
		for(int i=1; i<11; i++) {
			   Thread.sleep(500);//0.5�� ���
			   System.out.println(getName()+" : "+ i);
		   }
	    } catch (InterruptedException e) {
		e.printStackTrace();
	   }
	}//run
}


public class ThreadTest2 {
   public static void main(String[] args) {
	   
	   //�������� �⺻�̸� : Thread-0  Thread-1  Thread-2
	   //�����忡 �̸� �ο��ϱ�!!
	   //new Thread(String name)   name: ������ �̸�����
	   
	   MyThread3 t1 = new MyThread3("THREAD01");
	   MyThread3 t2 = new MyThread3("THREAD02");
	   MyThread3 t3 = new MyThread3("THREAD03");
	   
	   //������ �켱���� �ο�(1~10) 10:�켱���� ���� ����,   �⺻���� 5
	   t1.setPriority(Thread.MAX_PRIORITY);//10
	   t2.setPriority(Thread.MIN_PRIORITY);//1
	   t3.setPriority(Thread.NORM_PRIORITY);//5
	   
	   //������ ����
	   t1.start();
	   t2.start();
	   t3.start();
   }
}
