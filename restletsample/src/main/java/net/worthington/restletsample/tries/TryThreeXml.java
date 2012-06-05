package net.worthington.restletsample.tries;

import java.io.OutputStreamWriter;
import java.io.PrintStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TryThreeXml
{

  /**
   * Demonstrate Restlet XML Extension
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
      Document rep = res.get(Document.class);

      // These strings are specific to the URL passed in (in this case the search.maven.org url)
      NodeList results = rep.getElementsByTagName("result");

      for (int i = 0; i < results.getLength(); i++)
      {
        String numFound = results.item(i).getAttributes().getNamedItem("numFound").getNodeValue();
        System.out.println("NumFound: " + numFound);
      }

      int code = res.getStatus().getCode();
      String description = res.getStatus().getDescription();
      System.out.format("GET %s: Response %s-%s:%n", pUrl, code, description);

      prettyPrintXMLDocument(rep, System.out);

    }
    catch (ResourceException ex)
    {
      int code = ex.getStatus().getCode();
      String description = ex.getStatus().getDescription();
      System.out.format("GET %s: Response %s: %s%n", pUrl, code, description);
    }

  }

  private void prettyPrintXMLDocument(Document pRep, PrintStream pOut) throws Exception
  {
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

    transformer.transform(new DOMSource(pRep), new StreamResult(new OutputStreamWriter(pOut, "UTF-8")));

  }

}
