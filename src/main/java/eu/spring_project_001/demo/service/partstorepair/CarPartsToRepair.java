package eu.spring_project_001.demo.service.partstorepair;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.spring_project_001.demo.service.owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarPartsToRepair
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partName;
    private int numberOfParts;
    private double summaryPrice;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "repair_order_id")
    private RepairOrder repairOrder;
}
