package basic;

public class ArrayTest02 {
	public static void main(String[] args) {
		int[][] score = {	//score.length = 3 (1차원 배열의 갯수)
				{100,90,80,70},
				{ 90,80,70,60},
				{ 80,70,60,50}
		};
		
		System.out.println("\t\t[성적표]");
		System.out.println("============================================");
		System.out.println("국어\t영어\t수학\t철학\t총점\t평균");

		for (int row = 0; row < score.length; row++) {
			int total = 0;
			for (int col = 0; col < score[row].length; col++) {
				System.out.print(score[row][col] + "\t"); // \t 는 tap의 약자로 '간격'을 의미
				total += score[row][col];
			}
			System.out.println(total + "\t" + (total / score[row].length));
		}
		
	}
}
