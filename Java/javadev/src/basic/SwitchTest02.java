package basic;

import java.util.Scanner;

public class SwitchTest02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("남자면 1,3 여자면 2,4 입력 : ");
		
		int n = sc.nextInt();
		
		switch(n) {
		case 1:
		case 3:
			System.out.println("남자");
			break;
		case 2:
		case 4:
			System.out.println("여자");
			break;
		default:
			System.out.println("에러");
			break;
		}
		
		sc.close();
	}
}
