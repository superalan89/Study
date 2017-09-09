package oop09.exception03;

public class ExceptionTest08 {
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
		} catch (Exception e) {
			System.out.println("실행에 문제가 있습니다.");	//주의점 : 하위클래스타입을 먼저 위로 잡아준다.
		} finally {
			System.out.println("finally 블럭");
		}
	}
}
