package models;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TweetTest
{
  @Test
  public void simpleCheck()
  {
    int a = 1 + 1;
    Assert.assertEquals(a, 2);
  }

  @Test
  public void testTweet()
  {
    running(fakeApplication(), new Runnable() {
      public void run()
      {
        List<Status> tweets = Status.all();
        Status t = new Status();
        t.message = "hello world";
        t.save();

        List<Status> tweets2 = Status.all();
        Assert.assertEquals(tweets.size(), tweets2.size());
      }
    });
  }
}
