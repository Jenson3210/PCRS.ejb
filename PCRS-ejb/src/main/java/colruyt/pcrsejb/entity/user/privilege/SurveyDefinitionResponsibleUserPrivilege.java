package colruyt.pcrsejb.entity.user.privilege;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="SURVEYDEFINITIONRESPONSIBLE")
public class SurveyDefinitionResponsibleUserPrivilege extends SurveyUserPrivilege implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * CONSTRUCTORS
	 */
	/*
	 * GETTERS AND SETTERS
	 */
}
