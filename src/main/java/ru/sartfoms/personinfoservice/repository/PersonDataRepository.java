package ru.sartfoms.personinfoservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.PersonData;

public interface PersonDataRepository extends JpaRepository<PersonData, Long> {


	Collection<PersonData> findByDtReqIsNullAndHistoricalIsNull();

	Collection<PersonData> findByDtReqIsNullAndHistorical(boolean b);

}
