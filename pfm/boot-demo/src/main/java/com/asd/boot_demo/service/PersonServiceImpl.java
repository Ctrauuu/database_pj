package com.asd.boot_demo.service;

import com.asd.boot_demo.converter.PersonConverter;
import com.asd.boot_demo.dao.Person;
import com.asd.boot_demo.dao.PersonRepository;
import com.asd.boot_demo.dto.PersonDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void deletePersonById(int personId) {

        personRepository.findById(personId).orElseThrow(() -> new IllegalArgumentException("id:" + personId + "doesn't exist!"));
        personRepository.deleteById(personId);

    }

    @Override
    public PersonDTO getPersonById(int id) {
        Person person = personRepository.findById(id).orElseThrow(RuntimeException::new);
        return PersonConverter.convertPerson(person);
    }

    public int addNewPerson(PersonDTO personDTO) {
        List<Person> personList = personRepository.findByEmail(personDTO.getEmail());
        if (!CollectionUtils.isEmpty(personList)) {
            throw new IllegalStateException("email" + personDTO.getEmail() + "has been taken");
        }
        Person person = personRepository.save(PersonConverter.convertPerson(personDTO));
        return person.getPersonId();
    }

    @Override
    @Transactional
    public PersonDTO updatePersonById(int personId, String name, String email) {
        Person personInDB = personRepository.findById(personId).orElseThrow(() -> new IllegalArgumentException("id" + personId + "doesn't exist!"));

        if (StringUtils.hasLength(name) && !personInDB.getName().equals(name)) {
            personInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !personInDB.getEmail().equals(email)) {
            personInDB.setEmail(email);
        }
        Person person = personRepository.save(personInDB);

        return PersonConverter.convertPerson(person);
    }

    @Override
    public Person authenticateUser(String name, String password) {
        // 查询数据库中的用户信息
        return personRepository.findByNameAndPassword(name, password).orElse(null);
    }

}