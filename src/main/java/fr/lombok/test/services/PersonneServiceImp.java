package fr.lombok.test.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lombok.test.dto.PersonneDto;
import fr.lombok.test.entities.Personne;
import fr.lombok.test.repositories.PersonneRepository;
import fr.lombok.test.tools.DtoTools;


@Service
public class PersonneServiceImp implements PersonneService {
	
	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public List<PersonneDto> getAll() {
		List<Personne> personnes = personneRepository.findAll();
		List<PersonneDto> result = new ArrayList<PersonneDto>();
		for (Personne p : personnes) {
			result.add(DtoTools.convert(p, PersonneDto.class));
		}
		return result;
	}

	@Override
	public PersonneDto getById(long id) {
		Optional<Personne> v = personneRepository.findById(id);
		if (v.isPresent())
			return DtoTools.convert(v.get(), PersonneDto.class);

		return null;
	}

	@Override
	public PersonneDto saveOrUpdate(PersonneDto pDto) throws Exception {

		Personne p = DtoTools.convert(pDto, Personne.class);
		
	
	
		
		if(pDto.getAgeActuelle() < 150){
		
		try {
			p = personneRepository.saveAndFlush(p);

		} catch (Exception e) {
			throw new Exception("Erreur lors de la sauvegarde: " + e.getMessage());
		
		}
		
		}else {
			throw new Exception("La personne que vous voulez enregister a plus de 150 ans");
		}

		return DtoTools.convert(p, PersonneDto.class);
	}

	@Override
	public void delete(long id) {
		personneRepository.deleteById(id);
		
	}

	@Override
	public List<PersonneDto> getAllByAlphaOrder() {
		List<Personne> personnes = personneRepository.findAllByOrderByNomAsc();
		List<PersonneDto> result = new ArrayList<PersonneDto>();
		for (Personne p : personnes) {
			result.add(DtoTools.convert(p, PersonneDto.class));
		}
		return result;
	
		
	}

}
