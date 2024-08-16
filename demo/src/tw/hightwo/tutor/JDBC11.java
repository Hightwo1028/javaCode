package tw.hightwo.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBC11 {

	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/Hightwo";
	private static final String SQL_UPDATE  = "UPDATE member SET icon = ? WHERE id = ?";
	

	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			FileInputStream fin = new FileInputStream("dir1/ball3.png");
			pstmt.setBinaryStream(1, fin);
			pstmt.setInt(2, 1);
			if(pstmt.executeUpdate() > 0) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
