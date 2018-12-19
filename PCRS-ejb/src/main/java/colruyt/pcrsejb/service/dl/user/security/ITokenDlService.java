package colruyt.pcrsejb.service.dl.user.security;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.security.Token;
import colruyt.pcrsejb.service.dl.IDbService;

@Local
public interface ITokenDlService extends IDbService<Token>{

}
