package b1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import hightwo.tw.apis.MyModel;

/**
 * Servlet implementation class hightwo15
 */
public class hightwo15 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//接收參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		//運算
		try {
			MyModel myModel = new MyModel(x, y);
			String result = myModel.plus();
			request.setAttribute("result", result);
			request.setAttribute("x", x);
			request.setAttribute("y", y);
			request.setAttribute("view", "view2");
		} catch (Exception e) {
			request.setAttribute("result", "");
			request.setAttribute("x", x == null ? "" : x);
			request.setAttribute("y", y == null ? "" : y);
			request.setAttribute("view", "view1");
		}
		
		//呈現View
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("hightwo16");
		dispatcher.forward(request, response);
	}
	



}
