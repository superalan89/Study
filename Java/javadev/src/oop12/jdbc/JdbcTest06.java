package oop12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcTest06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[게시판 입력]");
		String title = null;
		String name = null;
		String password = null;
		String content = null;
		
		System.out.print("제목 : "); title = sc.nextLine();
		System.out.print("이름 : "); name = sc.nextLine();
		System.out.print("비밀번호 : "); password = sc.nextLine();
		System.out.print("내용 : "); content = sc.nextLine();
		
		sc.close();
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		String sql = 
				"INSERT INTO j_board(no, title, name, password, content) " + 
				"VALUES(j_board_seq.nextval,?,?,?,?) ";
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, content);
			ps.executeUpdate();
			
			System.out.println("글이 등록되었습니다.");
					
		} catch(Exception e) {
			System.out.println("글 등록 실패 : " + e.getMessage());
		} finally {
			if(ps!=null) try {ps.close();} catch(Exception e) {}
			if(cn!=null) try {ps.close();} catch(Exception e) {}
			
		}
		
	}
}
