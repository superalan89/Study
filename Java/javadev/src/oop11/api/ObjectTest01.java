package oop11.api;

class Point{
	
}

public class ObjectTest01 {
	public static void main(String[] args) {
		Point pt = new Point();
		System.out.println("클래스 이름 : " + pt.getClass());
		System.out.println("해쉬 코드 : " + pt.hashCode());
		System.out.println("인스턴스 참조값 : " + pt.toString());
		
		System.out.println();
		
		Point pt2 = new Point();
		System.out.println("클래스 이름 : " + pt2.getClass());
		System.out.println("해쉬 코드 : " + pt2.hashCode());
		System.out.println("인스턴스 참조값 : " + pt2.toString());
	}
}
