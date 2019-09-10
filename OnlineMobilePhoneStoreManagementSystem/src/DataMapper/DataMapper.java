package dataMapper;

import domain.DomainObject;

public abstract class DataMapper {
	/**
	 * an abstract function to perform insert action to database
	 * @param object
	 * @return
	 */
	public abstract boolean insert(DomainObject object);

	/**
	 * an abstract function to perform delete action by domainObject's id to database.
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public abstract boolean delete(DomainObject object) throws Exception;

	/**
	 * an abstract function to perform update action by domainObject's id to database.
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public abstract boolean update(DomainObject object) throws Exception;

	public static DataMapper getMapper(DomainObject obj) throws Exception {
		DataMapper mapper = null;
		try {
			mapper = (DataMapper) Class.forName("dataMapper."+obj.getClass().getSimpleName()+"Mapper").getDeclaredConstructor().newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mapper;
	}
}