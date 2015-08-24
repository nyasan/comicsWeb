package dao;
/**This class manage the connections with the DataBase Postgresql
 * It's apply a Singleton to keep an unique instance of the class
 * **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private final String DRIVER = "org.postgresql.Driver";
	private final String PASSWORD = "sistemas";
	private final String USERNAME = "postgres";
	private final String CONNECTION_URL = "jdbc:postgresql://127.0.0.1:5432/Comics";
	private static volatile ConnectionManager instance;
	private Connection con;

	private ConnectionManager() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Your Driver are missed");
		}
	}

	public Connection open() {
		try {
			String url = CONNECTION_URL;
			con = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("The credentials are not correct or your DB name is not correct spell it");
		}
		return con;
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Cant close the DB, server is busy");
		}
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			synchronized (ConnectionManager.class) {
				if (instance == null) {
					instance = new ConnectionManager();
				}
			}
		}

		return instance;
	}
}
