package oop09.exception01;
/*
 * Runtime Exception2 (Unchecked Exception)
 * 
 *  	: ArrayIndexOutOfBoundsException
 */
public class ExceptionTest02b {
	public static void main(String[] args) {
		if(args.length == 2) {
			String data1 = args[0];
			String data2 = args[1];
			System.out.println("args[0] : " + args[0]);
			System.out.println("args[1] : " + args[1]);
		} else {
			System.out.println("[실행방법]");
			System.out.println("[java ExceptionTst02b 값1 값2]");
		}
		
		
	}
}
