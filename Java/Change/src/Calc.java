public class Calc {
	//마트에서 물건을 사고 거스름돈 계산
	public static void main(String[] args) {
		Calc c = new Calc();
		c.calc(12222, 3750);
	}
	
	public void calc(int payment, int price) {
		int totalChange = payment - price;
		int fiveThousand = totalChange / 5000;
		totalChange %= 5000;
		int thousand = totalChange / 1000;
		totalChange %= 1000;
		int fiveHundred = totalChange / 500;
		totalChange %= 500;
		int hundred = totalChange / 100;
		totalChange %= 100;
		int fifty = totalChange / 50;
		totalChange %= 50;
		int ten = totalChange / 10;
		
		System.out.println("총 거스름돈 : " + totalChange +"원");
		System.out.println("오천원 : " + fiveThousand + "개");
		System.out.println("천원 : " + thousand + "개");
		System.out.println("오백원 : " + fiveHundred + "개");
		System.out.println("백원 : " + hundred + "개");
		System.out.println("오십원 : " + fifty + "개");
		System.out.println("십원 : " + ten + "개");
	}
}
