package fr.lombok.test.entities;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;


import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Setter
@Getter
@Entity
public class Personne implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;              
	@Column(nullable = false, columnDefinition="DATE")
	private LocalDate DateDeNaissance; 
    @Version 
	int version;


    
    

}
