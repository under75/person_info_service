package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.Address;
import ru.sartfoms.personinfoservice.entity.CompositeKey;

public interface AddressRepository extends JpaRepository<Address, CompositeKey> {

}
