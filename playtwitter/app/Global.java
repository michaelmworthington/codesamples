import models.User;
import play.Application;
import play.GlobalSettings;
import play.Logger;

public class Global extends GlobalSettings
{

  @Override
  public void onStart(Application app)
  {
    Logger.info("Application has started");

    if (User.findByName("mike") == null)
    {
      User loggedInUser = new User();
      loggedInUser.username = "mike";
      loggedInUser.password = "password";
      loggedInUser.follow("mary");
      loggedInUser.follow("joe");
      User.create(loggedInUser);

      models.Status t = new models.Status();
      t.message = "hello from global";
      models.Status.create(t);
    }

  }

  @Override
  public void onStop(Application app)
  {
    Logger.info("Application shutdown...");
  }

}
