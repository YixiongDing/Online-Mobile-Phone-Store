package dataMapper;

import concurrency.ExclusiveWriteLockManager;
import concurrency.LockManager;
import domain.DomainObject;

public class ImplicitMapper extends DataMapper {	

	private DataMapper impl;
	private LockManager lm;
	private String sessionId;
	private String type;

	public ImplicitMapper(DataMapper impl, String sessionId, String type) {
		this.impl = impl;
		this.lm = ExclusiveWriteLockManager.getInstance();
		this.sessionId = sessionId;
		this.type = type;
	}

	/**
	 * A method to insert function don't need to apply for the lock
	 * @param DomainObject obj
	 * @return boolean
	 */
	public boolean insert(DomainObject obj) {
		return impl.insert(obj);
	}

	/**
	 * A method to apply for the lock before update
	 * @param DomainObject obj
	 * @return boolean
	 */
	public boolean update(DomainObject obj) {
		try {
			if (lm.acquireLock(type, obj.getId(), sessionId)) {
				boolean result = impl.update(obj);
				lm.releaseLock(type, obj.getId(), sessionId);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * A method to apply for the lock before delete
	 * @param DomainObject obj
	 * @return boolean
	 */
	public boolean delete (DomainObject obj) {
		try {
			if (lm.acquireLock(type, obj.getId(), sessionId)) {
				boolean result = impl.delete(obj);
				lm.releaseLock(type, obj.getId(), sessionId);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
