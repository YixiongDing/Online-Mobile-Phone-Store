package database;

import java.sql.*;

public class DBConnection {

	// Heroku database
	private static final String DB_CONNECTION = "jdbc:postgresql://"+"ec2-107-20-230-70.compute-1.amazonaws.com:5432"
			+"/d6ivkt4itip8g7?sslmode=require";
	private static final String DB_USER = "hsummenpuzwipk";
	private static final String DB_PASSWORD = "8d9582ad16774861511f05fa48caf5a089a62168fabda3591874b44e28e95d00";

	// local database
	// private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/OnlineMobile_db";
	// private static final String DB_USER = "postgres";
	// private static final String DB_PASSWORD = "1234";


	private static ThreadLocal<Connection> current = new ThreadLocal<Connection>();
	static Connection dbConnection = null;


	public static PreparedStatement prepare(String stm, Connection dbConnection) throws SQLException {

		PreparedStatement preparedStatement = null;
		try {	
			preparedStatement = dbConnection.prepareStatement(stm);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return preparedStatement;
	}
	
	/**
	 * A method to get database connection
	 */
	public static Connection getDBConnection() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());

			dbConnection = DriverManager.getConnection(
					DB_CONNECTION, DB_USER, DB_PASSWORD);
			dbConnection.setAutoCommit(true);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Connection problem");
		return null;
	}

	/**
	 * close statment
	 * @param statement
	 * @throws Exception
	 */
	public static void closeStatement(Statement statement) throws Exception {
		statement.close();
	}

	/**
	 * close preparedStatement
	 * @param pStatement
	 * @throws Exception
	 */
	public static void closePreparedStatement(PreparedStatement pStatement)
			throws Exception {
		pStatement.close();
	}

	/**
	 * close resultSet
	 * @param resultSet
	 * @throws Exception
	 */
	public static void closeResultSet(ResultSet resultSet) throws Exception {
		resultSet.close();
	}

	/**
	 * Close the connection, and clean the closed connection instance in current thread.
	 * @param connection
	 * @throws Exception
	 */
	public static void closeConnection(Connection connection) throws Exception {
		current.set(null);
		connection.close();
	}
}
