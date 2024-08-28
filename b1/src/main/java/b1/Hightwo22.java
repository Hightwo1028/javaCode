package b1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.mindrot.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@MultipartConfig
public class Hightwo22 extends HttpServlet {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/iii";
	private static final String SQL_INSERT = "INSERT INTO member (account,passwd,name,icon)" + 
								" VALUES (?,?,?,?)";
	private Connection conn;
	public Hightwo22() {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, prop);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part icon = request.getPart("icon");
		InputStream in = icon.getInputStream();
		
		String account = request.getParameter("account");
		String passwd = BCrypt.hashpw(request.getParameter("passwd"),BCrypt.gensalt());
		String name = request.getParameter("name");
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, account);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setBinaryStream(4, in);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}

		
		
//		byte[] buf = in.readAllBytes();
//		String base64String = Base64.getEncoder().encodeToString(buf);
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(String.format("<img src='data:image/png;base64, %s' />", base64String));
		
		response.sendRedirect("main.jsp");
	}

}