package colruyt.pcrs.views;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AdminSurveySectionDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private boolean administratorCreated;
	
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


	
	
	
	
		
	
	

}
