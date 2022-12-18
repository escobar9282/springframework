package eu.spring_project_001.demo.service.partstorepair;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.spring_project_001.demo.service.carservice.CarService;
import eu.spring_project_001.demo.service.carservice.CarServiceRepo;
import eu.spring_project_001.demo.service.enums.PremiumCar;
import eu.spring_project_001.demo.service.exceptions.InvalidUserDataException;
import eu.spring_project_001.demo.service.exceptions.OwnerDoesNotHaveThatCarException;
import eu.spring_project_001.demo.service.exceptions.OwnerNotFoundException;
import eu.spring_project_001.demo.service.owner.Owner;
import eu.spring_project_001.demo.service.owner.OwnerRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RepairService
{
    private static final double DEFAULT_PRICE_FOR_NOT_YET_EXISTING_PART = 400.0;
    private static final List<String> AVAILABLE_CAR_PARTS = List.of("wheel", "brakes", "aluRim", "turbine", "lights",
            "lightBulb", "gearbox", "wipers", "oilSump", "exhaust", "engine");
    private final OwnerRepo ownerRepo;
    private final RepairRepo repairRepo;
    private final ObjectMapper objectMapper;
    private final CarPartsToRepairRepo carPartsToRepairRepo;

    public void createRepair(RepairCommand repairCommand) throws JsonProcessingException {
        Owner owner = ownerRepo.findByName(repairCommand.getFirstName(), repairCommand.getLastName())
                .orElseThrow(() -> new OwnerNotFoundException(repairCommand.getFirstName(), repairCommand.getLastName()));
        if (owner.getCars().size() == 0)
            throw new OwnerDoesNotHaveThatCarException(repairCommand.getFirstName(), repairCommand.getLastName());
        boolean isCarPremium = PremiumCar.isCarPremium(repairCommand.getMakeOfCar());
        Map<String, Integer> brokenCarParts = retrieveBrokenCarParts(objectMapper.writeValueAsString(repairCommand.getPartsCommand()));
        RepairOrder repairOrder = new RepairOrder();
        repairOrder.setFirstName(repairCommand.getFirstName());
        repairOrder.setLastName(repairCommand.getLastName());
        repairOrder.setMakeOfCar(repairCommand.getMakeOfCar());
        repairOrder.setModel(repairCommand.getModel());
        repairOrder.setCarProductionDate(repairCommand.getCarProductionDate().toString());
        repairOrder.setIsCarPremium(isCarPremium);
        repairOrder.setOwner(owner);
        repairRepo.save(repairOrder);

        for(int i = 0; i < brokenCarParts.values().size(); i++)
        {
            CarPartsToRepair carPartsToRepair = new CarPartsToRepair();
            String carPart = brokenCarParts.keySet().stream().toList().get(i);
            int carPartNumber = brokenCarParts.get(carPart);
            carPartsToRepair.setPartName(carPart);
            carPartsToRepair.setNumberOfParts(carPartNumber);
            if (AVAILABLE_CAR_PARTS.contains(carPart))
            {
                String prefix = isCarPremium ? "max":"min";
                carPart = prefix + "PriceFor" + String.valueOf( carPart.charAt(0)).toUpperCase() + carPart.substring(1);
                CarService carService = new CarService();
                double endPointPriceForOneTypeOfPart = carPartNumber * carService.getPrice(carPart);
                carPartsToRepair.setSummaryPrice(endPointPriceForOneTypeOfPart);
            }
            else
            {
                double endPointPriceForOnePart = carPartNumber * DEFAULT_PRICE_FOR_NOT_YET_EXISTING_PART;
                carPartsToRepair.setSummaryPrice(endPointPriceForOnePart);
            }
            carPartsToRepair.setRepairOrder(repairOrder);
            carPartsToRepairRepo.save(carPartsToRepair);
        }
    }
    private Map<String, Integer> retrieveBrokenCarParts(String json)
    {
        Map<String, Integer> partsData = new HashMap<>();
        int numberOfJsons = StringUtils.countMatches(json, '{');
        for (int i = 0; i < numberOfJsons; i++)
        {
            String oneJson = StringUtils.substringBetween(json, "{", "}");
            partsData.put(StringUtils.substringBetween(oneJson, "\"partName\":\"", "\","), Integer.parseInt(StringUtils.substringAfter(oneJson,"\"numberOfParts\":")));
            json = StringUtils.remove(json,"{" + oneJson + "}");
        }
        return partsData;
    }

    protected List<PartsToRepairView> getRepairs(String firstName, String lastName)
    {
        if (Objects.isNull(firstName) || Objects.isNull(lastName) || StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName))
            throw new InvalidUserDataException();
        List<RepairOrder> orderList = repairRepo.searchForRepairs(firstName, lastName);
        List<PartsToRepairView> partsView = new ArrayList<>();
        for (RepairOrder repairOrder: orderList)
        {
            PartsToRepairView partsViewConcealed = new PartsToRepairView();
            partsViewConcealed.setFirstName(repairOrder.getFirstName());
            partsViewConcealed.setLastName(repairOrder.getLastName());
            partsViewConcealed.setModel(repairOrder.getModel());
            partsViewConcealed.setMakeOfCar(repairOrder.getMakeOfCar());
            partsViewConcealed.setLocalDate(repairOrder.getCarProductionDate());
            partsViewConcealed.setIsCarPremium(repairOrder.getIsCarPremium());
            partsViewConcealed.setPartsToRepair(repairOrder.getCarPartsToRepairList().stream().toList());
            partsView.add(partsViewConcealed);
        }
        return partsView;
    }

}


