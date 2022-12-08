package eu.spring_project_001.demo.service.carservice;

import eu.spring_project_001.demo.service.owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public Double getPrice(String partName)
    {
        final Map<String, Double> regainMap = Map.of("maxPriceForWheel",this.maxPriceForWheel,
                "maxPriceForBrakes", this.maxPriceForBrakes, "maxPriceForAluRim", this.maxPriceForAluRim,
               "maxPriceForTurbine", this.maxPriceForTurbine, "maxPriceForGearbox", this.maxPriceForGearbox,
                "maxPriceForLightBulb", this.maxPriceForLightBulb, "maxPriceForWipers", this.maxPriceForWipers,
                "maxPriceForOilSump", this.maxPriceForOilSump, "maxPriceForExhaust", this.maxPriceForExhaust,
                "maxPriceForEngine", this.maxPriceForEngine);
        final Map<String, Double> regainMap2 = Map.of("maxPriceForLights", this.maxPriceForLights,
                "minPriceForWheel", this.minPriceForWheel,
                "minPriceForBrakes", this.minPriceForBrakes, "minPriceForAluRim", this.minPriceForAluRim,
                "minPriceForTurbine", this.minPriceForTurbine, "minPriceForGearbox", this.minPriceForGearbox,
                "minPriceForLightBulb", this.minPriceForLightBulb, "minPriceForWipers", this.minPriceForWipers,
                "minPriceForOilSump", this.minPriceForOilSump, "minPriceForExhaust", this.minPriceForExhaust);
        final Map<String, Double> regainMap3 = Map.of("minPriceForEngine", this.minPriceForEngine, "minPriceForLights", this.minPriceForLights);

        return Stream.of(regainMap, regainMap2, regainMap3)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .get(partName);


    }
}
