package net.worthington.restletsample.dao;

import java.util.List;

public class MCRSpellCheck
{
  private List<Object> iSuggestions;

  public List<Object> getSuggestions()
  {
    return iSuggestions;
  }

  public void setSuggestions(List<Object> pSuggestions)
  {
    iSuggestions = pSuggestions;
  }
}
