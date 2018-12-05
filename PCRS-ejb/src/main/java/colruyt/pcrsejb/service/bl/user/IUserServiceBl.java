package colruyt.pcrsejb.service.bl.user;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;

@Local
public interface IUserServiceBl extends IServiceBl<User>   { 
	public Boolean hasPrivilege(User user, PrivilegeType privilegeType, Boolean active);  
	public User getUserByEmail(String email) throws NoExistingEmailException;  
	public List<User> getUsersByShortName(String shortName);
	public User getUserByEnrolment(Enrolment enrolment) throws NoExistingMemberException;
}
