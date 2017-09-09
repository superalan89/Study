package oop07.anony01;

public class AnonyTest {
	public static void main(String[] args) {
		Anony anony = new Anony();
		anony.field.wake();
		
		anony.method1();
		anony.method2(new Person() {

			public void study() {
				System.out.println("자바를 공부합니다.");
			}
			
			@Override
			public void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
			//익명객체
		});
	}
}
