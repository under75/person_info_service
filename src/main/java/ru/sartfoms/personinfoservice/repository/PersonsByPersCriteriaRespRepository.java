package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.CompositeKey;
import ru.sartfoms.personinfoservice.entity.PersonsByPersCriteriaResp;

public interface PersonsByPersCriteriaRespRepository extends JpaRepository<PersonsByPersCriteriaResp, CompositeKey> {

}
