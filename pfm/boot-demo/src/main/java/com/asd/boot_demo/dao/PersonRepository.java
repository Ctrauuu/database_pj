package com.asd.boot_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByEmail(String email);
    Optional<Person> findByNameAndEmail(String name, String email);

    Optional<Person> findByNameAndPassword(String name, String password);

}

