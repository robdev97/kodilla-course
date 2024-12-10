package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testWorldTestSuite() {
        //Given
        Country country1 = new Country("Australia", new BigDecimal("964486"));
        Country country2 = new Country("New Zeland", new BigDecimal("875987"));
        Country country3 = new Country("Samoa", new BigDecimal("253467"));


        Country country4 = new Country("Spain", new BigDecimal("678546"));
        Country country5 = new Country("Italy", new BigDecimal("987456"));
        Country country6 = new Country("Portugal", new BigDecimal("459747"));

        Continent australiaAndOceania = new Continent("Australia and Oceania");
        australiaAndOceania.addCountry(country1);
        australiaAndOceania.addCountry(country2);
        australiaAndOceania.addCountry(country3);

        Continent europe = new Continent("Europe");
        europe.addCountry(country4);
        europe.addCountry(country5);
        europe.addCountry(country6);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(australiaAndOceania);

        //When
        BigDecimal totalPopulation = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPopulation = new BigDecimal("4219689");
        assertEquals(expectedPopulation, totalPopulation);
    }
}
