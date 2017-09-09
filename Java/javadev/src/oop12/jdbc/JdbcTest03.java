package oop12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[로그인]");
		String id = null;
		String name = null;
		String password = null;
		
		System.out.print("id : "); id = sc.nextLine();
		System.out.print("password : "); password = sc.nextLine();
		
		
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		sc.close();
		
		String sql = 
				"SELECT name " +
				"FROM j_member " +
				"WHERE id='" + id + "' AND password='" + password + "'";
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
					
			st = cn.createStatement();
			rs = st.executeQuery(sql);
					
			if(rs.next()) {
				name = rs.getString("name");
				System.out.println(name + "(" + id + ")님이 로그인 하였스니다.");
			}else {
				System.out.println("아이디 혹은 패스워드가 틀립니다.");
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(Exception e) {}
			if(st!=null) try {st.close();} catch(Exception e) {}
			if(cn!=null) try {cn.close();} catch(Exception e) {}
		}			
	}
}