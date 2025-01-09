package com.kodilla.patterns.flight;

import java.util.Arrays;
import java.util.List;

public class PrivateFlightApp {

    public static void main(String[] args) {
        List<PrivateSingleFlight> flights = Arrays.asList(
                new PrivateSingleFlight("GDAŃSK", "WROCŁAW"),
                new PrivateSingleFlight("GDAŃSK", "KRAKÓW"),
                new PrivateSingleFlight("KRAKÓW", "WROCŁAW"),
                new PrivateSingleFlight("WARSZAWA", "GDAŃSK"),
                new PrivateSingleFlight("WROCŁAW", "WARSZAWA")
        );
        FlightService flightService = new FlightService(flights);

        System.out.println("Loty z GDAŃSKA: ");
        flightService.findFlightsFrom("GDAŃSK").forEach(System.out::println);

        System.out.println("\nLoty do WROCŁAWIA: ");
        flightService.findFlightsTo("WROCŁAW").forEach(System.out::println);

        System.out.println("\nLoty z GDAŃSKA KRAKÓW do  WROCŁAWIA: ");
        flightService.findFlightsThrough("GDAŃSK", "KRAKÓW", "WROCŁAW").forEach(System.out::println);
    }
}

