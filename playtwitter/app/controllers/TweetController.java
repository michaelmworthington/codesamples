package controllers;

import static play.data.Form.form;

import java.util.List;

import models.User;
import play.Routes;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import play.mvc.Security;

@Security.Authenticated(Secured.class)
public class TweetController extends Controller
{
  static Form<models.Status> statusForm = Form.form(models.Status.class);
  static Form<User>          userForm   = Form.form(User.class);

  
  public static Result index()
  {
    List<User> allUsers = User.all();
    User loggedInUser = User.findByName(request().username());

    List<models.Status> tweets = currentUserTimeline();
    return ok(index.render(allUsers.size(), loggedInUser, tweets, statusForm, userForm));
  }

  public static Result updateStatus()
  {
    Form<models.Status> filledForm = statusForm.bindFromRequest();
    if (filledForm.hasErrors())
    {
      return badRequest(index.render(0, null, models.Status.findLatest(), filledForm, userForm));
    }
    else
    {
      models.Status.create(filledForm.get());
      return redirect(routes.TweetController.index());
      // return redirect("#");
    }
  }

  public static Result ajaxUpdateStatus()
  {
    models.Status t = new models.Status();
    t.message = form().bindFromRequest().get("message");
    t.save();

    return ok(tweetdisplay.render(t));
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
