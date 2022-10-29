package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("carParts")
public class CarPartsController
{
    private final CarPartsService carPartsService;

    @PostMapping("/add")
    public ResponseEntity<CarParts> addCarParts(@RequestBody @Validated CarPartsDto carParts)
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

    @PutMapping("/edit/{id}")
    public ResponseEntity<CarParts> editCarParts(@PathVariable("id")Long id, @RequestBody @Validated CarPartsDto carPartsDto)
    {
        CarParts editCarParts = carPartsService.editCarParts(id, carPartsDto);
        return  new ResponseEntity<>(editCarParts, HttpStatus.OK);
    }

}
