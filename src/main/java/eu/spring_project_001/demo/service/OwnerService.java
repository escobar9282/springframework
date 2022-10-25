package eu.spring_project_001.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OwnerService
{
    private final OwnerRepo repo;

    public void addOwnerToSystem(Owner owner)
    {
        Owner ownerToSave = new Owner();
        ownerToSave.setFirstName(owner.getFirstName());
        ownerToSave.setLastName(owner.getLastName());
        ownerToSave.setAge(owner.getAge());
        ownerToSave.setIdentity(owner.getIdentity());
        ownerToSave.setStreetName(owner.getStreetName());
        ownerToSave.setCity(owner.getCity());
        ownerToSave.setPostalCode(owner.getPostalCode());
        ownerToSave.setAvailableAmountOfMoney(owner.getAvailableAmountOfMoney());
        ownerToSave.setCars(owner.getCars());
        ownerToSave.setCarServiceSet(owner.getCarServiceSet());
        repo.save(ownerToSave);
    }
}
