package oop13.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOTest05 {
	public static void main(String[] args) throws Exception {
		String orginalFileName = "sample.txt";
		String targetFileName = "copy.txt";
		
		FileInputStream fis = new FileInputStream(orginalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo;
		byte[] readBytes = new byte[100];
		while((readByteNo = fis.read(readBytes)) !=-1) {
			fos.write(readBytes, 0, readByteNo);
		}
		
		fos.close();
		fis.close();
		
		System.out.println("복사가 잘 되었습니다.");
		
	}
}
