package colruyt.pcrsejb.facade.user.privilege;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.IFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Local
public interface IUserPrivilegeFacade extends IFacade<UserPrivilegeBo>{
	public UserBo grantUserPrivilegeToUser(UserBo user, UserPrivilegeBo userPrivilege) throws ValidationException;
	public void revokeUserPrivilegeFromUser(UserBo user, UserPrivilegeBo userPrivilege) throws ValidationException;
	public void revokeUserPrivilegeTypeFromUser(UserBo manipulatedUserBo, PrivilegeTypeBo surveydefinitionresponsible, SurveyDefinitionBo manipulatedSurveyDefinitionBo) throws ValidationException;
}
