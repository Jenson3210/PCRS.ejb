package colruyt.pcrsejb.service.dl;

import java.sql.SQLException;
import java.util.List;

import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionTitleCantBeDeletedException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public interface IDbService<T> {

	T save(T element);

	T get(T element);

	List<T> getAll();

	void delete(T element) /* throws ValidationException*/ ;

}
