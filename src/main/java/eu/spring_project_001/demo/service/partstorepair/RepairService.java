package eu.spring_project_001.demo.service.partstorepair;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.spring_project_001.demo.service.carservice.CarService;
import eu.spring_project_001.demo.service.carservice.CarServiceRepo;
import eu.spring_project_001.demo.service.enums.PremiumCar;
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
    private final CarServiceRepo carServiceRepo;
    private final ObjectMapper objectMapper;

    public void createRepair(RepairCommand repairCommand) throws JsonProcessingException {
        Owner owner = ownerRepo.findByName(repairCommand.getFirstName(), repairCommand.getLastName())
                .orElseThrow(() -> new OwnerNotFoundException(repairCommand.getFirstName(), repairCommand.getLastName()));
        if (owner.getCars().size() == 0)
            throw new OwnerDoesNotHaveThatCarException(repairCommand.getFirstName(), repairCommand.getLastName());
        boolean isCarPremium = PremiumCar.isCarPremium(repairCommand.getMakeOfCar());
        Map<String, Integer> brokenCarParts = retrieveBrokenCarParts(objectMapper.writeValueAsString(repairCommand.getPartsCommand()));
        List<Double> endPointPriceForAllActivities = new ArrayList<>();

        for(int i = 0; i < brokenCarParts.values().size(); i++)
        {
            String carPart = brokenCarParts.keySet().stream().toList().get(i);
            int carPartNumber = brokenCarParts.get(carPart);
            if (AVAILABLE_CAR_PARTS.contains(carPart))
            {
                String prefix = isCarPremium ? "max":"min";
                carPart = prefix + "PriceFor" + String.valueOf( carPart.charAt(0)).toUpperCase() + carPart.substring(1);
                CarService carService = new CarService();


                double endPointPriceForOnePart = carPartNumber * carServiceRepo.findOne(specification);
                endPointPriceForAllActivities.add(endPointPriceForOnePart);
            }
            else
            {
                double endPointPriceForOnePart = carPartNumber * DEFAULT_PRICE_FOR_NOT_YET_EXISTING_PART;
                endPointPriceForAllActivities.add(endPointPriceForOnePart);
            }

        }
    }

    private Map<String, Integer> retrieveBrokenCarParts(String json)
    {
        Map<String, Integer> partsData = new HashMap<>();
        int numberOfJsons = StringUtils.countMatches(json, '{');
        for (int i = 0; i < numberOfJsons; i++)
        {
            String oneJson = StringUtils.substringBetween(json, "{", "}");
            partsData.put(StringUtils.substringBetween(oneJson, "\"partName\":\"", "\","), Integer.parseInt(StringUtils.substringBetween(oneJson,"\"numberOfParts\":\"", "" )));
            json = StringUtils.remove(json,"{" + oneJson + "}");
        }
        return partsData;
    }
}


