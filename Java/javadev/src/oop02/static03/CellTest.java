package oop02.static03;

public class CellTest {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator.pi;
		System.out.println("result1 : " + result1);
		
		int result2 = Calculator.plus(10, 5);
		System.out.println("result2 : " + result2);
		
		int result3 = Calculator.minus(10, 5);
		System.out.println("result3 : " + result3);
		
	}
}
