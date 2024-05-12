package com.kiiril.gitshorts.services;

import com.kiiril.gitshorts.models.Person;
import com.kiiril.gitshorts.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> index() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person getByUsername(String username) {
        return personRepository.findByUsername(username).orElse(null);
    }
}
