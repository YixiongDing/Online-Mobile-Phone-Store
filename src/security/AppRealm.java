package security;

import domain.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class AppRealm extends JdbcRealm {
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
		
		
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		final String username = userPassToken.getUsername();
		
		final User user = User.getUser(username);
		if(user==null) {
			System.out.println("No account for user with username"+ username);
			return null;
			
		}
		
		
		return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());
		
		

	}
	
	
	
	
	@Override
	protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roles = new HashSet<>();
		if (principals.isEmpty()) {
			System.out.println("Given principals to authorize are empty.");
			return null;
			
		}
		
		String username =(String) principals.getPrimaryPrincipal();
		final User user = User.getUser(username);
		
		if(user == null) {
			
			System.out.println("No account found for user with username" + username);
			return null;
			
			
		}
		
		if (user instanceof Administrator) {
			
			roles.add(AppSession.ADMIN_ROLE);
			
		}else if (user instanceof Customer) {
			
			roles.add(AppSession.CUSTOMER_ROLE);
		}
		
		
		return new SimpleAuthorizationInfo(roles);
		
		
		
	}
}
