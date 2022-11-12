package eu.spring_project_001.demo.service.car;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.spring_project_001.demo.service.enums.TypeOfEngine;
import eu.spring_project_001.demo.service.exceptions.CarNotFoundException;
import eu.spring_project_001.demo.service.exceptions.OwnerNotFoundException;
import eu.spring_project_001.demo.service.owner.Owner;
import eu.spring_project_001.demo.service.owner.OwnerRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarShowroom
{
    private final CarRepo carRepo;
    private final OwnerRepo ownerRepo;

    private final ObjectMapper objectMapper;

    public void addCarToSystem(CarDto carDto)
    {
        Car carToSave = new Car();
        carToSave.setMakeOfCar(carDto.getMakeOfCar());
        carToSave.setTypeOfEngine(TypeOfEngine.validatedTypeOfEngine(carDto.getTypeOfEngine()));
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

    public Car editCar(Long id, CarDto carDto)
    {
        Car concealedCar = carRepo.findById(id).orElseThrow(()-> new CarNotFoundException(id));
        concealedCar.setMakeOfCar(carDto.getMakeOfCar());
        concealedCar.setModel(carDto.getModel());
        concealedCar.setTypeOfEngine(TypeOfEngine.validatedTypeOfEngine(carDto.getTypeOfEngine()));
        concealedCar.setOwner(resolveOwnerById(carDto.getOwnerId()));
        carRepo.save(concealedCar);

        return concealedCar;
    }
    public Car editCarElement(Long id, CarDto carDto) throws JsonProcessingException {
        Car concealedCar = carRepo.findById(id).orElseThrow(()-> new CarNotFoundException(id));
        List<String> undergoneObject = List.of("model", "makeOfCar", "typeOfEngine", "ownerId");
        List<String> equalizedObjects = new ArrayList<>();
        String carAsString = objectMapper.writeValueAsString(carDto).replace('"',' ');
        for (int i = 0; i < undergoneObject.size(); i++)
        {
            if (carAsString.contains(undergoneObject.get(i)))
            {
                if (i == undergoneObject.size() - 1)
                {
                    String result = StringUtils.substringBetween( carAsString, undergoneObject.get(i) + " :", "}");
                    equalizedObjects.add(result);
                    break;
                }
                String result = StringUtils.substringBetween( carAsString, undergoneObject.get(i) + " :", ",");
                equalizedObjects.add(result);
            }
        }
        resolveSetterMethodForCar(equalizedObjects, carDto, concealedCar);
        carRepo.save(concealedCar);

        return concealedCar;
    }
    private void resolveSetterMethodForCar(List<String> jsonValues, CarDto carDto, Car concealedCar)
    {
        if (!"null".equals(jsonValues.get(0)))
        {
            concealedCar.setModel(carDto.getModel());
        }

        if (!"null".equals(jsonValues.get(1)))
        {
            concealedCar.setMakeOfCar(carDto.getMakeOfCar());
        }

        if (!"null".equals(jsonValues.get(2)))
        {
            concealedCar.setTypeOfEngine(TypeOfEngine.validatedTypeOfEngine(carDto.getTypeOfEngine()));
        }

        if (!"null".equals(jsonValues.get(3)))
        {
            concealedCar.setOwner(resolveOwnerById(carDto.getOwnerId()));
        }
    }

}
