package oop07.anony02;

public class AnonyTest {
	public static void main(String[] args) {
		Anony anony = new Anony();
		anony.field.turnOn();
		anony.method1();
		anony.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("스마트TV를 켭니다.");
				
			}
			
			@Override
			public void turnOff() {
				System.out.println("스마트TV를 끕니다.");
				
			}
		});
		
	}
}
