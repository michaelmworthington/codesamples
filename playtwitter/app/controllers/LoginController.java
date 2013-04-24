package controllers;

import static play.data.Form.form;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class LoginController extends Controller
{
  final static Form<User> userForm = form(User.class);

  public static Result index()
  {
    return ok(login.render(userForm));
  }

  public static Result submit()
  {
    Form<User> filledForm = userForm.bindFromRequest();
    User created = filledForm.get();
    return ok(submit.render(created));
  }
}
