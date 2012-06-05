package net.worthington.restletsample.tries;

import java.util.List;

import net.worthington.restletsample.dao.MCRDoc;
import net.worthington.restletsample.dao.MCRResponse;
import net.worthington.restletsample.dao.MavenCentralResponse;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryFourJacksonObjectMapper
{
  private static final Logger LOGGER = LoggerFactory.getLogger(TryFourJacksonObjectMapper.class);

  /**
   * Demonstrate Restlet JSON Extension
   * 
   * @param pUrl
   * @throws Exception
   */
  public void run(String pUrl) throws Exception
  {
    LOGGER.debug("Running TryFour Jackson Object Mapper:");

    Client client = new Client(new Context(), Protocol.HTTP);
    ClientResource res = new ClientResource(pUrl);
    res.setNext(client);

    try
    {
      MavenCentralResponse rep = res.get(MavenCentralResponse.class);
      System.out.println(rep.toString());

      MCRResponse response = rep.getResponse();
      int numFound = response.getNumFound();
      System.out.println("NumFound: " + numFound);

      List<MCRDoc> docs = response.getDocs();
      int i = 0;
      for (MCRDoc doc : docs)
      {
        System.out.println("Doc[" + i + "]: " + doc.getId() + " - version count: " + doc.getVersionCount());
        i++;
      }

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
