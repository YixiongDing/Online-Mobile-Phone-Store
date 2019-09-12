package service;

import java.util.ArrayList;
import java.util.List;
import domain.MobilePhone;

import dataMapper.*;

public class MobilePhoneService {
	
	private MobilePhoneMapper mapper; 
	
	public MobilePhoneService() {
		mapper = new MobilePhoneMapper();
	}
	
	public boolean insertMobilePhone(MobilePhone mobile) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(mobile);
		return UnitOfWork.getCurrent().commit();
	}
	
	public boolean updateMobilePhone(MobilePhone mobile) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(mobile);
	    System.out.println("2"+mobile.getId()+mobile.getDescription());

		return UnitOfWork.getCurrent().commit();
	}
	
	public boolean deleteMobilePhone(MobilePhone mobile) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(mobile);
		return UnitOfWork.getCurrent().commit();
	}
	
	public List<MobilePhone> getMobilePhone(MobilePhone mobile){
		dataMapper.IdentityMap<MobilePhone> identityMap = dataMapper.IdentityMap.getInstance(mobile);
		MobilePhone mobile_Map = identityMap.get(mobile.getMobileId());
		if (mobile_Map != null) {
			List<MobilePhone> result = new ArrayList<MobilePhone>();
			result.add(mobile_Map);
			return result;
		}
		return mapper.findMobilePhone(mobile);
	}
	
	public List<MobilePhone> getAllMobilePhone() {
		return mapper.findAllMobilePhone();
	}
	
	public List<MobilePhone> getAvailableMobilePhone() {
		return mapper.findAvailableMobilePhone();
	}
	
	
}

