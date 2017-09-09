package oop10.thread;

public class User extends Thread{ //여러명의 사람이 동시에 Account 클래스를 사용할 수 있는 환경을 구현하기 위해
                                  //Thread를 상속받는다.
	boolean flag = false;
	// flag : true -> 입금
	// flag : false-> 출금
	
	Account obj; // 잔액을 저장하기 위한 계좌 멤버변수
	
	public User(Account obj, String name) {     
		this.obj = obj;
		this.setName(name);
	}
	
	
	
	@Override
	public void run() {
		for(int i=0; i <= 1; i++, flag = !flag) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(flag) { //입금
				obj.deposit(
					(int)(Math.random() * 20 +6)*100, //600 ~ 2500 까지의 백단위 숫자 
					this.getName());
			} else {   //출금
				obj.withdraw(
					(int)(Math.random() * 20 +6)*100, 
					this.getName());
			}
		}
	}
	
	
	
}
