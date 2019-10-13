package concurrency;

public interface LockManager {
	

	public boolean acquireLock(String type, String id, String sessionId) throws Exception;
	

	public boolean releaseLock(String type, String id, String sessionId) throws Exception;
	
}
