package colruyt.pcrsejb.facade;

import java.util.List;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public interface IFacade<T> {
	T save(T entityBo);
	T get(T entityBo);
	List<T> getAll();
	void delete(T entityBo) throws ValidationException;
}
