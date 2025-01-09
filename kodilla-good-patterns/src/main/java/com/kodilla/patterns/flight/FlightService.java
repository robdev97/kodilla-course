package com.kodilla.patterns.flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private final List<PrivateSingleFlight> flights;

    public FlightService(List<PrivateSingleFlight> flights) {
        this.flights = flights;
    }

    public List<PrivateSingleFlight> findFlightsFrom(String city) {
        return flights.stream()
                .filter(flight -> flight.getFlightFrom().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<PrivateSingleFlight> findFlightsTo(String city) {
        return flights.stream()
                .filter(flight -> flight.getFlightTo().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<List<PrivateSingleFlight>> findFlightsThrough(String flightsFrom, String through, String flightsTo) {
        List<PrivateSingleFlight> toThrough = findFlightsFrom(flightsFrom).stream()
                .filter(flight -> flight.getFlightTo().equalsIgnoreCase(through))
                .toList();

        List<PrivateSingleFlight> fromThrough = findFlightsFrom(flightsFrom).stream()
                .filter(flight -> flight.getFlightTo().equalsIgnoreCase(flightsTo))
                .toList();

        List<List<PrivateSingleFlight>> result = new ArrayList<>();
        for (PrivateSingleFlight firstFlight : toThrough) {
            for (PrivateSingleFlight secondFlight : fromThrough) {
                result.add(Arrays.asList(firstFlight, secondFlight));
            }
        }
        return result;
    }
}

