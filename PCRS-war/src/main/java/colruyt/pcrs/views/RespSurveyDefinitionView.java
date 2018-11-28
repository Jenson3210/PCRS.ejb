package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;

@Named
@ViewScoped
public class RespSurveyDefinitionView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	
	
	private List<SurveyDefinitionBo> surveyDefinitionList;
	
	private List<SurveySectionTitleBo> surveySectionTitleList;
	
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	
	
	@Inject
	private WebUser webuser;
	
	SurveyDefinitionBo surveyDefinitionBo;
	
	
	public RespSurveyDefinitionView() {
	}

	@PostConstruct
	private void setup() {
		UserBo userBo = webuser.getUser();
		System.out.println(userBo);
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
		
		surveyDefinitionList = surveyDefinitionFacade.getAll();
		surveySectionTitleList = surveySectionTitleFacade.getAll();
		surveyDefinitionList.stream().forEach(x->System.out.println(x));
		surveySectionTitleList.stream().forEach(x->System.out.println(x));
	}
	

	public void newSurveyDefinition() {
		// TODO
	}
	
	
	public void addSurveyDefinition() {
		// TODO
		
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
	
}
