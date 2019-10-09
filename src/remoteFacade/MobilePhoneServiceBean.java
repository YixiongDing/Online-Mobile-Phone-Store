package remoteFacade;

import dataMapper.MobilePhoneMapper;
import domain.MobilePhone;
import domain.MobilePhoneAssembler;
import domain.MobilePhoneDTO;
/**
 * a class for remote invoke
 */
public class MobilePhoneServiceBean {

	public MobilePhoneDTO getMobilePhone(int id) {
		MobilePhone mobilePhone = new MobilePhone();
		mobilePhone.setMobilePhoneId(id);
		
		return new MobilePhoneAssembler().writeDTO(
				new MobilePhoneMapper().findMobilePhone(mobilePhone).get(0));
	}
	
	public String getCustomerString(int id) {
		 return getMobilePhone(id).toString();
	}
	
}