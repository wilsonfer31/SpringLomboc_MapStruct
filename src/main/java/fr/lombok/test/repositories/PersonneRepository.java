package fr.lombok.test.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import fr.lombok.test.entities.Personne;


public interface PersonneRepository extends JpaRepository<Personne, Long> {

	List<Personne> findAllByOrderByNomAsc();

}