package colruyt.pcrsejb.service.dl;

import java.util.List;

public interface IDbService<T> {

	T save(T element);

	T get(T element);

	List<T> getAll();

	void delete(T element);

}
