package eu.spring_project_001.demo.service.carparts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.spring_project_001.demo.service.car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarParts
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String wheel;
    private String brakes;
    private String aluRim;
    private String turbine;
    private String lights;
    private String lightBulb;
    private String gearbox;
    private String wipers;
    private String oilSump;
    private String exhaust;
    private String engine;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
