package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.jdbc.MemberConnection;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset=\"UTF-8\"><title>회원 등록</title></head>");
		out.println("<body><h1>회원등록</h1>");
		out.println("<form action='add' method='post'>");
		out.println("이름 : <input type='text' name='name'><br>");
		out.println("이메일 : <input type='text' name='email'><br>");
		out.println("암호 : <input type='password' name='password'><br>");
		out.println("<input type='submit' value='추가'>");
		out.println("<input type='reset' value='취소'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberConnection member = new MemberConnection();
		member.openConnection();
		request.setCharacterEncoding("UTF-8");
		String result=null;
		String query = "INSERT INTO MEMBERS(EMAIL, PWD, NNAME, REG_DATE, MOD_DATE)"
				+ " VALUES (?, ?, ?, NOW(), NOW())";
		System.out.println(request.getParameter("name"));
		try {
			int i=member.insertQuery(query, request.getParameter("email"), request.getParameter("password"), request.getParameter("name"));
			result = "Success Insert Query";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = "Fail Insert Query";
			e.printStackTrace();
		} finally {
			member.closeConnection();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>회원등록결과</title></head>");
		out.println("<meta http-equiv='Refresh' content='1; url=list'>");
		out.println("<body>");
		out.println("<p>"+result+"</p>");
		out.println("</body></html>");
		
		//response.addHeader("Refresh", "1;url=list");
		//response.sendRedirect("list"); // 바로 리스트로 보내는 redirect
	}	
	
}


