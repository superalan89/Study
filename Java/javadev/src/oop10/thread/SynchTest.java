package oop10.thread;

public class SynchTest {

	public static void main(String[] args) {
		Account atm = new Account(2500);
		
		User user1 = new User(atm, "서태지");
		User user2 = new User(atm, "양현석");
		User user3 = new User(atm, "이주노");
		
		user1.start();
		user2.start();
		user3.start();
		
		
		
		
	}

}
