package net.jpmchase.fea.fast.repo.frstesting.codesamples;

import net.jpmchase.fea.fast.repo.frstesting.codesamples.guicemodules.DisplayModule;
import net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects.StdoutGreeter;
import net.jpmchase.fea.fast.repo.frstesting.codesamples.guiceobjects.TimesSquareGreeter;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MyApplication 
{
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector(new DisplayModule());
        StdoutGreeter greeter = injector.getInstance(StdoutGreeter.class);
        greeter.sayHello();

        TimesSquareGreeter tsGreeter = injector.getInstance(TimesSquareGreeter.class);
        tsGreeter.sayHello();
}
}
