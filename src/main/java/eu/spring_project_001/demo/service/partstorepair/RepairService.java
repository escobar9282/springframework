package eu.spring_project_001.demo.service.partstorepair;

import eu.spring_project_001.demo.service.exceptions.OwnerDoesNotHaveThatCarException;
import eu.spring_project_001.demo.service.exceptions.OwnerNotFoundException;
import eu.spring_project_001.demo.service.owner.Owner;
import eu.spring_project_001.demo.service.owner.OwnerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RepairService
{
    private final OwnerRepo ownerRepo;

    public void createRepair(RepairCommand repairCommand)
    {
        Owner owner = ownerRepo.findByName(repairCommand.getFirstName(), repairCommand.getLastName())
                .orElseThrow(()->new OwnerNotFoundException(repairCommand.getFirstName(), repairCommand.getLastName()));
        if (owner.getCars().size() == 0)
            throw new OwnerDoesNotHaveThatCarException(repairCommand.getFirstName(), repairCommand.getLastName());

    }
}


