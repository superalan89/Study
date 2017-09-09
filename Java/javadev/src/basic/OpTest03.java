package basic;

public class OpTest03 {
	public static void main(String[] args) {
		boolean a, b;
		
		a = true; b = true;
		System.out.println(a && b); //&& and 연산자
		System.out.println(a || b); //|| or 연산자
		System.out.println(!a); //! 부정
		
		a = true; b = false;
		System.out.println(a && b); //&& and 연산자
		System.out.println(a || b); //|| or 연산자
		
		a = false; b = false;
		System.out.println(a && b); //&& and 연산자
		System.out.println(a || b); //|| or 연산자
		System.out.println(!b); //! 부정
		
	}
}
