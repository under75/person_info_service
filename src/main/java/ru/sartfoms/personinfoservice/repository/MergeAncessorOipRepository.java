package ru.sartfoms.personinfoservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.MergeAncessorOip;

public interface MergeAncessorOipRepository extends JpaRepository<MergeAncessorOip, Long> {

	Collection<MergeAncessorOip> findByDtreqIsNull();

}
