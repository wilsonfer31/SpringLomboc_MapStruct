package fr.lombok.test.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PersonneDto implements Serializable{
	private long id;
	private String nom;
	private String prenom;
	private LocalDate DateDeNaissance; 
	int version;
	private int AgeActuelle;


	public int getAgeActuelle() {
		LocalDate DateMaintenant = LocalDate.now();
		AgeActuelle = Period.between(this.getDateDeNaissance(), DateMaintenant).getYears();
		return AgeActuelle;
	}


	public PersonneDto(long id, String nom, String prenom, LocalDate dateDeNaissance, int ageActuelle) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		AgeActuelle = ageActuelle;
	}

	
	
	

	
	

}
