package com.hipatiya.staj.controller;


import com.hipatiya.staj.model.Person;
import com.hipatiya.staj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService service; //because controller uses service

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Person> getAll(){
        return service.getAllPersons();
    }

    @GetMapping
    public Person getByName(@RequestParam String name) {
        return (Person) service.getPersonByName(name);
    }

    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable Long id){
        return (Optional<Person>) service.getPersonById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return service.createPerson(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person updateDPerson){
        return service.updatePerson(id, updateDPerson)
                .orElseThrow(() -> new RuntimeException("Person not Found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deletePerson(id);
    }

    //use this when database h2 etc
    /*
    * spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
*/
}
