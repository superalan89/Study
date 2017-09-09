package oop13.stream;

import java.io.File;
import java.io.FileWriter;

public class IOTest06 {
	public static void main(String[] args) throws Exception {
		File f = new File("sample2.txt");
		FileWriter fw = new FileWriter(f);
		fw.write("그래, 난 정대만." + "\r\n");   // \r 뜻은 커서를 왼쪽 \n 다음줄로이동 : Enter키 효과
		fw.write("절대로 포기하지 않는 남자지!");
		
		fw.close();
		
		System.out.println("파일에 저장되었습니다.");
	}
}
