package eu.spring_project_001.demo.service.owner;

import eu.spring_project_001.demo.service.car.Car;
import eu.spring_project_001.demo.service.carservice.CarService;
import eu.spring_project_001.demo.service.partstorepair.RepairOrder;
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
public class Owner
{
    @Id
    @Column(name = "owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String identity;
    private String streetName;
    private String city;
    private int postalCode;
    private double availableAmountOfMoney;

    @OneToMany(mappedBy = "owner")
    private Set<Car> cars;

    @OneToMany(mappedBy = "owner")
    private Set<RepairOrder> repairOrders;

    @OneToMany(mappedBy = "owner")
    private Set<CarService> carServiceSet;
}
