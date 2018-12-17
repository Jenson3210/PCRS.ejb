package colruyt.pcrsejb.entity.user.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.service.dl.IDbService;

public class TokenDlService implements IDbService<Token>{

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
