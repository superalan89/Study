package oop07.anony01;

public class Anony {
	Person field = new Person() {

		public void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		public void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
		
	};	// {} 안에 있는 자식개체 이름이 없어서 익명클래스

	public void method1() {
		Person localVar = new Person() {
			public void walk() {
				System.out.println("산책합니다.");
			}
			
			@Override
			public void wake() {
				System.out.println("7시 30분에 일어납니다.");
				walk();
			}
			
		};
		
		localVar.wake();
		
	}

	public void method2(Person person) {
		person.wake();
	}
	
}
