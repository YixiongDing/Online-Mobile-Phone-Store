package service;

import java.util.ArrayList;
import java.util.List;

import DataMapper.MobilePhoneMapper;
import DataMapper.UnitOfWork;
import domain.MobilePhone;

import DataMapper.*;

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
		return UnitOfWork.getCurrent().commit();
	}
	
	public boolean deleteMobilePhone(MobilePhone mobile) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(mobile);
		return UnitOfWork.getCurrent().commit();
	}
	
	public List<MobilePhone> getMobilePhone(MobilePhone mobile){
		IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(mobile);
		System.out.println("MobilePhoneService"+mobile.getBrand());
		MobilePhone mobile_Map = identityMap.get(mobile.getMobilePhoneId());
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

