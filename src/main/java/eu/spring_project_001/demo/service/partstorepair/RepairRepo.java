package eu.spring_project_001.demo.service.partstorepair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface RepairRepo extends JpaRepository<RepairOrder, Long>
{
    @Query("select r from RepairOrder r where r.firstName = ?1 and r.lastName = ?2")
    List<RepairOrder> searchForRepairs(String firstName, String lastName);
}
