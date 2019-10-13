package security;

public class InterceptingValidator {


	public static boolean validateURI(String uriString) {
		return checkSQLInjection(uriString);
		
	}
	
	//detect SQL injection
	private static boolean checkSQLInjection(String uri) {
		String query = uri.toLowerCase();
		if (query.matches("/[\\t\\r\\n]|(--[^\\r\\n]*)|(\\/\\*[\\w\\W]*?(?=\\*)\\*\\/)/gi")){
			System.out.println("Error");
			return false;
		}
		return true;
	}
}