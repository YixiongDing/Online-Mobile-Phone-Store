package concurrency;

import java.sql.ResultSet;

import database.DBConnection;

import java.sql.*;

public class ExclusiveWriteLockManager implements LockManager {

	private static ExclusiveWriteLockManager lm;
	private final int LOCKAVAILABLE = 0;
	private final int HOLDLOCK = -1;

	private ExclusiveWriteLockManager() {

	}

	/**
	 * An static method to get the the Lock Manager instance
	 * @param 
	 * @return ExclusiveWriteLockManager
	 */
	public static ExclusiveWriteLockManager getInstance() {
		if (lm == null) {
			lm = new ExclusiveWriteLockManager();
		}	
		return lm;
	}

	/**
	 * A method to acquire lock on database table
	 * @param String tablename, String id, String sessionId
	 * @return boolean result
	 */
	@Override
	public boolean acquireLock(String tablename, String id, String sessionId) throws Exception {
		boolean result = false;
		int status = hasLock(tablename, id, sessionId);
		// if current session can take the lock

		if (status==LOCKAVAILABLE) {
			String acquireSQL = "insert into Lock (Id, sessionId, tableName)"
					+ " values (?,?,?);"; 
			Connection conn = DBConnection.getDBConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(acquireSQL);
			pStatement.setString(1, id);
			pStatement.setString(2, sessionId);
			pStatement.setString(3, tablename);
			int sqlResult = pStatement.executeUpdate();
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);

			if (sqlResult == 1)
				result = true;
		}
		else if (status==HOLDLOCK) {
			result = true;
		}
		return result;
	}

	/**
	 * A method to release lock on database table
	 * @param String tablename, String id, String sessionId
	 * @return boolean result
	 */
	@Override
	public boolean releaseLock(String tablename, String id, String sessionId) throws Exception {
		String releaseSQL = "delete from Lock where tableName=? AND Id=?"
				+" AND sessionId=?";
		Connection conn = DBConnection.getDBConnection();
		PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(releaseSQL);
		pStatement.setString(1, tablename);
		pStatement.setString(2, id);
		pStatement.setString(3, sessionId);

		int result = pStatement.executeUpdate();

		if (result == 0)
			return false;
		else
			return true;
	}

	/**
	 * A method to check if has lock on database table
	 * @param String tablename, String id, String sessionId
	 * @return int result
	 * @exception 
	 */
	private int hasLock(String tablename, String id, String sessionId) {
		String hasLockSQL = "SELECT sessionId FROM Lock WHERE id =?" +
				"AND tableName=?";
		int result = 0;
		Connection conn;
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(hasLockSQL);
			pStatement.setString(1, id);
			pStatement.setString(2, tablename);

			ResultSet resultSet = pStatement.executeQuery();
			// if current object has been locked
			while (resultSet.next()) {
				String session_in_DB = resultSet.getString(1);
				// if current session has the lock
				if (session_in_DB.equals(sessionId)) {
					result = 1;
				}
				// if the lock has been taken by others
				else {
					result = -1;
				}
			}
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
