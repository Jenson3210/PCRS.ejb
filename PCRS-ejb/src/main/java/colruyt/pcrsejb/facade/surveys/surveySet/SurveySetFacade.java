package colruyt.pcrsejb.facade.surveys.surveySet;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.surveys.surveySet.SurveySetBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionImplConverter;
import colruyt.pcrsejb.converter.surveys.surveySet.SurveySetConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.service.bl.surveys.survey.ISurveySectionDefinitionImplBl;
import colruyt.pcrsejb.service.bl.surveys.surveySet.ISurveySetServiceBl;

@Stateless
public class SurveySetFacade implements Serializable,ISurveySetFacade{

	private static final long serialVersionUID = 1L;

	private SurveySetConverter surveySetConverter = new SurveySetConverter();
	@EJB
	private ISurveySetServiceBl surveySetServiceBl;
	@EJB
	private ISurveySectionDefinitionImplBl surveySectionImplBl;
	private SurveySectionDefinitionImplConverter surveySectionDefinitionImplConverter = new SurveySectionDefinitionImplConverter();
	private UserConverter userConverter = new UserConverter();
	
	@Override
	public SurveySetBo save(SurveySetBo entityBo) {
		return surveySetConverter.convertToBo(surveySetServiceBl.save(surveySetConverter.convertToEntity(entityBo)));
	}

	@Override
	public SurveySetBo get(SurveySetBo entityBo) {
		return surveySetConverter.convertToBo(surveySetServiceBl.get(surveySetConverter.convertToEntity(entityBo)));
	}

	@Override
	public List<SurveySetBo> getAll() {
		return surveySetConverter.convertToBos(surveySetServiceBl.getAll());
	}

	@Override
	public void delete(SurveySetBo entityBo) {
		surveySetServiceBl.delete(surveySetConverter.convertToEntity(entityBo));
	}

	@Override
	public Integer getPercentageCompleteForMemberSurvey(UserBo user) {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public Integer getPercentageCompleteForManagerSurvey(UserBo user) {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public Integer getPercentageCompleteForConsensusSurvey(UserBo user) {
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public SurveySetBo generateSurveySetFor(UserBo user, List<SurveySectionDefinitionImplBo> sections) {
		return surveySetConverter.convertToBo(surveySetServiceBl.createSurveySetForUser(userConverter.convertToEntity(user), surveySectionDefinitionImplConverter.convertToEntities(sections)));
	}

	@Override
	public List<SurveySectionDefinitionImplBo> getPossibleSections(UserBo user) {
		return surveySectionDefinitionImplConverter.convertToBos(surveySectionImplBl.getAllByUser(userConverter.convertToEntity(user)));
	}

}
