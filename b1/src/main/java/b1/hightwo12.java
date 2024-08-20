package b1;

import java.io.IOException;

import hightwo.tw.apis.Bike;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Brad12
 */

public class hightwo12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
//		String x = request.getParameter("x");
		
		int intX = (Integer)request.getAttribute("x");
		String aname = (String)request.getAttribute("name");
		Bike b1 = (Bike)request.getAttribute("bike");
		
		response.getWriter().printf("Welcome, %s, %d, %s, %s", name, intX, aname, b1);
	
	}

}
