package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	public Connection connection;

	public Connection getConnection() {

		String dbName = "3506final";
		String userName = "root";
		String password = "0144626";
		String url = "jdbc:mysql://localhost/" + dbName;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;

	}
}
