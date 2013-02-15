package net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects;

import com.google.inject.Inject;

public class TimesSquareGreeter
{
  //@Inject @ForTimesSquare Displayer displayer;
  @Inject Displayer displayer;
  
  public void sayHello()
  {
    displayer.display("Hello tourists");
  }
}
