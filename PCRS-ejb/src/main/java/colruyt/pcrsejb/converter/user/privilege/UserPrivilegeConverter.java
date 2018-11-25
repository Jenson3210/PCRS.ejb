package colruyt.pcrsejb.converter.user.privilege;

import colruyt.pcrsejb.bo.user.privilege.SurveyDefinitionResponsibleUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveyDefinitionConverter;
import colruyt.pcrsejb.converter.surveys.surveySet.SurveySetConverter;
import colruyt.pcrsejb.entity.user.privilege.SurveyDefinitionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;

public class UserPrivilegeConverter implements GenericConverter<UserPrivilege, UserPrivilegeBo> {

	private SurveySetConverter surveySetConverter = null;
	private SurveyDefinitionConverter surveyDefinitionConverter = null;
	private PrivilegeTypeTranslator privilegeTypeTranslator = new PrivilegeTypeTranslator();
	
	@Override
	public UserPrivilege convertToEntity(UserPrivilegeBo bo) {
		UserPrivilege entity = null;
		if (bo != null) {
			switch (bo.getPrivilegeType()) {
			case TEAMMEMBER:
				entity = new TeamMemberUserPrivilege();
				ConverterUtils.setIfNotNull(((TeamMemberUserPrivilegeBo) bo)::getStartDateCurrentSurveyDefinition, ((TeamMemberUserPrivilege) entity)::setStartDateCurrentSurveyDefinition);
				surveySetConverter = new SurveySetConverter();
				surveyDefinitionConverter = new SurveyDefinitionConverter();
				((TeamMemberUserPrivilege) entity).setSurveyDefinition(surveyDefinitionConverter.convertToEntity(((TeamMemberUserPrivilegeBo) bo).getSurveyDefinition()));
				((TeamMemberUserPrivilege) entity).setSurveySetTreeSet(surveySetConverter.convertToEntities(((TeamMemberUserPrivilegeBo) bo).getSurveySetTreeSet()));
				break;
			case SURVEYDEFINITIONRESPONSIBLE:
				entity = new SurveyDefinitionResponsibleUserPrivilege();
				surveyDefinitionConverter = new SurveyDefinitionConverter();
				((SurveyDefinitionResponsibleUserPrivilege) entity).setSurveyDefinition(surveyDefinitionConverter.convertToEntity(((SurveyDefinitionResponsibleUserPrivilegeBo) bo).getSurveyDefinition()));
				break;
			default:
				entity = new UserPrivilege();
			}
			entity.setPrivilegeType(privilegeTypeTranslator.convertToEntity(bo.getPrivilegeType()));
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::isActive, entity::setActive);
		}
		return entity;
	}

	@Override
	public UserPrivilegeBo convertToBo(UserPrivilege entity) {
		UserPrivilegeBo bo = null;
		if (entity != null) {
			switch (entity.getPrivilegeType()) {
			case TEAMMEMBER:
				bo = new TeamMemberUserPrivilegeBo();
				ConverterUtils.setIfNotNull(((TeamMemberUserPrivilege) entity)::getStartDateCurrentSurveyDefinition, ((TeamMemberUserPrivilegeBo) bo)::setStartDateCurrentSurveyDefinition);
				surveySetConverter = new SurveySetConverter();
				surveyDefinitionConverter = new SurveyDefinitionConverter();
				((TeamMemberUserPrivilegeBo) bo).setSurveyDefinition(surveyDefinitionConverter.convertToBo(((TeamMemberUserPrivilege) entity).getSurveyDefinition()));
				((TeamMemberUserPrivilegeBo) bo).setSurveySetTreeSet(surveySetConverter.convertToBos(((TeamMemberUserPrivilege) entity).getSurveySetTreeSet()));
				break;
			case SURVEYDEFINITIONRESPONSIBLE:
				bo = new SurveyDefinitionResponsibleUserPrivilegeBo();
				surveyDefinitionConverter = new SurveyDefinitionConverter();
				((SurveyDefinitionResponsibleUserPrivilegeBo) bo).setSurveyDefinition(surveyDefinitionConverter.convertToBo(((SurveyDefinitionResponsibleUserPrivilege) entity).getSurveyDefinition()));
				break;
			default:
				bo = new UserPrivilegeBo();
				break;
			}
			bo.setPrivilegeType(privilegeTypeTranslator.convertToBo(entity.getPrivilegeType()));
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::isActive, bo::setActive);
		}
		return bo;
	}
	
}
