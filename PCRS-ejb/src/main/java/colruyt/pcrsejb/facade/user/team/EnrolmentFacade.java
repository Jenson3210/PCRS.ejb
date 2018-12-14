package colruyt.pcrsejb.facade.user.team;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.converter.user.team.EnrolmentConverter;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.privilege.IUserPrivilegeFacade;
import colruyt.pcrsejb.service.bl.user.team.IEnrolmentServiceBl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class EnrolmentFacade implements Serializable, IEnrolmentFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUserFacade userFacade;
	@EJB
	private ITeamFacade teamFacade;
	@EJB
	private IUserPrivilegeFacade userPrivilegeFacade;
	@EJB
	private IEnrolmentServiceBl enrolmentServiceBl;
	private EnrolmentConverter enrolmentConverter = new EnrolmentConverter();
	

	@Override
	public EnrolmentBo save(EnrolmentBo enrolment) throws ValidationException {
		return enrolmentConverter.convertToBo(enrolmentServiceBl.save(enrolmentConverter.convertToEntity(enrolment)));
	}

	@Override
	public EnrolmentBo get(EnrolmentBo enrolment) throws ValidationException {
		return enrolmentConverter.convertToBo(enrolmentServiceBl.get(enrolmentConverter.convertToEntity(enrolment)));
	}

	@Override
	public List<EnrolmentBo> getAll() {
		return enrolmentConverter.convertToBos(enrolmentServiceBl.getAll());
	}

	@Override
	public void delete(EnrolmentBo enrolment) throws ValidationException {
		enrolmentServiceBl.delete(enrolmentConverter.convertToEntity(enrolment));
	}
	
}
