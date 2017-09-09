package basic;

public class DoWhileTest01 {
	public static void main(String[] args) {
		int sum = 0;
		
		int i=1; 
		do {
			if (i%3==0) sum += i;				
			i++;
		} while(i<=1000);
		
		//일단 먼저 저지르고 본다.
		
		System.out.println("1부터 1000까지 3의 배수 합계는 : " + sum);
	}
}
