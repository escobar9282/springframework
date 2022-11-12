package eu.spring_project_001.demo.service.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {
}
