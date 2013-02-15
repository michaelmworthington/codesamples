package net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects;

import junit.framework.TestCase;

public class GreeterTest extends TestCase
{
  public void testSayHello()
  {
    MockDisplayer mock = new MockDisplayer();
    StdoutGreeter realGreeter = new StdoutGreeter(mock);

    realGreeter.sayHello();
    assertEquals("Hello world", mock.received);
  }

  static class MockDisplayer implements Displayer
  {
    String received;

    public void display(String s)
    {
      assertNotNull(s);
      assertNull(received);
      received = s;
    }
  }
}
