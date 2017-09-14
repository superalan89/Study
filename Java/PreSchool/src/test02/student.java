package test02;

public class student {
	public static void main(String[] args) {
		String temp = "abcdefghijk";
		
		String[] array = temp.split("");
		
		for(String item : array) {
			System.out.println(item);
		}
		
		
	}
}
