package domain;

public class AdministratorAssembler {


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
