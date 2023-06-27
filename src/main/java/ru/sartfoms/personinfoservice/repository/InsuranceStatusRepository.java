package ru.sartfoms.personinfoservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.InsuranceStatus;

public interface InsuranceStatusRepository extends JpaRepository<InsuranceStatus, Long> {

	Collection<InsuranceStatus> findByDtReqIsNull();

}
