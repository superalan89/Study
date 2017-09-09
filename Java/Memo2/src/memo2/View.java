package memo2;

import java.util.Scanner;

public class View {
	
	Scanner scanner = new Scanner(System.in);

	//입력창
	public void intro() {
		println("------------명령어를 입력하세요------------");
        println("c : 쓰기, r : 읽기, u : 수정, d : 삭제, l : 목록");
        println("exit : 종료");
        println("-------------------------------------");
        print("선택>");
	}
	
	// 추가
	public Memo create() {
		// 하나의 메모 객체 생성
		Memo memo = new Memo();
		print("제목을 입력하세요>");
		memo.title = scanner.nextLine();
		print("내용을 입력하세요>");
		memo.content = scanner.nextLine();
		return memo;
	}

	// 메모 하나 값 출력
	public int readMemo() {
		print("인덱스를 입력하세요>");
		int index = Integer.parseInt(scanner.nextLine());
		return index;
	}
	
	public void showMemo(Memo memo) {
		print("No : " + memo.no);
		print("|Title : " + memo.title);
		print("|Content : " + memo.content);
		println("|Date : " + memo.date);
	}
	
	public int updateMemo() {
		Memo memo = new Memo();
		print ("인덱스를 입력하세요>");
		memo.no = Integer.parseInt(scanner.nextLine());
		print("Title : ");
		memo.title = scanner.nextLine();
		print("Content : ");		
		memo.content = scanner.nextLine();
		return memo;
	}
	
	public int deleteMemo() {
		
	}
	
	public void println(String str) {
		System.out.println(str);
	}
	
	public void print(String str) {
		System.out.print(str);
	}
}
