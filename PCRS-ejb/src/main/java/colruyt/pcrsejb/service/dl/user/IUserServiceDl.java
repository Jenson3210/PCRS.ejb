package colruyt.pcrsejb.service.dl.user;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.service.dl.IDbService;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;

@Local
public interface IUserServiceDl extends IDbService<User> {

	User getElementByEmail(String email) throws NoExistingEmailException;
	List<User> getUsersByShortName(String shortName);
	User getUserByEnrolment(Enrolment enrolment) throws NoExistingMemberException;
}
