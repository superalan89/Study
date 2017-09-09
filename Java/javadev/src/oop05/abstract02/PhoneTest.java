package oop05.abstract02;

public class PhoneTest {
	public static void main(String[] args) {
		
		Phone phone = new SmartPhone("정대만");
		phone.turnOn();
		phone.internetSearch();
		phone.turnOff();
		
	}
}

//다중상속은 허용안된다.