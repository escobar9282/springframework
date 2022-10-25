package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
