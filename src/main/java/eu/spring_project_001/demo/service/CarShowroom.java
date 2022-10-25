package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarShowroom
{
    private final CarRepo carRepo;

    public void addCarToSystem(Car car)
    {
        Car carToSave = new Car();
        carToSave.setMakeOfCar(car.getMakeOfCar());
        carToSave.setTypeOfEngine(car.getTypeOfEngine());
        carToSave.setModel(car.getModel());
        carToSave.setOwner(car.getOwner());
        carToSave.setCarParts(car.getCarParts());
        carRepo.save(carToSave);
    }

    public List<Car> getAllCars()
    {
        return carRepo.findAll();
    }

    public void deleteCar(Long id)
    {
        carRepo.deleteById(id);
    }
}
