package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.Attach;
import ru.sartfoms.personinfoservice.entity.CompositeKey;

public interface AttachRepository extends JpaRepository<Attach, CompositeKey> {

}
