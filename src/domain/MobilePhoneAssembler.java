package domain;

public class MobilePhoneAssembler {

	public MobilePhoneDTO writeDTO(MobilePhone mobilePhone) {
		MobilePhoneDTO result = new MobilePhoneDTO();
		result.setMobilePhoneId(mobilePhone.getMobilePhoneId());
		result.setBrand(mobilePhone.getBrand());
		result.setModelName(mobilePhone.getModelName());
		result.setStorageSize(mobilePhone.getStorageSize());
		result.setColor(mobilePhone.getColor());
		result.setPrice(mobilePhone.getPrice());
		result.setQty(mobilePhone.getQty());
		result.setDescription(mobilePhone.getDescription());
		
		return result;
	}
	
	

}
