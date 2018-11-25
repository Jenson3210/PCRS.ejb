package colruyt.pcrsejb.facade;

import java.util.List;

public interface IFacade<T> {
	T save(T entityBo);
	T get(T entityBo);
	List<T> getAll();
	void delete(T entityBo);
}
