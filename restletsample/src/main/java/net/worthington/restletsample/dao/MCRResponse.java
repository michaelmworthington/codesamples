package net.worthington.restletsample.dao;

import java.util.List;

public class MCRResponse
{
  private int          iNumFound;
  private int          iStart;
  private List<MCRDoc> iDocs;

  public int getNumFound()
  {
    return iNumFound;
  }

  public void setNumFound(int pNumFound)
  {
    iNumFound = pNumFound;
  }

  public int getStart()
  {
    return iStart;
  }

  public void setStart(int pStart)
  {
    iStart = pStart;
  }

  public List<MCRDoc> getDocs()
  {
    return iDocs;
  }

  public void setDocs(List<MCRDoc> pDocs)
  {
    iDocs = pDocs;
  }
}
