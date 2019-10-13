package domain;

public class AdministratorAssembler {

  /**
	* A method assemble data transfer object for Administrator
	* @param Administrator admin
	* @return AdministratorDTO result
	*/
	public AdministratorDTO writeDTO(Administrator admin) {
		AdministratorDTO result = new AdministratorDTO();
		result.setAdministratorId(admin.getAdministratorId());
		result.setAdministratorEmail(admin.getAdministratorEmail());
		result.setAdministratorName(admin.getAdministratorName());
		result.setAdministratorAddress(admin.getAdministratorAddress());
		result.setAdministratorUserType(admin.getAdministratorUserType());
		result.setAdministratorPassword(admin.getAdministratorPassword());
		return result;
	}
}
