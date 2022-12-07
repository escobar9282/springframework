package eu.spring_project_001.demo.service.partstorepair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RepairCommand
{
    @NotNull
    @NotBlank
    private String makeOfCar;

    @NotNull
    @NotBlank
    private String model;
    private LocalDate carProductionDate;

    @NotNull
    private List<PartsCommand> partsCommand;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @Getter
    @AllArgsConstructor
    public static class PartsCommand
    {
        @NotNull
        @NotBlank
        private String partName;
        private int numberOfParts;
    }
}
