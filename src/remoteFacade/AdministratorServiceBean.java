package remoteFacade;

import dataMapper.AdministratorMapper;
import domain.Administrator;
import domain.AdministratorAssembler;
import domain.AdministratorDTO;


public class AdministratorServiceBean {
	public AdministratorDTO getAdministrator(int id) {
		Administrator admin = new Administrator();
		admin.setAdministratorId(id);
		
		return new AdministratorAssembler().writeDTO(
				new AdministratorMapper().findAdminById(admin).get(0));
	}
	
	public String getCustomerString(int id) {
		 return getAdministrator(id).toString();
	}
}