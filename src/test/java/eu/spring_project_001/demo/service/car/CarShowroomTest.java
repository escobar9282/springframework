package eu.spring_project_001.demo.service.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.spring_project_001.demo.service.enums.TypeOfEngine;
import eu.spring_project_001.demo.service.owner.Owner;
import eu.spring_project_001.demo.service.owner.OwnerRepo;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CarShowroomTest
{
    @InjectMocks
    private CarShowroom carShowroom;

    @Mock
    private CarRepo carRepo;

    @Test
    void shouldGetAllCarsFromDatabase()
    {
        // given
        Car car = new Car();
        when(carRepo.findAll()).thenReturn(List.of(car, car));

        // when
        List<Car> response = carShowroom.getAllCars(StringUtils.EMPTY);

        // then
        assertThat(response).hasSize(2);
        assertThat(response).isNotNull();
    }

    @Test
    void shouldGetAllCarsFromDatabaseWhenParameterIsGiven()
    {
        // given
        String makeOfCar = "Audi";
        Car car = new Car(1L, TypeOfEngine.ELECTRIC, StringUtils.EMPTY, makeOfCar,new Owner(), Set.of());
        CarRepo carRepo1 = mock(CarRepo.class);
        when(carRepo1.findAll()).thenReturn(List.of(car));
        OwnerRepo ownerRepo = mock(OwnerRepo.class);
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        CarShowroom carShowroom1 = new CarShowroom(carRepo1, ownerRepo, objectMapper);

        // when
        List<Car> response = carShowroom1.getAllCars(makeOfCar);

        //then
        assertThat(response).hasSize(1);
    }
    @ParameterizedTest
    @MethodSource("preparationOfTestValues")
    void shouldGetAllCarsFromDatabaseWhenParameterIsGivenUsedByParameters(String makeOfCar)
    {
        // given
        Car car = new Car(1L, TypeOfEngine.ELECTRIC, StringUtils.EMPTY, makeOfCar,new Owner(), Set.of());
        CarRepo carRepo1 = mock(CarRepo.class);
        when(carRepo1.findAll()).thenReturn(List.of(car));
        OwnerRepo ownerRepo = mock(OwnerRepo.class);
        ObjectMapper objectMapper = mock(ObjectMapper.class);
        CarShowroom carShowroom1 = new CarShowroom(carRepo1, ownerRepo, objectMapper);

        // when
        List<Car> response = carShowroom1.getAllCars(makeOfCar);

        //then
        assertThat(response).hasSize(1);
    }

    private static Stream<String> preparationOfTestValues()
    {
        return Stream.of("Audi", "Mercedes", "Lamborghini");
    }
}