package oop13.stream;
import java.io.BufferedInputStream;
/*
 * : 컴퓨터의 현재 시간을 기준으로 1970년 1월 1일 자정 이후로 지나온 시간을
 *   밀리 초(1/1000초) 단위로 계산해서 반환하는 메소드.
 */
import java.io.FileInputStream;

public class IOTest08 {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream("Marvel_Logo.jpg");
		start = System.currentTimeMillis(); // 시간 측정 시작
		while(fis1.read() != -1) {}
		end = System.currentTimeMillis(); // 시간 측정 끝
		System.out.println("BufferedInputStream을 사용하지 않았을 때 : " + (end-start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream("Marvel_Logo.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis(); // 시간 측정 시작
		while(bis.read() != -1) {}
		end = System.currentTimeMillis(); // 시간 측정 끝
		System.out.println("BufferedInputStream을 사용할 때 : " + (end-start) + "ms");
		
		bis.close();
		fis2.close();
	}
}
