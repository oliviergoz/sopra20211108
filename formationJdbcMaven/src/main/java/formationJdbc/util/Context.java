package formationJdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Context {
	private Connection connection;
	private static Context singleton = null;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Context getInstance() {
		if (singleton == null) {
			singleton = new Context();
		}
		return singleton;
	}

	public static void destroy() {
		if (singleton != null) {
			try {
				singleton.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			singleton = null;
		}
	}

	private Context() {
		try {
			this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/formation", "postgres",
					"postgres");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
