package DataMapper;

import java.util.ArrayList;
import java.util.List;

import domain.*;

public class UnitOfWork {

	@SuppressWarnings("rawtypes")
	private static ThreadLocal current = new ThreadLocal();

	private List<DomainObject> newObjects = new ArrayList<DomainObject>();
	private List<DomainObject> dirtyObjects = new ArrayList<DomainObject>();
	private List<DomainObject> deletedObjects = new ArrayList<DomainObject>();

	public static void newCurrent() { 
		setCurrent(new UnitOfWork());
	}

	public static void setCurrent(UnitOfWork uow) { 
		current.set(uow);
	}

	public static UnitOfWork getCurrent() {
		return (UnitOfWork) current.get();
	}

	public boolean checkAllList(DomainObject obj) {
		
		boolean isTrue = false;
		if(dirtyObjects.contains(obj)) {
			isTrue = true;
		}
		if(deletedObjects.contains(obj)) {
			isTrue = true;
		}
		if(newObjects.contains(obj)) {
			isTrue = true;
		}
		if(isTrue) System.out.println("obj is in the list!");

		return isTrue;
	}

	public void registerNew(DomainObject obj) {
		if(obj.getId()==null) {
			System.out.println("id is null");
			return;
		}
		if(!checkAllList(obj)) {
			newObjects.add(obj);
		}
	}

	public void registerDirty(DomainObject obj) {
		if(obj.getId()==null) {
			System.out.println("id is null");
			return;
		}
		if(!checkAllList(obj)) {
			dirtyObjects.add(obj);
		}
	}

	public void registerDeleted(DomainObject obj) {
		if(obj.getId()==null) {
			System.out.println("id is null");
			return;
		}		
		if (newObjects.remove(obj)) return;
		dirtyObjects.remove(obj);
		if (!deletedObjects.contains(obj)) {
			deletedObjects.add(obj);
		}
	}

	public boolean commit() {
		boolean result = true;
		
		for(DomainObject obj: dirtyObjects) {
			if(!result) {
				return false;
			}

			try {
				DataMapper mapper = DataMapper.getMapper(obj);
				result = mapper.update(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for(DomainObject obj: newObjects) {
			if(!result) {
				return false;
			}
			try {
				DataMapper mapper = DataMapper.getMapper(obj);
				result = mapper.insert(obj);

			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		for(DomainObject obj: deletedObjects) {
			if(!result) {
				return false;
			}
			try {
				DataMapper mapper = DataMapper.getMapper(obj);
				result = mapper.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
