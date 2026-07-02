package com.example.cicdapp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  private final PersonRepository personRepository;

  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @GetMapping("/")
  public ResponseEntity<List<Person>> home() {

    List<Person> persons = personRepository.findAll();

    return ResponseEntity.ok().body(persons);
  }
}
