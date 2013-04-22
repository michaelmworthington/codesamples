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
        List<Tweet> tweets = Tweet.all();
        Tweet t = new Tweet();
        t.tweet = "hello world";
        t.save();

        List<Tweet> tweets2 = Tweet.all();
        Assert.assertEquals(tweets.size(), tweets2.size());
      }
    });
  }
}
