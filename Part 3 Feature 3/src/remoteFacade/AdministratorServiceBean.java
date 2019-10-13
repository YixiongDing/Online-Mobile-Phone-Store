package remoteFacade;

import dataMapper.AdministratorMapper;
import domain.Administrator;
import domain.AdministratorAssembler;
import domain.AdministratorDTO;


public class AdministratorServiceBean {
	
	/**
	 * A method to write data transfer object
	 * @param int id
	 * @return AdministratorDTO
	 */
	public AdministratorDTO getAdministrator(int id) {
		Administrator admin = new Administrator();
		admin.setAdministratorId(id);
		return new AdministratorAssembler().writeDTO(
				new AdministratorMapper().findAdminById(admin).get(0));
	}
	
	/**
	 * A method to insert function don't need to apply for the lock
	 * @param int id
	 * @return String
	 */
	public String getAdministratorString(int id) {
		return getAdministrator(id).toString();
	}
}