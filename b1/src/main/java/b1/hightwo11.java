package b1;

import java.io.IOException;
import java.io.PrintWriter;

import hightwo.tw.apis.Bike;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hightwo11
 */
public class hightwo11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("hightwo12");
		
		request.setAttribute("x", 10);
		request.setAttribute("name", "Peter");
		Bike b1 = new Bike();
		b1.upSpeed();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<h1>Brad Big Company</h1>")
			.append("<hr />")
			.append("<div>Hello, World</div>")
			.append("<hr />");
		dispatcher.include(request, response);
		out.append("<hr />");
		
		response.flushBuffer();
	
	
	}

}
