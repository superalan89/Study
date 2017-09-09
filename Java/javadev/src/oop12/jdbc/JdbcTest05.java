package oop12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest05 {
	public static void main(String[] args) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT no, name, title " +
				"FROM j_board " +
				"ORDER BY no DESC ";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
			
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();  //글쓰기 수정, 삭제는 executeUpdate, 단순 DB 갖고오는건 executeQuery
			
			System.out.println("글번호\t\t이름\t\t제목");
			System.out.println("========================================================");
			while(rs.next()) {
				System.out.println(rs.getInt("no") + "\t\t" +
								   rs.getString("name") + "\t\t" +
								   rs.getString("title"));   
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
