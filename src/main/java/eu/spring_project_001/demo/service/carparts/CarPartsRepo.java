package eu.spring_project_001.demo.service.carparts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartsRepo extends JpaRepository<CarParts, Long> {
}
