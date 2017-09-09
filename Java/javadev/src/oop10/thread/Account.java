package oop10.thread;

public class Account {
	private int money;
	public Account(int money) {  
		// 첫 계좌 개설시 초기 입금금액
		this.money = money;
	}
			
	
	public synchronized void deposit(int amount, String name) { //입금
		money += amount;
		System.out.println(name + ", 입금금액 : " + amount);
		getMoney();
	}
			
	
	public synchronized void withdraw(int amount, String name) { //출금
		if (money >= amount) { // 잔액이 출금금액보다 클 경우
			Thread.yield();  //"자신의 권한을 다른 스레드에 잠시 이양하고 자신은 쉰다."
                             //"네트워크 트래픽 상황을 구현"
			money -= amount;
			System.out.println(name + ", 출금금액 : " + amount);
		} else {               // 잔액보다 출금금액이 클 경우
			System.out.println(
				name + "님이 " + amount + 
				"금액을 출금하려 했으나, 잔액부족으로 출금되지 않았습니다.");
		}
		getMoney();
	}
	
		
		
	public void getMoney() {
		System.out.println("계좌 잔액은 " + this.money + "입니다.");
	}
}
