package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model
{
  private static final long        serialVersionUID = -5096388401331975841L;

  @Id
  public Long                      id;

  @Required
  public String                    username;
  
  @Required
  public String                    password;
  
  @ManyToMany(cascade=CascadeType.ALL)
  @JoinTable(name = "friends",
             joinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
             )
  public List<User>                followers = new ArrayList<User>();

  public static Finder<Long, User> find             = new Finder<Long, User>(Long.class, User.class);

  public void follow(String pName)
  {
    User follow = findByName(pName);
    if (follow == null)
    {
      follow = new User();
      follow.username = pName;
      follow.password = "password";
      User.create(follow);
    }
    followers.add(follow);
  }

  public static User authenticate(String email, String password)
  {
    return find.where().eq("username", email).eq("password", password).findUnique();
  }
  
  public static List<User> all()
  {
    return find.all();
  }

  public static User findByName(String pName)
  {
    return find.where().eq("username", pName).findUnique();
  }

  public static void create(User task)
  {
    task.save();
  }

  public static void delete(Long id)
  {
    find.ref(id).delete();
  }
}
