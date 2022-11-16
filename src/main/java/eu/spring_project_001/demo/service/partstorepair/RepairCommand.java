package eu.spring_project_001.demo.service.partstorepair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RepairCommand
{
    private String makeOfCar;
    private String model;
    private LocalDate carProductionDate;
    private PartsCommand partsCommand;
    private String firstName;
    private String lastName;

    @Getter
    @AllArgsConstructor
    public static class PartsCommand
    {
        private String partName;
        private int numberOfParts;
    }
}
