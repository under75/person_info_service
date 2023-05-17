package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.CompositeKey;
import ru.sartfoms.personinfoservice.entity.Snils;

public interface SnilsRepository extends JpaRepository<Snils, CompositeKey> {

}
