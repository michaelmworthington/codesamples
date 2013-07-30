package controllers;

public class Flight
{
  Flight(Long pNumber, String pOrigin, String pDestination, Long pPrice, String pOriginFullName, String pDestinationFullName)
  {
    number = pNumber;
    origin = pOrigin;
    destination = pDestination;
    price = pPrice;
    originFullName = pOriginFullName;
    destinationFullName = pDestinationFullName;
  }

  private Long   number;
  private String origin;
  private String destination;
  private Long   price;
  private String originFullName;
  private String destinationFullName;
  public Long getNumber()
  {
    return number;
  }
  public void setNumber(Long pNumber)
  {
    number = pNumber;
  }
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
  public Long getPrice()
  {
    return price;
  }
  public void setPrice(Long pPrice)
  {
    price = pPrice;
  }
  public String getOriginFullName()
  {
    return originFullName;
  }
  public void setOriginFullName(String pOriginFullName)
  {
    originFullName = pOriginFullName;
  }
  public String getDestinationFullName()
  {
    return destinationFullName;
  }
  public void setDestinationFullName(String pDestinationFullName)
  {
    destinationFullName = pDestinationFullName;
  }

}
