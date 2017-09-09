package oop12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcTest07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int no = 0;
		String title = null;
		String name = null;
		String password = null;
		String content = null;
		
		System.out.print("수정할 레코드 no : ");
		try {
			no = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
			System.exit(1);
		}
		
		System.out.print("제목 : "); title = sc.nextLine();
		System.out.print("이름 : "); name = sc.nextLine();
		System.out.print("최초 글 작성시 이력한 비밀번호 이력 : "); password = sc.nextLine();
		System.out.print("내용: "); content = sc.nextLine();
		
		sc.close();
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		String sql =
			"UPDATE j_board " +
			"SET title=?, name=?, content=? " +
			"WHERE no=? AND password=? ";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setString(3, content);
			ps.setInt(4, no);
			ps.setString(5, password);
			
			if(ps.executeUpdate() > 0) {
				System.out.println("수정되었습니다.");
			}else {
				System.out.println("레코드가 존재하지 않거나 비밀번호가 틀립니다.");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) try {ps.close();} catch(Exception e) {}
			if(cn!=null) try {ps.close();} catch(Exception e) {}
			
		}
			
	}
}
