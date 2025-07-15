package com.hipatiya.staj.model;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //what is this
    private Long id;

    @Column (name = "age")
    private Integer age;

    @Column(name = "name")
    private String name;

    //default constructor
    public Person() {}

    //parameterli constr
    public Person(String name, Integer age){
        this.name=name;
        this.age=age;
    }

    //getters abd setters
    public Long getId() {return id;}
    public void setId(Long id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public Integer getAge(){return age;}
    public void setAge(Integer age){this.age=age;}
}
