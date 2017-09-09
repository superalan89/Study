package oop02.static05;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person("안현수", "Korean");
		Person p2 = new Person("김연아", "Korean");
		
		System.out.println(p1);		//tostring은 자동으로 호출됨
		System.out.println(p2.toString());
		
		System.out.println("-----------------------------------");
		
		p1.setName("빅토르 안");
		p1.setNation("Russian");
		
		System.out.println(p1);
		System.out.println(p2);
		
		
	}
}
