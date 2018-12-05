package colruyt.pcrsejb.facade.user.privilege;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveyDefinitionConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.user.privilege.PrivilegeTypeTranslator;
import colruyt.pcrsejb.converter.user.privilege.UserPrivilegeConverter;
import colruyt.pcrsejb.service.bl.user.privilege.IUserPrivilegeServiceBl;

@Stateless
public class UserPrivilegeFacade implements Serializable, IUserPrivilegeFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	IUserPrivilegeServiceBl userPrivilegeServiceBl;
	UserPrivilegeConverter userPrivilegeConverter = new UserPrivilegeConverter();
	UserConverter userConverter = new UserConverter();
	PrivilegeTypeTranslator privilegeTypeTranslator = new PrivilegeTypeTranslator();
	SurveyDefinitionConverter surveyDefinitionConverter = new SurveyDefinitionConverter();

	@Override
	public UserPrivilegeBo save(UserPrivilegeBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrivilegeBo get(UserPrivilegeBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPrivilegeBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UserPrivilegeBo entityBo) {
		// TODO Auto-generated method stub
	}

	@Override
	public UserBo grantUserPrivilegeToUser(UserBo user, UserPrivilegeBo userPrivilege) {
		return userConverter.convertToBo(userPrivilegeServiceBl.grantUserPrivilegeToUser(userConverter.convertToEntity(user), userPrivilegeConverter.convertToEntity(userPrivilege)));
	}

	@Override
	public void revokeUserPrivilegeFromUser(UserBo user, UserPrivilegeBo userPrivilege) {
		userPrivilegeServiceBl.revokeUserPrivilegeToUser(userConverter.convertToEntity(user), userPrivilegeConverter.convertToEntity(userPrivilege));
	}

	@Override
	public void revokeUserPrivilegeTypeFromUser(UserBo user, PrivilegeTypeBo privilegeType, SurveyDefinitionBo surveyDefinition) {
		userPrivilegeServiceBl.revokeUserPrivilegeTypeToUser(userConverter.convertToEntity(user), privilegeTypeTranslator.convertToEntity(privilegeType), surveyDefinitionConverter.convertToEntity(surveyDefinition));
	}
	
	
	
}
