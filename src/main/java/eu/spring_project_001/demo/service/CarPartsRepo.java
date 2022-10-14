package eu.spring_project_001.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartsRepo extends JpaRepository<CarParts, Long> {
}
