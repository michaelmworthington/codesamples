package net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects;

import com.google.inject.Inject;

public class StdoutGreeter
{
  // Example of Field Injection
  // @Inject  @ForStdout  Displayer displayer;

  // Example of Method Injection
  // Displayer displayer;
  // @Inject void setDisplayer(Displayer displayer)
  // {
  // this.displayer = displayer;
  // }

  // Example of Constructor Injection
   final Displayer displayer;
   @Inject StdoutGreeter(Displayer displayer)
   {
   this.displayer = displayer;
   }

  public void sayHello()
  {
    displayer.display("Hello world");
  }
}
