package eu.spring_project_001.demo.service.car;

import eu.spring_project_001.demo.service.owner.Owner;
import eu.spring_project_001.demo.service.owner.OwnerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class CarControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OwnerRepo repo;

    @Transactional
    @Test
    void addCar() throws Exception
    {
        // given

        Owner owner = new Owner(11L, "aaa", "bbb", 21, "ccc", "ddd", "eee", 111, 2.8, Set.of(), Set.of(), Set.of());
        repo.save(owner);
        String requestYourBody = prepareRequest();

        // when
        mockMvc.perform(post("/cars/add").content(requestYourBody)).andDo(print()).andExpect(status().isCreated());
    }

    private String prepareRequest()
    {
        return """
                {
                    "model": "Veyron Grand Sport EB",
                    "makeOfCar": "BUGATTI",
                    "typeOfEngine" : "PETROL",
                    "ownerId": 11
                }
                """;
    }

}