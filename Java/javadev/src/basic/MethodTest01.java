package basic;
/*
 *1.  return 의 사용
 *  1) 메소드의 강제종료
 *  2) 값의 반환
 *  
 *2. 메소드 오버로딩 (Overloading)
 *	: 메소드명은 같으나 파라미터의 갯수나 타입이 다른 경우
 */
public class MethodTest01 {
	public static void main(String[] args) {
		print();
		print();
		print("Kim");
		print("KH");
		int a = 7, b = 4;
		System.out.println(a+"+"+b+"="+add(a, b));
		System.out.println(a+"-"+b+"="+sub(a, b));
		System.out.println(a+"*"+b+"="+mul(a, b));
		System.out.println(a+"/"+b+"="+div(a, b));
		System.out.println(a+"%"+b+"="+mod(a, b));
		
	}    //Public은 다른데서 사용가능 (호출할수 있다. = 공공)
	// 메소드 정의!!!
	
	
	private static int add(int a, int b) {
		
		return a + b;
	}

	private static int sub(int a, int b) {

		return a - b;
	}

	private static int mul(int a, int b) {

		return a * b;
	}

	private static int div(int a, int b) {

		return a / b;
	}

	private static int mod(int a, int b) {

		return a % b;
	}

	private static void print(String name) {
		System.out.println("Hello " + name);
		
	}

	private static void print() {
		System.out.println("Hello World");
		return;  //return : 종료
	}    //Private 는 여기서만 사용가능, 다른데서는 호출못함
	
	
}
