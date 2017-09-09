package oop09.exception02;

public class ExceptionTest05 {
	public static void main(String[] args) {
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 예외처리 할때 상위클래스 타입으로 잡아주는것이 좋다.
	}
}
