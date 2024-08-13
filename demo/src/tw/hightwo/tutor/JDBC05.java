package tw.hightwo.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Name: ");
		String name = scanner.next();
		System.out.print("Tel: ");
		String phone = scanner.next();
		System.out.print("Birthday: ");
		String birthday = scanner.next();
		
		String url = "jdbc:mysql://localhost:3306/Hightwo";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url, prop)){
			String sql = "INSERT INTO cust (name,phone,birthday) VALUES (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
						//參數索引
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, birthday);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Inser Success");
			}else {
				System.out.println("xxxx");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
