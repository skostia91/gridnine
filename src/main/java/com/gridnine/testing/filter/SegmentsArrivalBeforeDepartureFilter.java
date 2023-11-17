package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SegmentsArrivalBeforeDepartureFilter implements FlightFilter {

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        LocalDateTime currentTime = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(currentTime)))
                .collect(Collectors.toList());
    }
}
