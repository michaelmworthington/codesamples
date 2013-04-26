package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Status extends Model
{
  private static final long          serialVersionUID = 6024233673337099432L;

  @Id
  public Long                        id;
  @Required
  @MaxLength(10)
  public String                      message;
  public Date                        dateCreated      = new Date();

  public static Finder<Long, Status> find             = new Finder<Long, Status>(Long.class, Status.class);

  public static List<Status> all()
  {
    return find.all();
  }

  public static List<Status> findLatest()
  {
    return find.order("date_created desc").setMaxRows(10).findList();
  }

  public static void create(Status task)
  {
    task.save();
  }

  public static void delete(Long id)
  {
    find.ref(id).delete();
  }
}
