package fr.lombok.test.services;




import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import fr.lombok.test.dto.PersonneDto;
import fr.lombok.test.entities.Personne;
import fr.lombok.test.mappers.PersonneMapper;
import fr.lombok.test.repositories.PersonneRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class PersonneServiceImp implements PersonneService {
	

	private final PersonneRepository personneRepository;
	
	private final PersonneMapper personneMaper;


	@Override
	public List<PersonneDto> getAll() {
		List<Personne> personnes = personneRepository.findAll();		
		return personneMaper.toListPersonneDto(personnes);
	}

	@Override
	public PersonneDto getById(long id) {
		Optional<Personne> v = personneRepository.findById(id);
		return v.isPresent() ?  personneMaper.toPersonneDto(v.get()) : null;

	}

	@Override
	public PersonneDto saveOrUpdate(PersonneDto pDto) throws Exception {

		Personne p = personneMaper.toPersonne(pDto);
		
	
	
		
		if(pDto.getAgeActuelle() < 150){
		
		try {
			p = personneRepository.saveAndFlush(p);

		} catch (Exception e) {
			throw new Exception("Erreur lors de la sauvegarde: " + e.getMessage());
		
		}
		
		}else {
			throw new Exception("La personne que vous voulez enregister a plus de 150 ans");
		}

		return personneMaper.toPersonneDto(p);
	}

	@Override
	public void delete(long id) {
		personneRepository.deleteById(id);
		
	}

	@Override
	public List<PersonneDto> getAllByAlphaOrder() {
		List<Personne> personnes = personneRepository.findAllByOrderByNomAsc();
		return personneMaper.toListPersonneDto(personnes);
	
		
	}

}
