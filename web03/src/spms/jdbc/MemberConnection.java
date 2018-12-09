package spms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberConnection {

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public boolean openConnection() {
		System.out.println("member db connection");
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:9011/studydb", //JDBC URL
					"study",	// DBMS 사용자 아이디
					"1111");	// DBMS 사용자 암호
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}
	
	public ResultSet selectQuery(String query) throws SQLException {
		System.out.println("member db query execute");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
	}
	
	public int insertQuery(String query, String...params) throws SQLException {
		pstmt = conn.prepareStatement(query);
		for(int i=0;i<params.length;i++) {
			pstmt.setString(i+1, params[i]);
		}
		return pstmt.executeUpdate();
	}
	
	public void closeConnection() {
		System.out.println("member db close");
		try{if (rs!=null) rs.close();} catch (Exception e) {}
		try{if (stmt!=null) stmt.close();} catch (Exception e) {}
		try{if (pstmt!=null) pstmt.close();} catch (Exception e) {}
		try{if (conn!=null) conn.close();} catch (Exception e) {}
	}
	
}
