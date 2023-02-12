package spring.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.entities.Person;
import spring.project.repositories.PersonRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")	
public class PersonController {

	private @Autowired PersonRepository personRepo;

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}

	@PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

	@GetMapping("/persons/{id}")
	public Person getSinglePerson(@PathVariable Long id) {
		return personRepo.findById(id).get();
	}

	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person person) {
		return personRepo.save(person);
	}

	@DeleteMapping("/persons/{id}")
	public ResponseEntity<HttpStatus> deletePersonById(@PathVariable Long id) {
		personRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
