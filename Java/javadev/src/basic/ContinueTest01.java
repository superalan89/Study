package basic;

public class ContinueTest01 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=10; i++) {
			if(i%3!=0) continue; //반복문 블럭의 마지막으로!! 혹은 증감식으로 간다.
			sum += i;
		}
	
		System.out.println("1부터 10까지 합계는" + sum);
	}
}
