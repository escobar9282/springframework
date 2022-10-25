package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController
{
    private final OwnerService ownerService;

    @PostMapping("/add")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner)
    {
        ownerService.addOwnerToSystem(owner);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
