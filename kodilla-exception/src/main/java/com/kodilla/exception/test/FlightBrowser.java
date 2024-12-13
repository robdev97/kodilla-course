package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightBrowser {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportMap = new HashMap<>();
        airportMap.put("JFK", true);
        airportMap.put("LAX", true);
        airportMap.put("ORD", true);
        airportMap.put("ATL", false);

        String arrivalAirport = flight.getArrivalAirport();

        if (!airportMap.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Airport " + arrivalAirport + " not found");
        }

        return airportMap.get(arrivalAirport);
    }

    public static void main(String[] args) {
        FlightBrowser flightBrowser = new FlightBrowser();
        Flight flight = new Flight("JFK", "SFO");

        try {
            boolean acceptFlight = flightBrowser.findFlight(flight);
            if (acceptFlight) {
                System.out.println("Flight to: " + flight.getArrivalAirport() + " is possible.");
            } else {
                System.out.println("Flight to: " + flight.getArrivalAirport() + " is not possible.");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
