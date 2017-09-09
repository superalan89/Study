package oop02.static04;

public class Car {
	int speed;
	
	public void run() {
		System.out.println(speed + "으로 달립니다.");
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.speed = 40;
		car.run();
	}
	
}
