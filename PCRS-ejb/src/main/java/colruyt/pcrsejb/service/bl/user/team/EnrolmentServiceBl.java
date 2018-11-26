package colruyt.pcrsejb.service.bl.user.team;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.service.dl.user.team.IEnrolmentServiceDl;

@Stateless
public class EnrolmentServiceBl implements Serializable, IEnrolmentServiceBl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IEnrolmentServiceDl dlService;

	@Override
	public Enrolment save(Enrolment element) {
		return dlService.save(element);
	}

	@Override
	public Enrolment get(Enrolment element) {
		return dlService.get(element);
	}

	@Override
	public List<Enrolment> getAll() {
		return dlService.getAll();
	}

	@Override
	public void delete(Enrolment element) {
		dlService.delete(element);
	}
	
}
