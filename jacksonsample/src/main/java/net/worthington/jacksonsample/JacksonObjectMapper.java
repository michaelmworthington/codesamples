package net.worthington.jacksonsample;

import java.io.InputStream;

import net.worthington.jacksonsample.User.Name;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonObjectMapper
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

    InputStream is = JacksonRawMapper.class.getResourceAsStream("user.json");
    User user = mapper.readValue(is, User.class);

    // User user = mapper.readValue(new File("D:\\user.json"), User.class);
    System.out.println(user.toString());

    user.setGender(User.Gender.FEMALE);
    Name n = user.getName();
    n.setFirst("Mike");
    n.setLast("W");
    user.setName(n);

    // mapper.writeValue(new File("D:\\user-modified.json"), user);
    mapper.writeValue(System.out, user);
  }
}
