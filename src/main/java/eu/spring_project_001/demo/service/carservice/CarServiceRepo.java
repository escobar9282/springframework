package eu.spring_project_001.demo.service.carservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CarServiceRepo extends JpaRepository<CarService, Long>, JpaSpecificationExecutor<CarService>
{
    @Query("SELECT COUNT (cs.id) FROM CarService cs")
    Long getNumberOfCarService();

}
