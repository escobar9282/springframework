package eu.spring_project_001.demo.service.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNotFoundExceptionTest
{
    @Test
    void shouldReturnCorrectMessage()
    {
        // given
        String message = "Car with id %s not found";
        long id = 12;

        // when
        CarNotFoundException exception = new CarNotFoundException(id);

        // then
        assertThat(exception).hasMessage(String.format(message, id));
    }
}