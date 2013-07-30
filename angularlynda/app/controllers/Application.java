package controllers;

import static play.data.Form.form;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Reservation;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonNode;

import play.Play;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller
{
  static JsonNode       airports     = Json.toJson(Airports.airports);
  static JsonNode       flights      = Json.toJson(Flights.flights);

  static List<JsonNode> reservations = new ArrayList<JsonNode>();

  static
  {
    try
    {
      InputStream flightsInputStream = Play.application().resourceAsStream("flights.json");
      flights = Json.parse(IOUtils.toString(flightsInputStream));

      InputStream airportsInputStream = Play.application().resourceAsStream("airports.json");
      airports = Json.parse(IOUtils.toString(airportsInputStream));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static Result index()
  {
    return ok(index.render("AngulAir"));
  }

  public static Result getAirports()
  {
    System.out.println("Getting Airports");

    return ok(airports);
  }

  public static Result getAirport(String pCode)
  {
    System.out.println("Getting Airport: " + pCode);

    return ok(airports.get(pCode));
  }

  public static Result getFlights()
  {
    System.out.println("Getting Flights");

    return ok(flights);
  }

  public static Result getReservations()
  {
    System.out.println("Getting Reservations");

    return ok(Json.toJson(reservations));
  }

  public static Result addReservation()
  {
    Form<Reservation> reservationForm = form(Reservation.class).bindFromRequest();
    if (reservationForm.hasErrors())
    {
      return badRequest(reservationForm.errorsAsJson());
    }

    Reservation reservation = reservationForm.get();

    System.out.println("Add Reservation for " + reservation.getOrigin() + ":" + reservation.getDestination());

    JsonNode flight = null;

    Iterator<JsonNode> itr = flights.iterator();
    while (itr.hasNext())
    {
      JsonNode jsonNode = (JsonNode) itr.next();
      if (reservation.getDestination().equals(jsonNode.get("destination").asText())
          && reservation.getOrigin().equals(jsonNode.get("origin").asText()))
      {
        flight = jsonNode;
        break;
      }
    }

    if (flight != null)
    {
      reservations.add(flight);
      return ok(Json.toJson(flight));
    }
    else
    {
      return notFound("Flight not found");
    }
  }
}
