package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuit {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;



    @BeforeEach
    void testDataPreparation() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

    }


    @Test
    void calculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //when
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //then
        Assertions.assertEquals(5, quantityOfSensors);

    }

    @Test
    void testCalculateAverageTemperature() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //when
        double averageTemperature = weatherForecast.calculateAverageTemperature();

        //then
        Assertions.assertEquals(25.56, averageTemperature, 0.01);
    }

    @Test
    void testCalculateMedianTemperature() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //when
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        //Then
        Assertions.assertEquals(25.5, medianTemperature, 0.01);
    }
}
