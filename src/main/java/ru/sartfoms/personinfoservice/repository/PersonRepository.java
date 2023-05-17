package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.CompositeKey;
import ru.sartfoms.personinfoservice.entity.Person;

public interface PersonRepository extends JpaRepository<Person, CompositeKey> {

}
