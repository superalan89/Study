package oop09.exception02;

public class ExceptionTest06 {
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		
		try {
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매게값의 수가 부족합니다.");
			System.out.println("[실행방법]");
			System.out.println("[java ExceptionTest06 값1 값2]");
			return; //메서드 강제종료
		}
		
		//우클릭후 Surround With 클릭  try - catch block 클릭
	
		
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);  // a라는 문자때문에 숫자로 인식 X : NumberFormatException 발생
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("finally 블럭");
			//무조건 거쳐가는 블럭 (예외유무 상관없음)
		}
		
	}
}
