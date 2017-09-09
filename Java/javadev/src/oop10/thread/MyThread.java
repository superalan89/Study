package oop10.thread;

public class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println("조성환 : 딸기밭이여 영원하라!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
