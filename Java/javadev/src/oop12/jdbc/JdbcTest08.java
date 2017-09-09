package oop12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcTest08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int no = 0;
		String password = null;
		
		System.out.println("삭제할 레코드 no : ");
		
		try {
			no = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
			System.exit(1);
		}
		
		System.out.println("처음 글 작성시 입력한 비밀번호를 재입력하세요 : ");
		password = sc.nextLine();
		
		sc.close();
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		String sql = 
				"DELETE FROM j_board " + 
				"WHERE no =? AND password=? ";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
			
			ps = cn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, password);
					
			
			if(ps.executeUpdate() > 0) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("비밀번호가 틀립니다.");
			}
			
		}catch(Exception e) {
			System.out.println("삭제 실패 : " + e.getMessage());
		}finally {
			if(ps!=null) try {ps.close();} catch(Exception e) {}
			if(cn!=null) try {ps.close();} catch(Exception e) {}
		}
	}
}
