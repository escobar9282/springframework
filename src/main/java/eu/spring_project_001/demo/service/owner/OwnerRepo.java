package eu.spring_project_001.demo.service.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long>

{
    @Query("SELECT o from Owner o where o.firstName = ?1 and o.lastName = ?2")
    Optional<Owner> findByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
