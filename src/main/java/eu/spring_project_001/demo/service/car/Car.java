package eu.spring_project_001.demo.service.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.spring_project_001.demo.service.carparts.CarParts;
import eu.spring_project_001.demo.service.owner.Owner;
import eu.spring_project_001.demo.service.enums.TypeOfEngine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "car")
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfEngine typeOfEngine;
    private String model;
    private String makeOfCar;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private Set<CarParts> carParts;


}
