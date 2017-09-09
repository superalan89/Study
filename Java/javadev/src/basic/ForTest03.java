package basic;

public class ForTest03 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1; i<=1000; i++) {
			if (i%3==0) {
				sum += i;				
			}
		}
		
		/*for(int i=0; i<=1000; i+=3) {
			sum += i;
		}*/
		
		System.out.println("1부터 1000까지 3의 배수 합계는 : " + sum);
	}
}
