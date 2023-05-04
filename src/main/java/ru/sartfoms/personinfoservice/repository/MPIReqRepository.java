package ru.sartfoms.personinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sartfoms.personinfoservice.entity.MPIReq;
import ru.sartfoms.personinfoservice.entity.MPIReqId;

public interface MPIReqRepository extends JpaRepository<MPIReq, MPIReqId> {
	
	MPIReq getByExtrid(String extRid);
}
