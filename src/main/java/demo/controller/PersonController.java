package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Person;
import demo.repository.PersonRepository;

@RefreshScope
@CrossOrigin
@RestController
public class PersonController {
	
	@Autowired
    private PersonRepository personRepository;
	
	@Value("${value: Default Client Value}")
	private String value;
	
	@PostMapping("/create/persons")
    public Person create(@RequestBody Person user)
    {
        return personRepository.save(user);
    }


    @GetMapping("/persons")
    public List<Person> findAll()
    {
        return personRepository.findAll();
    }


    @PutMapping("/persons/{id}")
    public Person update(@PathVariable("person_id") Long id, @RequestBody Person personObject)
    {
        Person person = personRepository.findById(id).get();
        person.setFirstName(personObject.getFirstName());
        person.setLastName(personObject.getLastName());
        return personRepository.save(person);
    }

    
    
	@GetMapping("/client")
    public String client()
    {
        return value;
    }
}

