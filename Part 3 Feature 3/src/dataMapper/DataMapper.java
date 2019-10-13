package dataMapper;

import domain.DomainObject;

public abstract class DataMapper {
	/**
	 * An abstract method to perform insert action to database
	 * @param object
	 * @return boolean result
	 */
	public abstract boolean insert(DomainObject object);

	/**
	 * An abstract method to perform delete action by domainObject's id to database
	 * @param object
	 * @return boolean result
	 * @throws Exception
	 */
	public abstract boolean delete(DomainObject object) throws Exception;

	/**
	 * An abstract method to perform update action by domainObject's id to database
	 * @param object
	 * @return boolean result
	 * @throws Exception
	 */
	public abstract boolean update(DomainObject object) throws Exception;

	/**
	 * An static method to get the corresponding mapper of the domain model
	 * @param DomainObject obj
	 * @return DataMapper mapper
	 * @throws Exception
	 */
	public static DataMapper getMapper(DomainObject obj) throws Exception {
		DataMapper mapper = null;
		try {
			mapper = (DataMapper) Class.forName("dataMapper."+obj.getClass().getSimpleName()+"Mapper")
					.getDeclaredConstructor().newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mapper;
	}
}