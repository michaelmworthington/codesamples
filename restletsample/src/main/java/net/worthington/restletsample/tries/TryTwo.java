package net.worthington.restletsample.tries;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class TryTwo
{

  /**
   * Demonstrate Error Handling
   * 
   * @param pUrl
   * @throws Exception
   */
  public void run(String pUrl) throws Exception
  {
    System.out.println("Running TryTwo:");

    Client client = new Client(new Context(), Protocol.HTTP);
    ClientResource res = new ClientResource(pUrl);
    res.setNext(client);
    try
    {
      Representation rep = res.get();
      int code = res.getStatus().getCode();
      String description = res.getStatus().getDescription();
      System.out.format("GET %s: Response %s-%s: %s%n", pUrl, code, description, rep.getText());
    }
    catch (ResourceException ex)
    {
      int code = ex.getStatus().getCode();
      String description = ex.getStatus().getDescription();
      System.out.format("GET %s: Response %s: %s%n", pUrl, code, description);
    }
  }

}
