package fr.lombok.test.services;

import java.util.List;



public interface GenericService<T> {

	List<T> getAll();
	T getById(long id);
	T saveOrUpdate(T tDto) throws Exception;
	void delete(long id);
	
}
