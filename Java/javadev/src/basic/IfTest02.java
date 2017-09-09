package basic;

import java.util.Scanner;

public class IfTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("0 ~100 사이의 점수 입력 : ");
		
		int n = sc.nextInt();
		
		if(n>100) {
			System.out.println("잘못입력했습니다.");
		}else if(n>=90) {
			System.out.println("A");
		}
		else if(n>=80) {
			System.out.println("B");
		}else if(n>=70) {
			System.out.println("C");
		}else if(n>=60) {
			System.out.println("D");
		}else if(n>=0) {
			System.out.println("F");
		}
		else {
			System.out.println("잘못입력했습니다.");
		}
		
		sc.close();
	}
}
