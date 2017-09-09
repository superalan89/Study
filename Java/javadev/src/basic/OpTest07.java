package basic;

import java.util.Scanner;

public class OpTest07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("남자면 1, 여자면 2 입력 : ");
		
		
		int n = sc.nextInt();
		
		System.out.println(n==1 ? "남자입니다." :
						   n==2 ? "여자입니다." :
							      "에러입니다."); //n이 1일때 남자입니다. 2면 여자, 나머지는 에러
		sc.close();
	}
}
