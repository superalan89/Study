package basic;

import java.util.Scanner;

public class SwitchTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("0 ~100 사이의 점수 입력 : ");
		
		int n = sc.nextInt();
		
		switch(n/10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
		sc.close();
	}
}
