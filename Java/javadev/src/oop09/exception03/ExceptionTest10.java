package oop09.exception03;

public class ExceptionTest10 {
	public static void main(String[] args) {
		test();
		System.out.println("종료");
	}

	private static void test() {
		System.out.println("test() 메서드 수행 시작");
		
		try {
			throw new Exception("사용자가 강제로 예외 발생");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
