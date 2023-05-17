package ru.sartfoms.personinfoservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.PersonsByPersCriteria;

public interface PersonsByPersCriteriaRepository extends JpaRepository<PersonsByPersCriteria, Long> {

	Collection<PersonsByPersCriteria> findByDtReqIsNull();

}
