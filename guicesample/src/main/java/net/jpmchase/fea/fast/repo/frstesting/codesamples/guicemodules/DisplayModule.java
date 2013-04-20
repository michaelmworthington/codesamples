package net.jpmchase.fea.fast.repo.frstesting.codesamples.guicemodules;

import net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects.DisplayPicker;
import net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects.Displayer;

import com.google.inject.Binder;
import com.google.inject.Module;

public class DisplayModule implements Module
{

  public void configure(Binder binder)
  {
    // We can preconfigure the classes we want to use
    //binder.bind(Displayer.class).annotatedWith(ForStdout.class).to(StdoutDisplayer.class);
    //binder.bind(Displayer.class).annotatedWith(ForTimesSquare.class).to(TimesSquareDisplayer.class);
    
    // Sometimes the classes need to be dynamically binded based on some other criteria
    // If Guice doesn't know how to create your instances, tell it who does know
    binder.bind(Displayer.class).toProvider(DisplayPicker.class);

  }

}
