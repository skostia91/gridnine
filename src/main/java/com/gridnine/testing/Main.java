package com.gridnine.testing;

import com.gridnine.testing.filter.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.GroundTimeExceedsTwoHoursFilter;
import com.gridnine.testing.filter.SegmentsArrivalBeforeDepartureFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilter departureBeforeCurrentTimeFilter = new DepartureBeforeCurrentTimeFilter();
        List<Flight> filteredByDepartureTime = departureBeforeCurrentTimeFilter.filterFlights(flights);
        System.out.println("Filtered flights by departure before current time: ");
        filteredByDepartureTime.forEach(System.out::println);

        FlightFilter segmentsArrivalBeforeDepartureFilter = new SegmentsArrivalBeforeDepartureFilter();
        List<Flight> filteredBySegmentsArrival = segmentsArrivalBeforeDepartureFilter.filterFlights(flights);
        System.out.println("Filtered flights by segments arrival before departure: ");
        filteredBySegmentsArrival.forEach(System.out::println);

        GroundTimeExceedsTwoHoursFilter groundTimeExceedsTwoHoursFilter = new GroundTimeExceedsTwoHoursFilter();
        List<Flight> filteredByGroundTime = groundTimeExceedsTwoHoursFilter.filterFlights(flights);
        System.out.println("Filtered flights by ground time exceeds two hours: ");
        filteredByGroundTime.forEach(System.out::println);
    }
}
