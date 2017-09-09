package oop10.thread;

public class ThreadTest01 {
	public static void main(String[] args) {
		test();
		
		for(int i=1; i<=5; i++) {
			System.out.println("main : " +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void test() {
		for(int i=1; i<=5; i++) {
			System.out.println("test : " +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
