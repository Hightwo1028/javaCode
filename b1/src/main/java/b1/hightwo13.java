package b1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class hightwo13
 */
public class hightwo13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("hightwo14");
		
		response.setContentType("text/html; charset=UTF=8");
		response.getWriter().print("Hello, I am Hightwo13");
		dispatcher.forward(request, response);
		response.getWriter().print("after");
		
	}


}
