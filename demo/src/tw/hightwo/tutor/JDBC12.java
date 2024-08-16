package tw.hightwo.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC12 {
	private static final String USER = "root";
	private static final String PASSWd = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/Hightwo";
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWd);

		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String account = rs.getString("account");
				InputStream in = rs.getBinaryStream("icon");

				// ==================
				new Thread() {
					public void run() {
						try {
							String filename = String.format("dir2/%s.png", account);
							FileOutputStream fout = new FileOutputStream(filename);
							byte[] buf = new byte[64 * 1024];
							int len = in.read(buf);
							fout.write(buf, 0, len);
							fout.flush();
							fout.close();
							System.out.println("Save OK");
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				}.start();
				
				System.out.println("Main Finish");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
