package colruyt.pcrsejb.service.bl;

import java.util.List;


public interface IServiceBl<T> {

	
//	T save(T element) throws ValidationException;
	T save(T element);

	T get(T element);

	List<T> getAll();

	void delete(T element);
	
}
