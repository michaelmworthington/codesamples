package controllers;

import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller
{

  public static Result index()
  {
    // return ok(index.render("Your new application is ready."));
    return ok("Hello world");
  }

  // -- Javascript routing
  
  public static Result javascriptRoutes()
  {
    response().setContentType("text/javascript");
    return ok(
              Routes.javascriptRouter("jsRoutes", 
                                      routes.javascript.TweetController.updateStatus(),
                                      routes.javascript.TweetController.ajaxUpdateStatus(),
                                      routes.javascript.UserSearch.submit(),
                                      routes.javascript.UserSearch.follow(),
                                      routes.javascript.UserSearch.ajaxsearch()));
  }
}
