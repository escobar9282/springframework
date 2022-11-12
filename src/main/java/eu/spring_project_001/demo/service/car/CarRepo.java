package eu.spring_project_001.demo.service.car;

import eu.spring_project_001.demo.service.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
