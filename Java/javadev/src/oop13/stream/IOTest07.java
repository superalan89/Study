package oop13.stream;

import java.io.FileReader;

public class IOTest07 {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("sample2.txt");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while((readCharNo=fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		fr.close();
	}
}
