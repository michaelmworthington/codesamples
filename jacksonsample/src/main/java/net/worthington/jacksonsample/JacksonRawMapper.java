package net.worthington.jacksonsample;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonRawMapper
{
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

    InputStream is = JacksonRawMapper.class.getResourceAsStream("user.json");
    Map<String, Object> userData = mapper.readValue(is, Map.class);

    // Map<String, Object> userData = mapper.readValue(new File("D:\\user.json"), Map.class);
    System.out.println(userData.toString());

    Set<String> keys = userData.keySet();
    for (String key : keys)
    {
      Object o = userData.get(key);
      System.out.println("UserData[" + key + "]: " + o.toString());
    }

  }
}
