package colruyt.pcrsejb.facade.user.privilege;

import java.util.Optional;

import javax.ejb.Remote;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.IFacade;

@Remote
public interface IUserPrivilegeFacade extends IFacade<UserPrivilegeBo>{
	public UserBo grantUserPrivilegeToUser(UserBo user, UserPrivilegeBo userPrivilege);
	public void revokeUserPrivilegeFromUser(UserBo user, UserPrivilegeBo userPrivilege);
	public void revokeUserPrivilegeTypeFromUser(UserBo manipulatedUserBo, PrivilegeTypeBo surveydefinitionresponsible, SurveyDefinitionBo manipulatedSurveyDefinitionBo);
}
