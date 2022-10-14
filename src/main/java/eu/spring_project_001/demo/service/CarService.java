package eu.spring_project_001.demo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarService
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private List<Double> priceForWheel = List.of(200.0, 2000.0);
    private List<Double> priceForBrakes = List.of(400.0, 800.0);
    private List<Double> priceForTurbine = List.of(1000.0, 8000.0);
    private List<Double> priceForAluRim = List.of(500.7, 2000.0);
    private List<Double> priceForGearbox = List.of(5000.500, 10000.0);
    private List<Double> priceForLightBulb = List.of(0.05, 300.0);
    private List<Double> priceForWipers = List.of(40.030, 400.500);
    private List<Double> priceForOilSump = List.of(200.0, 800.0);
    private List<Double> priceForExhaust = List.of(400.0, 1000.0);
    private List<Double> priceForEngine = List.of(500.0, 80000.0);
    private List<Double> priceForLights = List.of(600.0, 1000.0);
}
