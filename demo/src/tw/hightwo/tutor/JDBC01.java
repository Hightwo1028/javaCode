package tw.hightwo.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		//Load Driver(connector)
		//BUT, ....
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException();
		}
											//等價USE Hightwo
		String url1 = "jdbc:mysql://localhost:3306/Hightwo?user=root&password=root";
//		try (Connection conn = DriverManager.getConnection(url1)){
//			System.out.println("OK2");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		//jdbc:mysql://主機:土阜/庫?參數
//		String url2 = "jdbc:mysql://localhost:3306/Hightwo";
//		try (Connection conn = DriverManager.getConnection(url2, "root", "root")){
//			System.out.println("OK3");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		String url3 = "jdbc:mysql://localhost:3306/Hightwo";
		Properties prop = new Properties();
//		prop.put("key", "value");
		prop.put("user", "root");
		prop.put("password", "root");
		
		try (Connection conn = DriverManager.getConnection(url3, prop)){
			String name = "Amy";
			String phone = "1234567";
			String birthday = "1999-11-12";
			int id = 4;
			String sql = "UPDATE cust SET name = ?, phone = ?, birthday = ? WHERE id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
//預防注入攻擊				//問號位置
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, birthday);
			pstmt.setInt(4, id);
			
			pstmt.executeUpdate();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
