package b1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class hightwo01 extends HttpServlet {

		public static final String html = null;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			System.out.println("OK");
			PrintWriter pw = response.getWriter();
			pw.print("Hello, Hightwo");
			
			
			
		}

	}
