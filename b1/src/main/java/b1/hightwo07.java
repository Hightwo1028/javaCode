package b1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class hightwo07 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String x, y, result, op;
		x = y = result = op = "";

		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("x") != null) {
			x = request.getParameter("x");
			y = request.getParameter("y");
			op = request.getParameter("op");
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			int r1, r2;

			try {
				switch (op) {
				case "1":
					r1 = intX + intY;
					result += r1;
					break;
				case "2":
					r1 = intX - intY;	
					result += r1;
					break;
				case "3":
					r1 = intX * intY;	
					result += r1;
					break;
				case "4":
					r1 = intX / intY;
					r2 = intX % intY;
					result += String.format("%d ...... %d", r1, r2);
					break;
				}
			} catch (Exception e) {
				
			}

//			try {
//				int r = Integer.parseInt(x) + Integer.parseInt(y);
//				result += r;
//			} catch (Exception e) {
//
//			}
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta charset='UTF-8'>");
		out.println("<form action='hightwo07'>");
		out.printf("<input name='x' value='%s' />\n", x);
		out.println("<select name='op'>");
		out.printf("<option value='1' %s>+</option>", op.equals("1") ? "selected":"");
		out.printf("<option value='2' %s>-</option>", op.equals("2") ? "selected":"");
		out.printf("<option value='3' %s>x</option>", op.equals("3") ? "selected":"");
		out.printf("<option value='4' %s>/</option>", op.equals("4") ? "selected":"");
		out.println("</select>");
		out.printf("<input name='y' value='%s' />\n", y);
		out.println("<input type='submit' value='=' />");
		out.printf("<span>%s</span>\n", result);
		out.println("</form>");

		response.flushBuffer();

	}

}
