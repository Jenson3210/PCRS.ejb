package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;

@Named
@ViewScoped
public class RespSurveyDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade;
	
	
	private List<SurveyDefinitionBo> surveyDefinitionList;
	
	private List<SurveySectionTitleBo> surveySectionTitleList;
	
	private List<SurveySectionStrategyBo> surveySectionStrategyList;
	
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	
	
	@Inject
	private WebUser webuser;
	
	SurveyDefinitionBo surveyDefinitionBo;
	
	
	public RespSurveyDefinitionView() {
	}

	@PostConstruct
	public void setup() {
		UserBo userBo = webuser.getUser();
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		for(UserPrivilegeBo up : userBo.getPrivileges()) {
			System.out.println(up);
			System.out.println(up.getPrivilegeType());
			System.out.println(PrivilegeType.SURVEYDEFINITIONRESPONSIBLE);
			System.out.println(((SurveyUserPrivilegeBo) up).getSurveyDefinition());
			if (up.getPrivilegeType().equals(PrivilegeType.SURVEYDEFINITIONRESPONSIBLE)) {
				surveyDefinitionBo = ((SurveyUserPrivilegeBo) up).getSurveyDefinition();
				System.out.println(surveyDefinitionBo.getName());
			}
		}
		// get all definitions and titles
		surveyDefinitionList = surveyDefinitionFacade.getAll();
		surveySectionTitleList = surveySectionTitleFacade.getAll();
		surveySectionStrategyList = surveySectionStrategyFacade.getAll();
	}
	

	public void newSurveyDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		
	}
	
	
	public void addSurveyDefinition() {
		// TOD
		System.out.println("---------");
		System.out.println(addedSurveySectionDefinition);
		System.out.println(addedSurveySectionDefinition.getSurveySectionTitle().getTitle());
	}
	
	
	/*
	 *  Getters and Setters
	 */
	
	public List<SurveyDefinitionBo> getSurveyDefinitionList() {
		return surveyDefinitionList;
	}

	public void setSurveyDefinitionList(List<SurveyDefinitionBo> surveyDefinitionList) {
		this.surveyDefinitionList = surveyDefinitionList;
	}


	public List<SurveySectionTitleBo> getSurveySectionTitleList() {
		return surveySectionTitleList;
	}

	public void setSurveySectionTitleList(List<SurveySectionTitleBo> surveySectionTitleList) {
		this.surveySectionTitleList = surveySectionTitleList;
	}

	public SurveyDefinitionBo getSurveyDefinitionBo() {
		return surveyDefinitionBo;
	}

	public void setSurveyDefinitionBo(SurveyDefinitionBo surveyDefinitionBo) {
		this.surveyDefinitionBo = surveyDefinitionBo;
	}

	public SurveySectionDefinitionBo getAddedSurveySectionDefinition() {
		return addedSurveySectionDefinition;
	}

	public void setAddedSurveySectionDefinition(SurveySectionDefinitionBo addedSurveySectionDefinition) {
		this.addedSurveySectionDefinition = addedSurveySectionDefinition;
	}

	public List<SurveySectionStrategyBo> getSurveySectionStrategyList() {
		return surveySectionStrategyList;
	}

	public void setSurveySectionStrategyList(List<SurveySectionStrategyBo> surveySectionStrategyList) {
		this.surveySectionStrategyList = surveySectionStrategyList;
	}
}
