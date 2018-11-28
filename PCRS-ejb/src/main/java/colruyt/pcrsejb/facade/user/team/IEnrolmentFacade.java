package colruyt.pcrsejb.facade.user.team;

import javax.ejb.Remote;

import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.facade.IFacade;

@Remote
public interface IEnrolmentFacade extends IFacade<EnrolmentBo>{
	
}
