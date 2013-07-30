package controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Airports
{
  static final Map<String, Airport> airports = new HashMap<String, Airport>();

  static
  {
    airports.put("ATL", new Airport("ATL", "Hartsfield Jackson Atlanta International Airport", "Atlanta", Arrays.asList("LAX", "JFK", "IAH")));
    airports.put("ORD", new Airport("ORD", "O'Hare International Airport", "Chicago", Arrays.asList("LAX", "JFK", "IAH")));
    airports.put("LAX",
                 new Airport("LAX", "Los Angles International Airport", "Los Angles", Arrays.asList("ATL",
                                                                                                    "ORD",
                                                                                                    "DFW",
                                                                                                    "DEN",
                                                                                                    "JFK",
                                                                                                    "SFO",
                                                                                                    "LAS",
                                                                                                    "PHX",
                                                                                                    "IAH",
                                                                                                    "PDX",
                                                                                                    "STL",
                                                                                                    "MCI",
                                                                                                    "BNA",
                                                                                                    "MKE")));
    airports.put("DFW", new Airport("DFW", "Dallas/Fort Worth International Airport", "Dallas/Fort Worth", Arrays.asList("LAX",
                                                                                                                         "DEN",
                                                                                                                         "JFK",
                                                                                                                         "SFO",
                                                                                                                         "MCI")));
    airports.put("DEN", new Airport("DEN", "Denver International Airport", "Denver", Arrays.asList("LAX", "DFW", "IAH")));
    airports.put("JFK", new Airport("JFK", "John F. Kennedy Internal Airport", "New York", Arrays.asList("LAX",
                                                                                                         "DFW",
                                                                                                         "BNA",
                                                                                                         "IAH",
                                                                                                         "PHX",
                                                                                                         "ORD",
                                                                                                         "LAS",
                                                                                                         "ATL")));

    airports.put("PDX", new Airport("PDX", "Portland Internal Airport", "Portland", Arrays.asList("LAX", "STL")));
    airports.put("STL", new Airport("STL", "Lambert-St. Louis Internal Airport", "St. Louis", Arrays.asList("LAX", "MCI")));
    airports.put("MCI", new Airport("MCI", "Kansas City Internal Airport", "Kansas City", Arrays.asList("LAX", "PDX")));

    airports.put("IAH", new Airport("IAH", "George Bush Intercontinental Airport", "Houston", Arrays.asList("LAX", "JFK")));
  }

}
