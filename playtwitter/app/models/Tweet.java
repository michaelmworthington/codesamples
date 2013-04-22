package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Tweet extends Model
{
  private static final long serialVersionUID = 6024233673337099432L;

  @Id
  public Long id;
  @Required
  @MaxLength(10)
  public String tweet;
  public Date createDate = new Date();
  
  public static Finder<Long, Tweet> find             = new Finder<Long, Tweet>(Long.class, Tweet.class);

  public static List<Tweet> all()
  {
    return find.all();
  }

  public static List<Tweet> findLatest()
  {
    return find.order("id desc").setMaxRows(10).findList();
  }

  public static void create(Tweet task)
  {
    task.save();
  }

  public static void delete(Long id)
  {
    find.ref(id).delete();
  }
}
