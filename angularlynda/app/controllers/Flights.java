package controllers;

import java.util.ArrayList;
import java.util.List;

public class Flights
{
  static final List<Flight> flights = new ArrayList<Flight>();
  static
  {
    flights.add(new Flight(112L, "ATL", "LAX", 232L, "Atlanta", "Los Angles"));
    flights.add(new Flight(812L, "ATL", "JFK", 192L, "Atlanta", "John F. Kennedy"));
    flights.add(new Flight(357L, "ATL", "IAH", 152L, "Atlanta", "George Bush"));

    flights.add(new Flight(1234L, "PDX", "STL", 99L, "Pheonix", "St Louis"));
    flights.add(new Flight(5678L, "MCI", "PDX", 199L, "Kansas City", "Phoenix"));
  }

}
