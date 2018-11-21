package lesson03.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/calc")
public class CalculatorServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		System.out.println("IP Address : "+request.getRemoteAddr());
		System.out.println("Scheme : "+request.getScheme());
		System.out.println("Protocol : "+request.getProtocol());
		System.out.println("param name : "+request.getParameterNames().toString());
		System.out.println("param value : "+request.getParameterMap().toString());
		
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("a=" + a + ", " + "b=" + b+" result");
		writer.println("a + b = "+(a+b));
		writer.println("a - b = "+(a-b));
		writer.println("a / b = "+((float)a/(float)b));
		writer.println("a % b = "+(a%b));
	}

}
