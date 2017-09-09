package oop07.anony02;

public class Anony {
	RemoteControl field = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다.");
			
		}
		
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다.");
			
		}
		
		//인터페이스를 구현하는 익명객체
	};
	
	public void method1() {
		RemoteControl localVar = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("Audio를 켭니다.");
				
			}
			
			@Override
			public void turnOff() {
				System.out.println("Audio를 끕니다.");
				
			}
		};
		localVar.turnOn();
	}
	
	public void method2(RemoteControl rc) {
		rc.turnOn();
	}
	
}
