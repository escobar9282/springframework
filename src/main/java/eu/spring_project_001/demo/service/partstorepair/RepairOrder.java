package eu.spring_project_001.demo.service.partstorepair;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.spring_project_001.demo.service.owner.Owner;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RepairOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String carProductionDate;
    private String makeOfCar;
    private String model;
    private Boolean isCarPremium;

    @JsonIgnore
    @OneToMany(mappedBy = "repairOrder")
    private Set<CarPartsToRepair> carPartsToRepairList;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
