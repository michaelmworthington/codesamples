package models;

public class Reservation
{
  private String origin;
  private String destination;
  public String getOrigin()
  {
    return origin;
  }
  public void setOrigin(String pOrigin)
  {
    origin = pOrigin;
  }
  public String getDestination()
  {
    return destination;
  }
  public void setDestination(String pDestination)
  {
    destination = pDestination;
  }
  
  public String validate()
  {
    if (origin == null 
        || origin.trim().length() == 0
        || destination == null
        || destination.trim().length() == 0)
    {
      return "Invalid origin or destination";
    }
    return null;
  }

}
