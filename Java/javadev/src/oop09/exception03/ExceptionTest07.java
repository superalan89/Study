package oop09.exception03;

public class ExceptionTest07 {
	public static void main(String[] args) {
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);  // a라는 문자때문에 숫자로 인식 X : NumberFormatException 발생
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매게값의 수가 부족합니다.");
			System.out.println("[실행방법]");
			System.out.println("[java ExceptionTest07 값1 값2]");
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} finally {
			System.out.println("finally 블럭");
		}
	}
}
