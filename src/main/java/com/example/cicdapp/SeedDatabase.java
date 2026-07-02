package com.example.cicdapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDatabase implements CommandLineRunner {

  private final PersonRepository personRepository;

  private static final Logger logger = LoggerFactory.getLogger(SeedDatabase.class);

  public SeedDatabase(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }
  
  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub

    Person[] persons = {
      new Person("John Doe", 30),
      new Person("Jane Doe", 25),
      new Person("Mary Doe", 40),
    };

    for (Person person : persons) {
      logger.info("Preloaded person: " + personRepository.save(person));
    }

    logger.info("Seeding has done");
  }
}
