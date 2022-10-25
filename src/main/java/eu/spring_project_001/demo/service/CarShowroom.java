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
    private final OwnerRepo ownerRepo;

    public void addCarToSystem(CarDto carDto)
    {
        Car carToSave = new Car();
        carToSave.setMakeOfCar(carDto.getMakeOfCar());
        carToSave.setTypeOfEngine(carDto.getTypeOfEngine());
        carToSave.setModel(carDto.getModel());
        carToSave.setOwner(resolveOwnerById(carDto.getOwnerId()));
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

    private Owner resolveOwnerById(Long id)
    {
        return ownerRepo.findById(id).orElseThrow(()-> new OwnerNotFoundException(id));
    }

}
