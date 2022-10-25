package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Car>> getCars()
    {
        List<Car> carList = carShowroom.getAllCars();
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> removeCar(@PathVariable("id") Long id)
    {
        carShowroom.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
