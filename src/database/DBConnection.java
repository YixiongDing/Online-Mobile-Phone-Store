package database;

import java.sql.*;

public class DBConnection {
	
	private static final String DB_CONNECTION = "jdbc:postgresql://"+"ec2-107-20-230-70.compute-1.amazonaws.com:5432"
								+"/d6ivkt4itip8g7?sslmode=require";
	private static final String DB_USER = "hsummenpuzwipk";
	private static final String DB_PASSWORD = "8d9582ad16774861511f05fa48caf5a089a62168fabda3591874b44e28e95d00";
	
	static Connection dbConnection = null;
	
	
	public static PreparedStatement prepare(String stm) throws SQLException {
		 
		PreparedStatement preparedStatement = null;
		try {	
	
	       	 Connection dbConnection = getDBConnection();
				
			preparedStatement = dbConnection.prepareStatement(stm);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		
		}

		return preparedStatement;
	}
	
	private static Connection getDBConnection() {



		try {
			DriverManager.registerDriver(new org.postgresql.Driver());

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER, DB_PASSWORD);
			dbConnection.setAutoCommit(false);
			
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		System.out.println("Connection problem");
		return null;

	}

}