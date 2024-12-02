package com.asd.boot_demo.service;

import com.asd.boot_demo.dao.Person;
import com.asd.boot_demo.dto.PersonDTO;

public interface PersonService {

    void deletePersonById(int personId);

    PersonDTO getPersonById(int person_id);

    int addNewPerson(PersonDTO personDTO);

    PersonDTO updatePersonById(int personId, String name, String email);
}
