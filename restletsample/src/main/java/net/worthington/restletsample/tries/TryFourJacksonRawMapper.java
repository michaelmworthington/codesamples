package net.worthington.restletsample.tries;

import java.util.Map;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

@SuppressWarnings("unchecked")
public class TryFourJacksonRawMapper
{

  /**
   * Demonstrate Restlet JSON Extension
   * 
   * @param pUrl
   * @throws Exception
   */
  public void run(String pUrl) throws Exception
  {
    System.out.println("Running TryFour Jackson Raw Mapper:");

    Client client = new Client(new Context(), Protocol.HTTP);
    ClientResource res = new ClientResource(pUrl);
    res.setNext(client);

    try
    {
      Map<String, Object> rep = res.get(Map.class);
      System.out.println(rep.toString());

      int code = res.getStatus().getCode();
      String description = res.getStatus().getDescription();
      System.out.format("GET %s: Response %s-%s: %s%n", pUrl, code, description, rep.toString());

    }
    catch (ResourceException ex)
    {
      int code = ex.getStatus().getCode();
      String description = ex.getStatus().getDescription();
      System.out.format("GET %s: Response %s: %s%n", pUrl, code, description);
    }

  }

}
