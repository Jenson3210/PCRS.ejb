package colruyt.pcrsejb.service.bl;

import java.util.List;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;


public interface IServiceBl<T> {

	
	T save(T element) throws ValidationException;

	T get(T element) throws ValidationException;
	
	List<T> getAll();

	void delete(T element) throws ValidationException;
	
}
