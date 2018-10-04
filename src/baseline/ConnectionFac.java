package baseline;

import java.sql.*;

public class ConnectionFac {

	public static String connectionUrl = "jdbc:sqlserver://localhost:1433;database=master";
	public static String userName = "app";
	public static String password = "app";
	
	public static Connection startConnection() {
		
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			return DriverManager.getConnection(connectionUrl, userName, password);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
