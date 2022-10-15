package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CarShowroom
{
    private final CarRepo carRepo;

    public void addCarToSystem(Car car)
    {
        Car carToSave = new Car();
        carToSave.setMakeOfCar(car.getMakeOfCar());
        carToSave.setType(car.getType());
        carToSave.setModel(car.getModel());
        carToSave.setOwner(new Owner());
        carToSave.setCarParts(new HashSet<>());
        carRepo.save(carToSave);

    }
}
