package eu.spring_project_001.demo.service.carparts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarPartsDto
{
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
    private Long carId;
}
