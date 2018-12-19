package colruyt.pcrsejb.facade.user.security;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.security.Token;

@Local
public interface ITokenFacade {
	
	public UserBo getUserByToken(String token);
	public Token issueToken(UserBo u,String token);
	
}
