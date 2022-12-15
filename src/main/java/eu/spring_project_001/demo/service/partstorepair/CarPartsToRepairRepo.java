package eu.spring_project_001.demo.service.partstorepair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartsToRepairRepo extends JpaRepository<CarPartsToRepair, Integer>
{

}
