package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;

@Named
@ViewScoped
public class ManagerTeamViewDialog implements Serializable {
			
	
	private UserBo manager;
	private UserBo teamMember;
		
	private List<SurveySectionDefinition> chosenList = new ArrayList<>();
	private List<SurveySectionDefinition> availableList = new ArrayList<>();
	
	

	public UserBo getManager() {
		return manager;
	}

	public void setManager(UserBo manager) {
		this.manager = manager;
	}

	public UserBo getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(UserBo teamMember) {
		this.teamMember = teamMember;
	}

	


	public List<SurveySectionDefinition> getChosenList() {
		return chosenList;
	}

	public void setChosenList(List<SurveySectionDefinition> chosenList) {
		this.chosenList = chosenList;
	}

	public List<SurveySectionDefinition> getAvailableList() {
		return availableList;
	}

	public void setAvailableList(List<SurveySectionDefinition> availableList) {
		this.availableList = availableList;
	}

	public void init(UserBo team) {
	
		this.loadCompetences();
		
	}
	
	
	private void loadCompetences() {
		throw new IllegalAccessError("Not yet Implemented");
	}

	
	
			
}
