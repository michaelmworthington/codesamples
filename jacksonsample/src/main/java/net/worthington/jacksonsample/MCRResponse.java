package net.worthington.jacksonsample;

import java.io.Serializable;
import java.util.List;

public class MCRResponse implements Serializable
{
  private static final long serialVersionUID = 1L;
  
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
