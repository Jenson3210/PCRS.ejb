package colruyt.pcrsejb.entity.user.security;

import java.security.SecureRandom;
import java.time.LocalDate;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.user.UserConverter;

public class TokenFacade {

	private UserConverter userconvert = new UserConverter();
	private SecureRandom random = new SecureRandom();
	private TokenDlService dl = new TokenDlService();
	
	
	public Token issueToken(UserBo u) {
		
		return new Token(this.generateToken(), LocalDate.now(), userconvert.convertToEntity(u));
	}
	
	private String generateToken() {
		
		
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = bytes.toString();
		return token;
	}
	
	public Token getTokenForUser(UserBo bo) {
		
	}
	
	
}
