package oop11.api;

public class ObjectTest02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		
		if(a==b) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		String str1 = "안녕하세요";
		String str2 = "안녕하세요";  //같은 '객체의 주소값을 참조하기 때문에' 같다라고 판별됨. 같은 단어라는 이유가 아님..
		
		if(str1==str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
	}
}
