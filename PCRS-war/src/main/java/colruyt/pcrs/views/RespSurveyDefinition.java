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
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;

@Named
@ViewScoped
public class RespSurveyDefinition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@EJB
	private ISurveyDefinitionFacade surveyDefFacade;
	
	
	private List<SurveyDefinitionBo> surveyDefinitionList;
	
	private List<SurveySectionDefinitionBo> surveySectionDefinitionList;
	
	@Inject
	private WebUser webuser;
	
	SurveyDefinitionBo surveyDefinitionBo;
	
	
	public RespSurveyDefinition() {
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

	public List<SurveySectionDefinitionBo> getSurveySectionDefinitionList() {
		return surveySectionDefinitionList;
	}

	public void setSurveySectionDefinitionList(List<SurveySectionDefinitionBo> surveySectionDefinitionList) {
		this.surveySectionDefinitionList = surveySectionDefinitionList;
	}

	public SurveyDefinitionBo getSurveyDefinitionBo() {
		return surveyDefinitionBo;
	}

	public void setSurveyDefinitionBo(SurveyDefinitionBo surveyDefinitionBo) {
		this.surveyDefinitionBo = surveyDefinitionBo;
	}

	
}
