package com.hipatiya.staj.service;

import com.hipatiya.staj.model.Person;
import com.hipatiya.staj.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    private final PersonRepository personRepo; //service uses repository

    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return personRepo.findById(id);
    }

    public Person getPersonByName(String name) {
        return personRepo.findByName(name).orElseThrow(() ->new NoSuchElementException("No such person found: " + name));
    }

    public Person createPerson(Person person){
        return personRepo.save(person);
    }

    public Optional<Person> updatePerson(Long id, Person updateDPerson){
        // look into this more detailedly, and use it to see
        return personRepo.findById(id).map(person -> {
            person.setName(updateDPerson.getName());
            person.setAge(updateDPerson.getAge());
            return personRepo.save(person);
        });
    }

    public void deletePerson(Long id){
        personRepo.deleteById(id);
    }
}
