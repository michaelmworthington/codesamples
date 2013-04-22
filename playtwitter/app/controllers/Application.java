package controllers;

import java.util.List;

import models.Tweet;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller
{
  static Form<Tweet> tweetForm = Form.form(Tweet.class);
  
  public static Result index()
  {
    Tweet t = new Tweet();
    t.tweet = "hello world2";
    t.save();
    
    return ok("Tweeted: hello world");
  }

  public static Result getTweets()
  {
    List<Tweet> tweets = Tweet.findLatest();
    return ok(index.render(Tweet.findLatest(), tweetForm));
  }
  
  public static Result create()
  {
    Form<Tweet> filledForm = tweetForm.bindFromRequest();
    if (filledForm.hasErrors())
    {
      return badRequest(index.render(Tweet.findLatest(), filledForm));
    }
    else
    {
      Tweet.create(filledForm.get());
      return redirect(routes.Application.getTweets());
    }
  }
}
