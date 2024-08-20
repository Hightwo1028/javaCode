package b1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class hightwo08
 */
public class hightwo08 extends HttpServlet {
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println(req.getMethod());
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String[] hobby = request.getParameterValues("hobby");
		System.out.println("doPost");
		System.out.printf("%s, %s", account, passwd);
		if(hobby != null) {
			for(String h : hobby) {
				System.out.print(h);
			}
		}
	}

}
