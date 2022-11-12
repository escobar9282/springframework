package eu.spring_project_001.demo.service.carservice;

import eu.spring_project_001.demo.service.owner.Owner;
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
@Table(name = "carService")
public class CarService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private double minPriceForWheel = 200.0;
    private double minPriceForBrakes = 400.0;
    private double minPriceForTurbine = 1000.500;
    private double minPriceForAluRim = 500.7;
    private double minPriceForGearbox = 5000.0;
    private double minPriceForLightBulb = 0.50;
    private double minPriceForWipers = 40.030;
    private double minPriceForOilSump = 200.0;
    private double minPriceForExhaust = 400.0;
    private double minPriceForEngine = 500.0;
    private double minPriceForLights = 600.0;

    private double maxPriceForWheel = 800.0;
    private double maxPriceForBrakes = 800.0;
    private double maxPriceForTurbine = 8000.500;
    private double maxPriceForAluRim = 2000.0;
    private double maxPriceForGearbox = 10000.0;
    private double maxPriceForLightBulb = 300.0;
    private double maxPriceForWipers = 400.0;
    private double maxPriceForOilSump = 800.0;
    private double maxPriceForExhaust = 1000.0;
    private double maxPriceForEngine = 80000.0;
    private double maxPriceForLights = 1000.0;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
