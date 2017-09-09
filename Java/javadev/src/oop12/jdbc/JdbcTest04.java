package oop12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[로그인]");
		String id = null;
		String name = null;
		String password = null;
		
		System.out.print("id : "); id = sc.nextLine();
		System.out.print("password : "); password = sc.nextLine();
		
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		sc.close();
		
		String sql = 
				"SELECT name " +
				"FROM j_member " +
				"WHERE id=? AND password=?";
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
					
			ps = cn.prepareStatement(sql);   //jdbc 작성할때 prepareStatement로 작성
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();  //미리 넘겼기 때문에 sql은 지운다
					
			if(rs.next()) {
				name = rs.getString("name");
				System.out.println(name + "(" + id + ")님이 로그인 하였습니다.");
			}else {
				System.out.println("아이디 혹은 패스워드가 틀립니다.");
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(Exception e) {}
			if(ps!=null) try {ps.close();} catch(Exception e) {}
			if(cn!=null) try {cn.close();} catch(Exception e) {}
		}			
	}
}