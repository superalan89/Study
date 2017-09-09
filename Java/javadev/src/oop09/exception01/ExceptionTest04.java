package oop09.exception01;
/*
 * Runtime Exception4 (Unchecked Exception)
 * 
 *  	: ClassCastException
 */
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}

public class ExceptionTest04 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		changeAnimal(dog);
		
		Cat cat = new Cat();
		changeAnimal(cat);
	}

	private static void changeAnimal(Animal animal) {
		Dog dog = (Dog) animal;
		
		// 개를 고양이로 만들 순 없다. 엉뚱한 형변환
	}
}
