package fr.lombok.test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import fr.lombok.test.controllers.PersonneController;
import fr.lombok.test.dto.PersonneDto;
import fr.lombok.test.services.PersonneService;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonneControllerTest {

	@Autowired
	private PersonneController personneController;

	@Autowired // objet pour lancer des requêtes MVC
	private MockMvc mockMvc;

	@MockBean
	private PersonneService personneService;

	private final List<PersonneDto> personnes = new ArrayList<>();

	@BeforeEach // réaliser un traitement avant chaque test
	public void beforeEach() throws Exception {
		
	
		personnes.add(new PersonneDto(1L, "user1", "prenom1", LocalDate.parse("2000-12-05"), 0));
		personnes.add(new PersonneDto(2L, "user2", "prenom3", LocalDate.parse("2000-08-05"), 0));
		personnes.add(new PersonneDto(3L, "user3", "prenom3", LocalDate.parse("2000-10-05"), 0));
		
	}

	@Test
	void contextUserLoads() {
		assertThat(personneController).isNotNull();
	}

	@Test
	void testFindAll() throws Exception {

		when(personneService.getAll()).thenReturn(personnes);

		mockMvc.perform(get("/api/personne")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(personnes.size())))
				.andExpect(jsonPath("$[0].nom", is(personnes.get(0).getNom())));
	}
	
	@Test
	void testFindById() throws Exception {
		int userId = 2;
		when(personneService.getById(userId)).thenReturn(personnes.get(1));

		mockMvc.perform(get("/api/personne/{id}",userId).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(userId)))
				.andExpect(jsonPath("$.prenom", is(personnes.get(1).getPrenom())))
				.andExpect(jsonPath("$.nom", is(personnes.get(1).getNom())));
	}

}
