package oop02.static01;

public class Account {
	static int money1;
	int money2;
	
	public Account(int money) {
		money1 += money;
		money2 += money;
	}
	
}
