package b1;

import java.io.IOException;

import hightwo.tw.apis.hightwoUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hightwo16
 */
public class hightwo16 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//取出Attribute
		String result = (String)request.getAttribute("result");
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		String view = (String)request.getAttribute("view");
		
		try {
			//Load View
			String webPage = hightwoUtils.loadView(view);
			
			//Show View
			response.getWriter().printf(webPage, x, y, result);
			response.flushBuffer();
		} catch (Exception e) {
			response.getWriter().print("Error!");
			response.flushBuffer();
		}
		
		
		

	}



}
