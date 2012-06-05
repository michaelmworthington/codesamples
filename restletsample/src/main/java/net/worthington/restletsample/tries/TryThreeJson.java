package net.worthington.restletsample.tries;

import org.json.JSONObject;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class TryThreeJson
{

  /**
   * Demonstrate Restlet JSON Extension
   * 
   * @param pUrl
   * @throws Exception
   */
  public void run(String pUrl) throws Exception
  {
    System.out.println("Running TryThree Json:");

    Client client = new Client(new Context(), Protocol.HTTP);
    ClientResource res = new ClientResource(pUrl);
    res.setNext(client);

    try
    {
      JSONObject rep = res.get(JSONObject.class);

      // These strings are specific to the URL passed in (in this case the search.maven.org url)
      JSONObject response = rep.getJSONObject("response");
      int numFound = response.getInt("numFound");
      System.out.println("NumFound: " + numFound);

      int code = res.getStatus().getCode();
      String description = res.getStatus().getDescription();
      System.out.format("GET %s: Response %s-%s: %s%n", pUrl, code, description, rep.toString(2));

    }
    catch (ResourceException ex)
    {
      int code = ex.getStatus().getCode();
      String description = ex.getStatus().getDescription();
      System.out.format("GET %s: Response %s: %s%n", pUrl, code, description);
    }

  }

}
