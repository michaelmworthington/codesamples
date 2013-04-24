package controllers;

import java.util.List;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class TweetController extends Controller
{
  static Form<models.Status> statusForm = Form.form(models.Status.class);

  public static Result index()
  {
    List<models.Status> tweets = currentUserTimeline();
    return ok(index.render(tweets, statusForm));
  }

  public static Result updateStatus()
  {
    Form<models.Status> filledForm = statusForm.bindFromRequest();
    if (filledForm.hasErrors())
    {
      return badRequest(index.render(models.Status.findLatest(), filledForm));
    }
    else
    {
      models.Status.create(filledForm.get());
       return redirect(routes.TweetController.index());
      //return redirect("#");
    }
  }

  public static Result follow(Long id)
  {
    return TODO;
  }

  public static Result helloTweet()
  {
    models.Status t = new models.Status();
    t.message = "hello world2";
    t.save();

    return ok("Tweeted: hello world");
  }

  private static List<models.Status> currentUserTimeline()
  {
    return models.Status.findLatest();
  }
}
