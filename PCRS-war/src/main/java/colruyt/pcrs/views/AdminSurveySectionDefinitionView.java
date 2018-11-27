package colruyt.pcrs.views;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.List;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;

@Named
@SessionScoped
public class AdminSurveySectionDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private boolean administratorCreated;

	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	private List<SurveySectionDefinitionBo> surveySectionDefinitions;

	@EJB
	private ISurveySectionDefinitionFacade surveySectionDefinitionFacade;

	@PostConstruct
	private void fillSurveySectionDefinitions() {
		surveySectionDefinitions = surveySectionDefinitionFacade.getAll();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isAdministratorCreated() {
		return administratorCreated;
	}

	public void setAdministratorCreated(boolean administratorCreated) {
		this.administratorCreated = administratorCreated;
	}
	
	public SurveySectionDefinitionBo getAddedSurveySectionDefinition() {
		return addedSurveySectionDefinition;
	}

	public void setAddedSurveySectionDefinition(SurveySectionDefinitionBo addedSurveySectionDefinition) {
		this.addedSurveySectionDefinition = addedSurveySectionDefinition;
	}

	public List<SurveySectionDefinitionBo> getSurveySectionDefinitions() {
		return surveySectionDefinitions;
	}

	public void setSurveySectionDefinitions(List<SurveySectionDefinitionBo> surveySectionDefinitions) {
		this.surveySectionDefinitions = surveySectionDefinitions;
	}

	public void addSurveySectionDefinition() {
		surveySectionDefinitions.add(surveySectionDefinitionFacade.save(addedSurveySectionDefinition));
	}
	
	public void newSurveySectionDefinition() {
        addedSurveySectionDefinition = new SurveySectionDefinitionBo();
    }
	
/*	public void editSurveySectionDefinition() {
		SurveySectionDefinitionBo d = null;
		for (SurveySectionDefinitionBo definition : surveySectionDefinitions) {
			if (definition.getId() == addedSurveySectionDefinition.getId()) {
				definition.setDefinition(addedSurveySectionDefinition.getDefinition());
				d = definition;
			}
		}
		surveySectionDefinitionFacade.save(d); 
	}
	*/
	public void deleteSurveySectionDefinition()
	{
		SurveySectionDefinitionBo d = null;
		for (SurveySectionDefinitionBo definition : surveySectionDefinitions) {
			if (definition.getId() == addedSurveySectionDefinition.getId()) {
				d = definition;
			}
		}
		surveySectionDefinitions.remove(d);
		surveySectionDefinitionFacade.delete(d);
	}	
	
}
