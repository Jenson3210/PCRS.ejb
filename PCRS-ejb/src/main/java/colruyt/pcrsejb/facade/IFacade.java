package colruyt.pcrsejb.facade;

import java.util.List;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;

public interface IFacade<T> {
	T save(T entityBo) throws ValidationException;
	T get(T entityBo);
	List<T> getAll();
	void delete(T entityBo);
}
