package net.worthington.restletsample.tries;

import org.restlet.resource.ClientResource;

public class TryZero
{

  /**
   * Make a simple Restlet Call and write the output to sysout
   * @param pUrl
   * @throws Exception
   */
  public void run(String pUrl) throws Exception
  {
    System.out.println("Running TryZero:");

    new ClientResource(pUrl).get().write(System.out);
  }

}
