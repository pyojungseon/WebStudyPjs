package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import spms.jdbc.MemberConnection;


@WebServlet("/member/list")
public class MemberListServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("jdbc:mysql://127.0.0.1:9011/studydb || id : study || pwd : 1111");
		System.out.println("test add member");
		
		String query = null;
		
		MemberConnection member = new MemberConnection();
		member.openConnection();
		query = "select SEQ, NNAME, EMAIL, REG_DATE, MOD_DATE"
				+ " from MEMBERS"
				+ " order by SEQ ASC";
		try {
			ResultSet rs = member.selectQuery(query);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			out.println("<p><a href='add'>신규 회원</a></p>");
			
			while(rs.next()) {
				out.println(
						rs.getInt("SEQ") + ", " +
						rs.getString("NNAME") + ", " +
						rs.getString("EMAIL") + ", " +
						rs.getString("REG_DATE") + ", " +
						rs.getString("MOD_DATE") + ", " + "<br>"
						);
			}
			
			out.println("</body></html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			member.closeConnection();
		}
		
		/*
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:9011/studydb", //JDBC URL
					"study",	// DBMS 사용자 아이디
					"1111");	// DBMS 사용자 암호
			
			stmt = conn.createStatement();
			
			String query = "select SEQ, NNAME, EMAIL, REG_DATE, MOD_DATE"
					+ " from MEMBERS"
					+ " order by SEQ ASC";
			rs = stmt.executeQuery(query);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			out.println("<p><a href='add'>신규 회원</a></p>");
			
			while(rs.next()) {
				out.println(
						rs.getInt("SEQ") + ", " +
						rs.getString("NNAME") + ", " +
						rs.getString("EMAIL") + ", " +
						rs.getString("REG_DATE") + ", " +
						rs.getString("MOD_DATE") + ", " + "<br>"
						);
			}
			
			out.println("</body></html>");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		} finally {
			try{if (rs!=null) rs.close();} catch (Exception e) {}
			try{if (stmt!=null) stmt.close();} catch (Exception e) {}
			try{if (conn!=null) conn.close();} catch (Exception e) {}
		}
		
		*/
	}

}
