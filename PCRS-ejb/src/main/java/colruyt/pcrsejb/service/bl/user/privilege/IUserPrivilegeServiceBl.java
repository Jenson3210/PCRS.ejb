package colruyt.pcrsejb.service.bl.user.privilege;

import java.util.Optional;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Local
public interface IUserPrivilegeServiceBl extends IServiceBl<UserPrivilege> {

	User grantUserPrivilegeToUser(User user, UserPrivilege userPrivilege) throws ValidationException ;
	void revokeUserPrivilegeToUser(User user, UserPrivilege userPrivilege) throws ValidationException ;
	UserPrivilege setUserPrivilege(User user, String userPrivilege) throws MemberAlreadyHasATeamException,ValidationException;
	void revokeUserPrivilegeTypeToUser(User user, PrivilegeType privilegeType, SurveyDefinition surveyDefinition) throws ValidationException ;
}
