package net.worthington.jacksonsample;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "QTime" })
public class MCRResponseHeader
{
  private int                 iStatus;
  private int                 iQTime;
  private Map<String, String> iParams;

  public int getStatus()
  {
    return iStatus;
  }

  public void setStatus(int pStatus)
  {
    iStatus = pStatus;
  }

  @JsonProperty("QTime")
  public int getQTime()
  {
    return iQTime;
  }

  public void setQTime(int pQTime)
  {
    iQTime = pQTime;
  }

  public Map<String, String> getParams()
  {
    return iParams;
  }

  public void setParams(Map<String, String> pParams)
  {
    iParams = pParams;
  }

}
