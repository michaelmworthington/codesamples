package net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects;

public class StdoutDisplayer implements Displayer
{
  public void display (String s)
  {
    System.out.println(s);
  }

}
