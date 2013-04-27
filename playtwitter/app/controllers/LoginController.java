package controllers;

import static play.data.Form.form;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;
import views.html.submit;

public class LoginController extends Controller
{
  public static Result login()
  {
    return ok(login.render(form(Login.class)));
  }

  public static Result authenticate()
  {
    Form<Login> loginForm = form(Login.class).bindFromRequest();
    if (loginForm.hasErrors())
    {
      return badRequest(login.render(loginForm));
    }
    else
    {
      session().clear();
      session("username", loginForm.get().username);
      return redirect(routes.TweetController.index());
    }
  }

  /**
   * Logout and clean the session.
   */
  public static Result logout()
  {
    session().clear();
    flash("success", "You've been logged out");
    return redirect(routes.LoginController.login());
  }

  // -- Authentication

  public static class Login
  {

    public String username;
    public String password;

    public String validate()
    {
      if (User.authenticate(username, password) == null)
      {
        return "Invalid user or password";
      }
      return null;
    }

  }
}
