package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.submit;

public class UserSearch extends Controller
{
  final static Form<User> userForm = Form.form(User.class);

  public static Result submit()
  {
    Form<User> filledForm = userForm.bindFromRequest();
    User created = filledForm.get();
    return ok(submit.render(created));
  }

  public static Result follow(String pUsername)
  {
    User currentUser = getUser("mike");
    currentUser.follow(pUsername);
    currentUser.save();

    return redirect(routes.TweetController.index());
  }

  private static models.User getUser(String pUsername)
  {
    return User.findByName(pUsername);
  }

}
