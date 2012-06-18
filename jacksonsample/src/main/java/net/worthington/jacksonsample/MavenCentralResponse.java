package net.worthington.jacksonsample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "highlighting" })
public class MavenCentralResponse
{
  private MCRResponseHeader iResponseHeader;
  private MCRResponse       iResponse;
  private MCRSpellCheck     iSpellcheck;
  //private String   iHighlighting;

  public MCRResponseHeader getResponseHeader()
  {
    return iResponseHeader;
  }

  public void setResponseHeader(MCRResponseHeader responseHeader)
  {
    iResponseHeader = responseHeader;
  }

  public MCRResponse getResponse()
  {
    return iResponse;
  }

  public void setResponse(MCRResponse response)
  {
    iResponse = response;
  }

  public MCRSpellCheck getSpellcheck()
  {
    return iSpellcheck;
  }

  public void setSpellcheck(MCRSpellCheck spellcheck)
  {
    iSpellcheck = spellcheck;
  }

/*  public String getHighlighting()
  {
    return iHighlighting;
  }

  public void setHighlighting(String pHighlighting)
  {
    iHighlighting = pHighlighting;
  }
*/}
