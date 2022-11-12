package eu.spring_project_001.demo.service.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto
{
    private String typeOfEngine;
    private String model;
    private String makeOfCar;
    private Long ownerId;
}
