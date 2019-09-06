package database;

import java.util.*;

public class Registry {
	private static Map<Integer,MobileGateway> mobilesgateway = new HashMap<Integer,MobileGateway>();
	public static MobileGateway getMobile(int id) {	
		return mobilesgateway.get(id);
		
	}

	public static void addMobile(MobileGateway mobileGateway) {
		mobilesgateway.put(mobileGateway.getId(), mobileGateway);
		
	}

}
