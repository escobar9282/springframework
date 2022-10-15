package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController
{
    private final CarShowroom carShowroom;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car)
    {
        carShowroom.addCarToSystem(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
