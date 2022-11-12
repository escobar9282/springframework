package eu.spring_project_001.demo.service.carparts;

import eu.spring_project_001.demo.service.exceptions.CarNotFoundException;
import eu.spring_project_001.demo.service.exceptions.CarPartsNotFoundException;
import eu.spring_project_001.demo.service.car.Car;
import eu.spring_project_001.demo.service.car.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarPartsService
{
    private final CarPartsRepo repo;

    private final CarRepo carRepo;

    public void addCarPartsToSystem(CarPartsDto carParts)
    {
        CarParts carPartsToSave = new CarParts();
        carPartsToSave.setWheel(carParts.getWheel());
        carPartsToSave.setBrakes(carParts.getBrakes());
        carPartsToSave.setTurbine(carParts.getTurbine());
        carPartsToSave.setAluRim(carParts.getAluRim());
        carPartsToSave.setGearbox(carParts.getGearbox());
        carPartsToSave.setLightBulb(carParts.getLightBulb());
        carPartsToSave.setWipers(carParts.getWipers());
        carPartsToSave.setOilSump(carParts.getOilSump());
        carPartsToSave.setExhaust(carParts.getExhaust());
        carPartsToSave.setEngine(carParts.getEngine());
        carPartsToSave.setLights(carParts.getLights());
        carPartsToSave.setCar(resolveCarById(carParts.getCarId()));
        repo.save(carPartsToSave);
    }

    private Car resolveCarById(Long id)
    {
        return carRepo.findById(id).orElseThrow(()-> new CarNotFoundException(id));
    }

    public List<CarParts> carParts()
    {
        return repo.findAll();
    }

    public void deleteCarParts(Long id)
    {
        repo.deleteById(id);
    }

    public CarParts editCarParts(Long id, CarPartsDto carPartsDto)
    {
        CarParts concealedCarParts = repo.findById(id).orElseThrow(()-> new CarPartsNotFoundException(id));
        concealedCarParts.setWheel(carPartsDto.getWheel());
        concealedCarParts.setBrakes(carPartsDto.getBrakes());
        concealedCarParts.setAluRim(carPartsDto.getAluRim());
        concealedCarParts.setTurbine(carPartsDto.getTurbine());
        concealedCarParts.setLights(carPartsDto.getLights());
        concealedCarParts.setLightBulb(carPartsDto.getLightBulb());
        concealedCarParts.setGearbox(carPartsDto.getGearbox());
        concealedCarParts.setWipers(carPartsDto.getWipers());
        concealedCarParts.setOilSump(carPartsDto.getOilSump());
        concealedCarParts.setExhaust(carPartsDto.getExhaust());
        concealedCarParts.setEngine(carPartsDto.getEngine());
        concealedCarParts.setCar(resolveCarById(carPartsDto.getCarId()));
        repo.save(concealedCarParts);

        return concealedCarParts;
    }
}
