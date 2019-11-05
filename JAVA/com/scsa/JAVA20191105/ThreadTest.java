package com.scsa.JAVA20191105;

class MyThread extends Thread{
	// MyThread�� Thread��ü
	
	@Override
	public void run(){ 
		//������ Ư�� �޼ҵ�
		//���� ������(�ٸ� �޼ҵ�ʹ� ������ ��ٸ��� �ʰ� ������) �����
		for(int i=1; i<11; i++) {//1~10
			//Thread.sleep(long millis);
			//'throws' ���� <--- �������̵� �޼ҵ��̰� �θ� Exception�� throws�ϰ����� ����
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���� ������ 111 >>> " + i);
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run(){ 
		//������ Ư�� �޼ҵ�
		//���� ������(�ٸ� �޼ҵ�ʹ� ������ ��ٸ��� �ʰ� ������) �����
		for(int i=1; i<11; i++) {//1~10
			//Thread.sleep(long millis);
			//'throws' ���� <--- �������̵� �޼ҵ��̰� �θ� Exception�� throws�ϰ����� ����
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���� ������ 222222 >>> " + i);
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		//t: ������ ��ü
		MyThread t = new MyThread();
		//r: Runnable ��ü
		MyThread2 r = new MyThread2();
//		Thread t2 = new Thread(Runnable r)
		Thread t2 = new Thread(r);
		
		// start()�� ȣ���ϸ� �����췯�� �����带 Runnable ���·� �ٲ���
		// Runnable�� Running ���¸� ������ �ϳ��� �����尡 ���پ� �ڵ� ����
		t.start();
		t2.start();
		
		// ���ε� �ϳ��� ������ó�� ���� ����!
		for(int i=1; i<20; i++) {
			long saveTime = System.currentTimeMillis();
		    long currTime = 0;
		    long delayTime = 300;
	        while( currTime - saveTime < delayTime){
	            currTime = System.currentTimeMillis();
	        }
			System.out.println("���� ���� >>> "+ i);
		}
	}
}
