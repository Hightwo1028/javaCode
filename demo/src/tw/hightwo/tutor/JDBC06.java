package tw.hightwo.tutor;

import java.io.FilterWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

public class JDBC06 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String url = "jdbc:mysql://127.0.0.1:3306/Hightwo";
		
		
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			String sql = "SELECT * FROM gift ORDER BY city";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
			
				System.out.printf("%s : %s : %s\n", id, name, city);
			}
//			System.out.println(rs.getRow());
//			rs.next();
//			System.out.println(rs.getRow());
//			String id = rs.getString("id");
//			System.out.println(id);
//								 //(第幾個欄位)/(欄位名稱)
//			String name = rs.getString("name");
//			System.out.println(name);
			
//			for(int i = 1; i < sql.length(); i++) {
//				System.out.println("----------");
//				rs.next();
//				System.out.println(rs.getRow());
//				id = rs.getString("id");
//				System.out.println(id);
//				System.out.println(id);
//									 //(第幾個欄位)/(欄位名稱)
//				name = rs.getString("name");
//				System.out.println(name);
//			}
			


			

		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}

}
