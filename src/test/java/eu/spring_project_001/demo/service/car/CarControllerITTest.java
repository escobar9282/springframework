package eu.spring_project_001.demo.service.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
@SpringBootTest
class CarControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Transactional
    @Test
    void addCar() throws Exception
    {
        // given
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");
        headers.add("Accept", "application/json;charset=utf-8");
        String requestYourBody = prepareRequest();

        // when, // then
        mockMvc.perform(post("/cars/add").content(requestYourBody).headers(headers)).andDo(print()).andExpect(status().isCreated());
    }

    private String prepareRequest()
    {
        return """
                {
                    "model" : "Veyron Grand Sport EB",
                    "makeOfCar" : "BUGATTI",
                    "typeOfEngine" : "PETROL",
                    "ownerId" : 110
                }
                """;
    }

}