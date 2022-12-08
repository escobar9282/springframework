package eu.spring_project_001.demo.service.partstorepair;

import lombok.Setter;

import java.util.List;

@Setter
class PartsToRepairView
{
    private String firstName, lastName, makeOfCar, model, localDate;
    private Boolean isCarPremium;
    private List<CarPartsToRepair> partsToRepair;
}
