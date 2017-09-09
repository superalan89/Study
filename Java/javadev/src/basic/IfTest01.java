package basic;

public class IfTest01 {
	public static void main(String[] args) {
		int n = 100;
		
		if(n==1) {
			System.out.println("남자");
		}else if(n==2) {
			System.out.println("여자");
		}else if(n==100) {
			System.out.println("ㄴㄴㄴ");
		}else if(n==50) {
			System.out.println("ㄱㄱㄱ");
		}else {
			System.out.println("에러");
		}
		
		System.out.println("종료");
		
	}
}
