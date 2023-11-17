package com.gridnine.testing;

import com.gridnine.testing.filter.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.filter.GroundTimeExceedsTwoHoursFilter;
import com.gridnine.testing.filter.SegmentsArrivalBeforeDepartureFilter;
import org.junit.Before;
import org.junit.Test;
import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class FilterTest {
    private List<Flight> flights;

    @Before
    public void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    public void testTimeTravelFilter() {
        FlightFilter filter = new DepartureBeforeCurrentTimeFilter();
        List<Flight> result = filter.filterFlights(flights);
        assertEquals(5, result.size());
    }

    @Test
    public void testPastFlightFilter() {
        FlightFilter filter = new GroundTimeExceedsTwoHoursFilter();
        List<Flight> result = filter.filterFlights(flights);
        assertEquals(5, result.size());
    }

    @Test
    public void testGroundTimeFilter() {
        FlightFilter filter = new SegmentsArrivalBeforeDepartureFilter();
        List<Flight> result = filter.filterFlights(flights);
        assertEquals(0, result.size());
    }
}
