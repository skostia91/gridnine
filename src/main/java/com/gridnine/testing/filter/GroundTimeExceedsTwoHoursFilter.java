package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {

    private static final long MAX_GROUND_TIME_HOURS = 2;

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment currentSegment = segments.get(i);
                        Segment nextSegment = segments.get(i + 1);
                        long groundTimeHours = Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate()).toHours();
                        if (groundTimeHours > MAX_GROUND_TIME_HOURS) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}
