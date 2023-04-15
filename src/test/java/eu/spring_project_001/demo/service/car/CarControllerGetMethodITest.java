package eu.spring_project_001.demo.service.car;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "classpath:schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:drop-schema.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@AutoConfigureMockMvc
@SpringBootTest
class CarControllerGetMethodITest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getCarFromDataBase() throws Exception
    {
        // given
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");
        headers.add("Accept", "application/json;charset=utf-8");

        // when, // then
        mockMvc.perform(get("/cars").param("parameter", "BUGATTI").headers(headers)).andDo(print()).andExpect(status().isOk()).andExpect(content().json("""
                    [{
                    "model" :"Veyron Grand Sport EB",
                    "makeOfCar" : "BUGATTI",
                    "typeOfEngine" : "PETROL",
                    "id" : 210
                    }]
                    """));
    }
}
