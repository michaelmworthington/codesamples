package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;
import static play.data.Form.*;

@Security.Authenticated(Secured.class)
public class UserSearch extends Controller
{
  public static Result submit()
  {
    Form<UserSearchForm> loginForm = form(UserSearchForm.class).bindFromRequest();
    User searchresult = User.findByName(loginForm.get().username);
    User currentUser = User.findByName(request().username());
    return ok(submit.render(currentUser, searchresult));
  }

  public static Result follow(String pUsername)
  {
    User currentUser = User.findByName(request().username());
    currentUser.follow(pUsername);
    currentUser.save();

    return redirect(routes.TweetController.index());
  }

  public static class UserSearchForm
  {
    public String username;
  }

}
