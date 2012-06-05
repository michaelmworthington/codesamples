package net.worthington.restletsample;

import net.worthington.restletsample.tries.*;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class App
{
  public static void main(String[] args) throws Exception
  {
    SLF4JBridgeHandler.install();
    
    String url = "http://search.maven.org/solrsearch/select?q=guice&rows=20&start=20&wt=json";
    //String url = "http://search.maven.org/solrsearch/select?q=guice&rows=2&wt=xml";
    //String url = "http://localhost:8182/";
    //String url = "http://www.google.com/404";

    // TryZero myapp = new TryZero();
    //TryOne myapp = new TryOne();
    //TryTwo myapp = new TryTwo();
    //TryThreeJson myapp = new TryThreeJson();
    //TryThreeXml myapp = new TryThreeXml();
    TryFourJacksonObjectMapper myapp = new TryFourJacksonObjectMapper();
    //TryFourJacksonRawMapper myapp = new TryFourJacksonRawMapper();
    myapp.run(url);
  }
}
