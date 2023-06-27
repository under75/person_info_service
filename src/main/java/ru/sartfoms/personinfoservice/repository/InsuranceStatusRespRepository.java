package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.InsuranceStatusResp;

public interface InsuranceStatusRespRepository extends JpaRepository<InsuranceStatusResp, Long> {

}
