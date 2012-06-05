package net.worthington.restletsample.dao;

import java.util.List;

public class MCRDoc
{
  private String iId;
  private String iG;
  private String iA;
  private String iLatestVersion;
  private String iRepositoryId;
  private String iP;
  private String iTimestamp;
  private String iVersionCount;
  private List<String> iText;
  private List<String> iEc;

  public String getId()
  {
    return iId;
  }
  public void setId(String pId)
  {
    iId = pId;
  }
  public String getG()
  {
    return iG;
  }
  public void setG(String pG)
  {
    iG = pG;
  }
  public String getA()
  {
    return iA;
  }
  public void setA(String pA)
  {
    iA = pA;
  }
  public String getLatestVersion()
  {
    return iLatestVersion;
  }
  public void setLatestVersion(String pLatestVersion)
  {
    iLatestVersion = pLatestVersion;
  }
  public String getRepositoryId()
  {
    return iRepositoryId;
  }
  public void setRepositoryId(String pRepositoryId)
  {
    iRepositoryId = pRepositoryId;
  }
  public String getP()
  {
    return iP;
  }
  public void setP(String pP)
  {
    iP = pP;
  }
  public String getTimestamp()
  {
    return iTimestamp;
  }
  public void setTimestamp(String pTimestamp)
  {
    iTimestamp = pTimestamp;
  }
  public String getVersionCount()
  {
    return iVersionCount;
  }
  public void setVersionCount(String pVersionCount)
  {
    iVersionCount = pVersionCount;
  }
  public List<String> getText()
  {
    return iText;
  }
  public void setText(List<String> pText)
  {
    iText = pText;
  }
  public List<String> getEc()
  {
    return iEc;
  }
  public void setEc(List<String> pEc)
  {
    iEc = pEc;
  }

}
