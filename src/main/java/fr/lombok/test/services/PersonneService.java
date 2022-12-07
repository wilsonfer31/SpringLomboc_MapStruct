package fr.lombok.test.services;

import java.util.List;

import fr.lombok.test.dto.PersonneDto;



public interface PersonneService extends GenericService<PersonneDto>{

	List<PersonneDto> getAllByAlphaOrder();


	}