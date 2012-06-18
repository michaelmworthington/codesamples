package net.worthington.jacksonsample;

import java.io.InputStream;

import net.worthington.jacksonsample.User.Name;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MCRObjectMapper
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

    InputStream is = JacksonRawMapper.class.getResourceAsStream("mcr.json");
    MavenCentralResponse mcr = mapper.readValue(is, MavenCentralResponse.class);

    // User user = mapper.readValue(new File("D:\\user.json"), User.class);
    System.out.println(mcr.toString());

    mcr.getResponse().setNumFound(0);

    // mapper.writeValue(new File("D:\\user-modified.json"), user);
    mapper.writeValue(System.out, mcr);
  }
}
