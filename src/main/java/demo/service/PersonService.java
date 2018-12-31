package demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import demo.model.Person;

@Service
public class PersonService {
	ArrayList<Person> persons = new ArrayList<Person>();
	public PersonService() {
		Person p = new Person();
		p.setId(1l);
		p.setAge(21);
		p.setFirstName("Steve");
		p.setLastName("Smith");
		persons.add(p);

		p = new Person();
		p.setId(2l);
		p.setAge(25);
		p.setFirstName("Tom");
		p.setLastName("Brown");
		persons.add(p);
	}
	public Person getPerson(Long id) {
		for(Person person:persons) {
			if(person.getId() == id) return person;
		}
	    return null;
	}
	public ArrayList<Person> getAll() {
		return persons;
	}
}

