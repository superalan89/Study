package oop09.exception03;

public class ExceptionTest09 {
	public static void main(String[] args) {
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);  // a라는 문자때문에 숫자로 인식 X : NumberFormatException 발생
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) { //주의점 : 역슬레쉬 이용해서 or 구문 사용 가능
			System.out.println("실행 매게값의 수가 부족하거나 숫자로 변화할 수 없습니다.");
		} catch (Exception e) {
			System.out.println("알 수 없는 예외 발생.");	
		} finally {
			System.out.println("finally 블럭");
		}
	}
}
