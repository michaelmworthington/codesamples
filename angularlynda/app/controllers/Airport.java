package controllers;

import java.util.List;

public class Airport
{
  Airport(String pCode, String pName, String pCity, List<String> pDestinations)
  {
    code = pCode;
    name = pName;
    city = pCity;
    destinations = pDestinations;
  }

  private String       code;
  private String       name;
  private String       city;
  private List<String> destinations;

  public String getCode()
  {
    return code;
  }

  public void setCode(String pCode)
  {
    code = pCode;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String pName)
  {
    name = pName;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String pCity)
  {
    city = pCity;
  }

  public List<String> getDestinations()
  {
    return destinations;
  }

  public void setDestinations(List<String> pDestinations)
  {
    destinations = pDestinations;
  }

}
