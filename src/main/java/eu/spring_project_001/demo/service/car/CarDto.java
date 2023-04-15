package eu.spring_project_001.demo.service.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CarDto
{
    private String typeOfEngine;
    private String model;
    private String makeOfCar;
    private Long ownerId;
}
