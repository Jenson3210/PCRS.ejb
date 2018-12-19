package colruyt.pcrsejb.service.dl.user.security;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.entity.user.security.Token;
import colruyt.pcrsejb.service.dl.IDbService;

@Stateless
public class TokenDlService implements ITokenDlService{

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	@Override
	public Token save(Token element) {
		return em.merge(element);
	}

	@Override
	public Token get(Token element) {
		return em.find(Token.class, element.getToken());
		
	}

	@Override
	public List<Token> getAll() {
		throw new IllegalAccessError();
	}

	@Override
	public void delete(Token element) {
		em.merge(element);
		em.remove(element);
		
	}
	
	

}
