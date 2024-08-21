package b1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hightwo21
 */
public class Hightwo21 extends HttpServlet {
	private Connection conn;
	
	 public Hightwo21() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/hightwo", "root", "root");
				System.out.println("OK");
			} catch (Exception e) {
				System.out.println("Oooop!");
			}    	
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String account = request.getParameter("account");
			String passwd = request.getParameter("passwd");
			
			if (account == null) {
				response.sendRedirect("login.html");
				return;
			}
			System.out.println("debug1");
			try {
				String sql = "SELECT * FROM member WHERE account = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, account);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("debug2");
				if (rs.next()) {
					System.out.println("debug3");
					String hashPasswd = rs.getString("passwd");
					if (BCrypt.checkpw(passwd, hashPasswd)) {
						System.out.println("debug4");
						response.sendRedirect("main.html");
					}else {
						response.sendRedirect("login.html");
					}
				}else {
					response.sendRedirect("login.html");
				}
			
			}catch(Exception e) {
				response.sendRedirect("login.html");
			}
			
			
			
		}

}
