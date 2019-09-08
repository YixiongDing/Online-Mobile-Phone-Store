package DataMapper;

import java.util.ArrayList;
import java.util.List;

import DataMapper.*;
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
			newObjects.add(obj);
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
	
	public boolean commit(String sessionId) {
		boolean addResult = true;
		boolean updateResult = true;
		boolean deleteResult = true;
		
		//deal with new objects
		for(DomainObject obj: newObjects) {
			if(!addResult) {
				return false;
			}
			try {
				DataMapper dm = (DataMapper) Class.forName(
						"dataMapper."+obj.getClass().getSimpleName()+"Mapper").getDeclaredConstructor().newInstance();
				addResult = dm.insert(obj);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//deal with dirty objects
		for(DomainObject obj: dirtyObjects) {
			if(!updateResult) {
				return false;
			}
			
			try {
				DataMapper dm = (DataMapper) Class.forName(
						"dataMapper."+obj.getClass().getSimpleName()+"Mapper").getDeclaredConstructor().newInstance();
				ImplicitMapper im = new ImplicitMapper(
						dm, sessionId, obj.getClass().getSimpleName());
				updateResult = im.update(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//deal with deleted objects
		for(DomainObject obj: deletedObjects) {
			if(!deleteResult) {
				return false;
			}
			
			try {
				DataMapper dm = (DataMapper) Class.forName(
						"dataMapper."+obj.getClass().getSimpleName()+"Mapper").getDeclaredConstructor().newInstance();
				ImplicitMapper im = new ImplicitMapper(
						dm, sessionId, obj.getClass().getSimpleName());
				deleteResult = im.delete(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return addResult&&updateResult&&deleteResult;
	}

}
