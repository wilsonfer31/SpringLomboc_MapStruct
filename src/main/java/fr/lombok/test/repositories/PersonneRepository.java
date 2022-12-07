package fr.lombok.test.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fr.lombok.test.entities.Personne;


@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

	List<Personne> findAllByOrderByNomAsc();

}