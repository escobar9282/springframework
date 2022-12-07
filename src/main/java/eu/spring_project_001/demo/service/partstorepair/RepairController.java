package eu.spring_project_001.demo.service.partstorepair;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
