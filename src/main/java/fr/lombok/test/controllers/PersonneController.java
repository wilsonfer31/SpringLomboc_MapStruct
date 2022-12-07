package fr.lombok.test.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lombok.test.dto.PersonneDto;
import fr.lombok.test.services.PersonneService;



// utiliser /Api/personne dans postMan
@RestController
@RequestMapping("/api/personne")
public class PersonneController {

	@Autowired
	private PersonneService personneService;
	
	@GetMapping(value="/getbyOrder", produces = "application/json")
	public List<PersonneDto> getAllbyAlphaOrder(){
		return personneService.getAllByAlphaOrder();
	}

	@GetMapping(value="/{id}",  produces = "application/json")
	public  ResponseEntity<PersonneDto> findById(@PathVariable("id") long id){
		 	return ResponseEntity
				.status(HttpStatus.OK)
				.body(	personneService.getById(id));
			
	}
	
	@PostMapping(consumes="application/json", produces = "application/json")
	public ResponseEntity<PersonneDto> save(@RequestBody PersonneDto pDto) throws Exception{
		PersonneDto result = personneService.saveOrUpdate(pDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(result);
	}
		
	
		@PutMapping(consumes="application/json", produces = "application/json")
		public PersonneDto update(@RequestBody PersonneDto pDto) throws Exception{
			return personneService.saveOrUpdate(pDto);
		}
		
		
		
		//suppression
		@DeleteMapping(value="/{id}")
		public ResponseEntity<Long> delete(@PathVariable(name ="id")long id){
			personneService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(id);
		}
		
		@GetMapping(produces = "application/json")
		public 	ResponseEntity<List<PersonneDto>> getAll(){
			return ResponseEntity.status(HttpStatus.OK).body( personneService.getAll());
		}
		
	

}