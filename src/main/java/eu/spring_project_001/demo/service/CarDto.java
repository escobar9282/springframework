package eu.spring_project_001.demo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto
{
    private TypeOfEngine typeOfEngine;
    private String model;
    private String makeOfCar;
    private Long ownerId;
}
