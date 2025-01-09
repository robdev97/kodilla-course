package com.kodilla.patterns.flight;

import java.util.Objects;

public class PrivateSingleFlight {

    private final String flightFrom;
    private final String flightTo;

    public PrivateSingleFlight(String flightFrom, String flightTo) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateSingleFlight that = (PrivateSingleFlight) o;
        return Objects.equals(flightFrom, that.flightFrom) && Objects.equals(flightTo, that.flightTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightFrom, flightTo);
    }

    @Override
    public String toString() {
        return "PrivateSingleFlight{" +
                "flightFrom='" + flightFrom + '\'' +
                ", flightTo='" + flightTo + '\'' +
                '}';
    }
}

