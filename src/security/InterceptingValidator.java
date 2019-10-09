package security;

public class InterceptingValidator {


	public static boolean validateURI(String uriString) {
		return checkSQLInjection(uriString);
		
	}
	

	private static boolean checkSQLInjection(String uri) {
		String query = uri.toLowerCase();
		//detect SQL injection
		if (query.matches(
				"/\\w*((\\%27)|(\\'))((\\%6F)|o|(\\%4F))((\\%72)|r|(\\%52))/ix")
				|| query.matches("/((\\%27)|(\\'))union/ix")){
			System.out.println("error");
			return false;
		}
		return true;
	}
}