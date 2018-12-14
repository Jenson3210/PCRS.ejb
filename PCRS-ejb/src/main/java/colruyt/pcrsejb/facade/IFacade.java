package colruyt.pcrsejb.facade;

import java.util.List;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public interface IFacade<T> {
	T save(T entityBo) throws ValidationException;
	T get(T entityBo) throws ValidationException;
	List<T> getAll() throws ValidationException;
	void delete(T entityBo) throws ValidationException;
}
