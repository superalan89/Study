package oop02.static05;

public class Person {
	String name;
	static String nation;  //static을 함부로 쓰면 안되는 이유!, static=정적 제일먼저 메모리에 할당됨
	
	public Person(String name, String nation) {
		this.name = name;
		this.nation = nation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", nation=" + nation + "]";
	}
}
