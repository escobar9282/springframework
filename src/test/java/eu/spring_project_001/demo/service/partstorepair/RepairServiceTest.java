package eu.spring_project_001.demo.service.partstorepair;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.spring_project_001.demo.service.car.Car;
import eu.spring_project_001.demo.service.owner.Owner;
import eu.spring_project_001.demo.service.owner.OwnerRepo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;


import static org.mockito.Mockito.*;

class RepairServiceTest {


    @ParameterizedTest
    @MethodSource("getData")
    void createRepair(RepairCommand repairCommand, String result) throws Exception {
        // given
        CarPartsToRepair carPartsToRepair = new CarPartsToRepair();
        RepairOrder repairOrder = new RepairOrder();
        Owner ow = new Owner(1L, "Jerry", "Doncic", 29, "identity: Polish", "street: Blotna 1", "city - Olsztyn",
        11010, 12.19038758, Set.of(new Car()), Set.of(), Set.of());
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        OwnerRepo ownerRepo = mock(OwnerRepo.class);
        RepairRepo repair = mock(RepairRepo.class);
        CarPartsToRepairRepo carPartsTo = mock(CarPartsToRepairRepo.class);
        when(objectMapper.writeValueAsString(repairCommand.getPartsCommand())).thenReturn(result);
        when(ownerRepo.findByName(repairCommand.getFirstName(), repairCommand.getLastName())).thenReturn(Optional.of(ow));
        when(carPartsTo.save(any(CarPartsToRepair.class))).thenReturn(carPartsToRepair);
        when(repair.save(any(RepairOrder.class))).thenReturn(repairOrder);
        RepairService service = new RepairService(ownerRepo, repair, objectMapper, carPartsTo);

        // when
        service.createRepair(repairCommand);

        // then
        verify(objectMapper, times(1)).writeValueAsString(repairCommand.getPartsCommand());
        verify(ownerRepo, times(1)).findByName(repairCommand.getFirstName(), repairCommand.getLastName());
        verify(repair, times(1)).save(any(RepairOrder.class));
        verify(carPartsTo, times(1)).save(any(CarPartsToRepair.class));
    }
    private static Stream<Arguments>getData()
    {
        return Stream.of(Arguments.of(new RepairCommand("Audi" , "S8", "05-05-2015", List.of(new RepairCommand.PartsCommand("engine", 1)), "Jarek", "Kowalewdski"), "{\"partName\":\"engine\", \"numberOfParts\":1}"),
                Arguments.of(new RepairCommand("Audi" , "S8", "05-05-2015", List.of(new RepairCommand.PartsCommand("wipers", 2)), "Jarek", "Kowalewdski"),"{\"partName\":\"wipers\", \"numberOfParts\":2}"));
    }


}