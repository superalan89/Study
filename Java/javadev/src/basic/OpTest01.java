package basic;

import java.util.Scanner;

public class OpTest01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  //System.in은 콘솔입력(표준입력) 즉, 키보드 입력을 의미
		
		// shift f2 로 문서확인가능
		
		System.out.print("정수 a값 입력 : ");
		
		int a = sc.nextInt();
		
		System.out.print("정수 b값 입력 : ");
		
		int b = sc.nextInt();
				
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println(a+"/"+b+"="+(a/b));  // 정수랑 정수를 나누면 결과도 정수
		System.out.println(a+"%"+b+"="+(a%b));  // 나머지결과값만
		
		sc.close();
	}
}
