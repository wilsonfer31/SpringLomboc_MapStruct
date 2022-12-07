package fr.lombok.test.services;

import java.util.List;

import fr.lombok.test.dto.PersonneDto;



public interface PersonneService {

	List<PersonneDto> getAll();
	List<PersonneDto> getAllByAlphaOrder();
	PersonneDto getById(long id);
	PersonneDto saveOrUpdate(PersonneDto pDto) throws Exception;
	void delete(long id);


	}