package colruyt.pcrsejb.facade.user.security;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.entity.user.security.Token;
import colruyt.pcrsejb.service.dl.user.security.ITokenDlService;
import colruyt.pcrsejb.service.dl.user.security.TokenDlService;


@Stateless
public class TokenFacade implements ITokenFacade{

	private UserConverter userconvert = new UserConverter();
	
	@EJB
	private ITokenDlService dl = new TokenDlService();
	
	
    private KeyGenerator keyGenerator;
	
	
	public Token issueToken(UserBo u,String token) {
		
		
		Token to =  new Token(token, LocalDate.now(), userconvert.convertToEntity(u));
		
		this.dl.save(to);
		
		return to;
		
		
	}

	
	   
	
	
	public UserBo getUserByToken(String token) {
		Token to = new Token();
		to.setToken(token);
		return this.userconvert.convertToBo(this.dl.get(to).getUser());
	}
	
	
}
