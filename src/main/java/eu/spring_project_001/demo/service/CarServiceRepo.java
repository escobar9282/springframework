package eu.spring_project_001.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServiceRepo extends JpaRepository<CarService, Long>
{
    @Query("SELECT COUNT (cs.id) FROM CarService cs")
    Long getNumberOfCarService();
}
