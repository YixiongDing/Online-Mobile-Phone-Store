package dataMapper;

import java.util.Map;
import java.util.HashMap;

public class IdentityMap<E> {

	private Map<Long, E> map = new HashMap<Long, E>();

	@SuppressWarnings("rawtypes")
	private static Map<Class, IdentityMap> singletons = new HashMap<Class, IdentityMap>();
	
	/**
	 * A method to get an instance of identity map
	 * @param IdentityMap e
	 * @return IdentityMap result
	 */
	public static <E>IdentityMap<E> getInstance(E e)
	{
		@SuppressWarnings("unchecked")
		IdentityMap<E> result = singletons.get(e.getClass());
		if (result == null) {
			result = new IdentityMap<E>();
			singletons.put(e.getClass(), result);
		}
		return result;
	}
	
	/**
	 * A method to put an object into the identity map
	 */
	public void put(long id, E obj) {
		map.put(id, obj);
	}
	
	/**
	 * A method to get an object from identity map
	 * @param long id
	 * @return E
	 */
	public E get(long id) {
		return map.get(id);
	}
}
