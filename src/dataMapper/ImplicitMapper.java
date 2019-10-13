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
 * insert function don't need to apply for the lock
 */
public boolean insert(DomainObject obj) {
	return impl.insert(obj);
}

/**
 * before update, apply for the lock
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
 * before delete, apply for the lock
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
