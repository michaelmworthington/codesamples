package net.worthington.restletsample.tries;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class TryOne
{

  /**
   * Slightly more verbose way to make a Restlet call, breaking the call into it's individual objects
   * @param pUrl
   * @throws Exception
   */
  public void run(String pUrl) throws Exception
  {
    System.out.println("Running TryOne:");
    
    ClientResource res = new ClientResource(pUrl);
    Representation rep = res.get();
    System.out.println(rep.getText());
  }

}
