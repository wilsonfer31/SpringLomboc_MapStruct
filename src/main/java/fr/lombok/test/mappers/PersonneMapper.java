package fr.lombok.test.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.lombok.test.dto.PersonneDto;
import fr.lombok.test.entities.Personne;


@Mapper(componentModel = "spring")
public interface PersonneMapper {

	@Mapping(target = "ageActuelle", ignore = true)
	PersonneDto toPersonneDto(Personne personne);
	
	
	List<PersonneDto> toListPersonneDto(List <Personne> personne);
	
	Personne toPersonne(PersonneDto personneDto);
	
	List<Personne> toListPersonne(List <PersonneDto> personneDto);
}
