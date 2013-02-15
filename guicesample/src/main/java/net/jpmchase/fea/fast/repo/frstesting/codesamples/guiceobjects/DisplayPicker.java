package net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import com.google.inject.Inject;
import com.google.inject.Provider;


// This class is a first-class citizen like any other -- it can have injections, etc
public class DisplayPicker implements Provider<Displayer>
{
  // You want to try to avoid calling "new" to create objects. Let Guice manage the object creation for you
  //  public Displayer get()
  //  {
  //    switch (new DateTime().getDayOfWeek()) //TODO: Use injected Clock so we can unit test
  //    {
  //      case DateTimeConstants.TUESDAY:
  //        return new TimesSquareDisplayer();
  //      default:
  //        return new StdoutDisplayer();
  //    }
  //  }
  
  
  // Provider Injection - any time you can "@Inject Foo", you can "@Inject Provider<Foo>", always
  //            get multiple instances
  //            lazy initialization
  @Inject Provider<TimesSquareDisplayer> tsdp;
  @Inject Provider<StdoutDisplayer> sdp;
  
  public Displayer get()
  {
    switch (new DateTime().getDayOfWeek())
    {
      case DateTimeConstants.FRIDAY:
        return tsdp.get();
      default:
        return sdp.get();
    }
  }
}
