package oop09.exception03;

public class ExceptionTest11 {
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			//e.printStackTrace();  //예외가 발생해서 전달되는 과정이 출력
			System.out.println(e.getMessage()); //예외ㅏㄹ생이 발생한 이유를 담은 문자열을 반환하는 메소드
		}
		System.out.println("종료");
	}

	private static void test() throws Exception {
		System.out.println("test() 메서드 수행 시작");
		
		
		throw new Exception("사용자가 강제로 예외 발생");
		
	}
}
