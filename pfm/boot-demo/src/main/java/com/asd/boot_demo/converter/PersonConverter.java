package com.asd.boot_demo.converter;

import com.asd.boot_demo.dao.Person;
import com.asd.boot_demo.dto.PersonDTO;

public class PersonConverter {
    public static PersonDTO convertPerson(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getPersonId());
        personDTO.setName(person.getName());
        personDTO.setAge(person.getAge());
        personDTO.setEmail(person.getEmail());
        return personDTO;
    }

    public static Person convertPerson(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setAge(personDTO.getAge());
        person.setEmail(personDTO.getEmail());
        return person;
    }
}
