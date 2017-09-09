package oop09.exception04;

public class MyExceptionTest {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.desposit(10000); //입금하기
		System.out.println("입금액 : " + account.getBalance());
		
		try {
			account.withdraw(30000); //출금하기
		} catch (MyException e) {
			//e.printStackTrace();
			String message = e.getMessage();
			System.out.println(message);
		} 
	}
}
