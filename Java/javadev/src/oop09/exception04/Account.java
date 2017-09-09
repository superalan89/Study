package oop09.exception04;

public class Account {
	private long balance;  // 현재 계좌 잔액
	
	public Account() {}
	
	public long getBalance() { // 현재 계좌 진행 확인
		return balance;
	}
	public void desposit(int money) {  //입금하는 메서드
		balance += money;
	}
	
	public void withdraw(int money) throws MyException { //출금하는 메서드
		if(balance < money) {
			
			throw new MyException("잔고부족 : " + (money-balance) + "모자람");
		}
		
		balance -= money;
	}
	
}
