package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.CompositeKey;
import ru.sartfoms.personinfoservice.entity.MPIError;

public interface MPIErrorRepository extends JpaRepository<MPIError, CompositeKey> {

}
