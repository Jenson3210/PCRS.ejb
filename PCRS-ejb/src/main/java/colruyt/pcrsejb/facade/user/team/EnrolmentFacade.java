package colruyt.pcrsejb.facade.user.team;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.converter.user.team.EnrolmentConverter;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.facade.user.UserFacade;
import colruyt.pcrsejb.facade.user.privilege.UserPrivilegeFacade;
import colruyt.pcrsejb.service.bl.user.team.IEnrolmentServiceBl;

@Stateless
public class EnrolmentFacade implements Serializable, IEnrolmentFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private UserFacade userFacade;
	@EJB
	private TeamFacade teamFacade;
	@EJB
	private UserPrivilegeFacade userPrivilegeFacade;
	@EJB
	private IEnrolmentServiceBl enrolmentServiceBl;
	private EnrolmentConverter enrolmentConverter = new EnrolmentConverter();
	

	@Override
	public EnrolmentBo save(EnrolmentBo enrolment) {
		return enrolmentConverter.convertToBo(enrolmentServiceBl.save(enrolmentConverter.convertToEntity(enrolment)));
	}

	@Override
	public EnrolmentBo get(EnrolmentBo enrolment) {
		return enrolmentConverter.convertToBo(enrolmentServiceBl.get(enrolmentConverter.convertToEntity(enrolment)));
	}

	@Override
	public List<EnrolmentBo> getAll() {
		return enrolmentConverter.convertToBos(enrolmentServiceBl.getAll());
	}

	@Override
	public void delete(EnrolmentBo enrolment) {
		enrolmentServiceBl.delete(enrolmentConverter.convertToEntity(enrolment));
	}

	@Override
	public void saveNewMemberInTeam(TeamBo team, EnrolmentBo enrolment) {
    	UserBo user = userFacade.save(enrolment.getUser());
    	
    	enrolment.setUserPrivilege(userPrivilegeFacade.getActivePrivilege(user));
    	team.getEnrolments().add(enrolment);
    	
    	teamFacade.save(team);
	}
	
}
