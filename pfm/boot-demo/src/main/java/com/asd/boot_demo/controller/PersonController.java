package com.asd.boot_demo.controller;

import com.asd.boot_demo.Response;
import com.asd.boot_demo.dao.Person;
import com.asd.boot_demo.dto.PersonDTO;
import com.asd.boot_demo.service.PersonService;
import com.asd.boot_demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person/{person_id}")
    public Response<PersonDTO> getPersonById(@PathVariable int person_id){
        return Response.newSuccess(personService.getPersonById(person_id));
    }


    @PostMapping("/person")
    public Response<Integer> addNewPerson(@RequestBody PersonDTO personDTO){
        return Response.newSuccess(personService.addNewPerson(personDTO));
    }
    @DeleteMapping("/person/{person_id}")
    public void deletePersonById(@PathVariable int person_id){
        personService.deletePersonById(person_id);
    }
    @PutMapping("/person/{person_id}")
    public Response<PersonDTO> updatePersonById(@PathVariable int person_id,@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String email){
        return Response.newSuccess(personService.updatePersonById(person_id,name,email));
    }
}
