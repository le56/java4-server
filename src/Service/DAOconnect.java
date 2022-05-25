package Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOconnect {
	private static String DB_URL = "jdbc:mysql://localhost:3306/doan";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";

	public static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		DAOconnect.getConnection(DB_URL, DB_URL, PASSWORD);
	}
}
