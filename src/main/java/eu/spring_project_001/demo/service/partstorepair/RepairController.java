package eu.spring_project_001.demo.service.partstorepair;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/repairs")
public class RepairController
{
    private final RepairService repairService;

    @PostMapping("/add")
    public ResponseEntity<RepairCommand> addRepairs(@RequestBody RepairCommand repairCommand) throws JsonProcessingException {
        repairService.createRepair(repairCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PartsToRepairView>> getRepairs(@RequestParam String firstName, @RequestParam String lastName)
    {
        List<PartsToRepairView> responseFromSystem = repairService.getRepairs(firstName, lastName);
        return  new ResponseEntity<>(responseFromSystem, HttpStatus.OK);
    }
}
