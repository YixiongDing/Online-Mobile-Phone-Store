package concurrency;

public interface LockManager {
	
	/**
	 * A method to acquire lock on database table
	 * @param String tablename, String id, String sessionId
	 * @return boolean result
	 */
	public boolean acquireLock(String tablename, String id, String sessionId) throws Exception;
	
	/**
	 * A method to release lock on database table
	 * @param String tablename, String id, String sessionId
	 * @return boolean result
	 */
	public boolean releaseLock(String tablename, String id, String sessionId) throws Exception;
	
}
