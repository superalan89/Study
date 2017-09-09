package oop13.stream;

import java.io.FileOutputStream;

public class IOTest01 {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("sample.txt");
		for(int i='A'; i<='Z'; i++) {
			fos.write(i);
		}
		fos.close();
	}
}
