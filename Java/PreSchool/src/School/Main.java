package School;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Student {
	
	public static void main (String[] args) {
		
		
		// 성적입력프로그램의 초기화 부분 클래스, ArrayList
		
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		ArrayList list = new ArrayList();
		
		
		while (true) {
			System.out.println("==============성적입력================");
			System.out.println("1. 성적 ㅣ 2. 출력");
			
			int temp = sc.nextInt();
			if (temp == 1) {
				
				sc.nextLine();
				
				// 성적을 입력하는 입력부
				System.out.println("==============이름입력================");
				student.name = sc.nextLine();
				
				System.out.println("==============국어성적입력================");
				student.score_korea = sc.nextInt();
				
				System.out.println("==============영어성적입력================");
				student.score_eng = sc.nextInt();
				
				System.out.println("==============수학성적입력================");
				student.score_math = sc.nextInt();
				
				student.number = 1;

				list.add(student);	
			}
			
			if (temp == 2) {
				
				// 성적 입력 후 데이터를 출력해주는 출력부
				
				Student studentInput = null ;
				
				for(int i = 0 ; i < list.size(); i++) {
					studentInput = (Student) list.get(i);
				}
				
				System.out.println("=============출력==============");
				System.out.println("이름 : " + studentInput.name);
				System.out.println("번호 : " + studentInput.number);
				System.out.println("국어성적 : " + studentInput.score_korea);
				System.out.println("영어성적: " + studentInput.score_eng);
				System.out.println("수학성적 : " + studentInput.score_math);			
			}
		}
				
	}
}
