package oop11.api;

public class ObjectTest03 {
	public static void main(String[] args) {
		String str1 = new String("딸기밭이여 영원하라!");
		String str2 = new String("딸기밭이여 영원하라!");  // new 라는 연산자를 사용시 새로운 객체로 만들어진다.
		
		if(str1==str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		if(str1.equals(str2)) {  //문자의 내용을 비교할때 equals를 이용한다.
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		System.out.println(str1.toString());
		System.out.println(str1.hashCode());
		System.out.println(str1 = str1.replace("딸기", "포도"));
		System.out.println(str1.hashCode());
	
		
		System.out.println("-----------------------------------------");
		
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.hashCode() + "." + sb.length() + "." + sb.capacity());
		
		sb.append("실수란 ");
		System.out.println(sb.hashCode() + "." + sb.length() + "." + sb.capacity());
		
		sb.append("신을 용서하는 ");
		System.out.println(sb.hashCode() + "." + sb.length() + "." + sb.capacity());
		
		sb.append("인간의 행위이다. ");
		System.out.println(sb.hashCode() + "." + sb.length() + "." + sb.capacity());
	}
}
