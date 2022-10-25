package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("carParts")
public class CarPartsController
{
    private final CarPartsService carPartsService;

    @PostMapping("/add")
    public ResponseEntity<CarParts> addCarParts(@RequestBody CarPartsDto carParts)
    {
        carPartsService.addCarPartsToSystem(carParts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarParts>> getCarParts()
    {
        List<CarParts> carPartsList = carPartsService.carParts();
        return new ResponseEntity<>(carPartsList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CarParts> removeCarParts(@PathVariable("id")Long id)
    {
        carPartsService.deleteCarParts(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
