package net.worthington.codesamples;

import com.example.progressdialog.NotificationTest;
import com.helloandroid.android.progressdialogexample.ProgressDialogExample;
import com.lightcone.progressbarexample.ProgressBarExample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener
{
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button b1 = (Button) findViewById(R.id.googleExampleButton);
    b1.setOnClickListener(this);

    Button b2 = (Button) findViewById(R.id.helloAndroidButton);
    b2.setOnClickListener(this);

    Button b3 = (Button) findViewById(R.id.utkButton);
    b3.setOnClickListener(this);

  }

  @Override
  public void onClick(View v)
  {
    if (v.getId() == R.id.googleExampleButton)
    {
      Log.d("net.worthington", "Google Button was clicked");
      startActivity(new Intent(Main.this, NotificationTest.class));
    }
    else if (v.getId() == R.id.helloAndroidButton)
    {
      Log.d("net.worthington", "HelloAndroid button was clicked");
      startActivity(new Intent(Main.this, ProgressDialogExample.class));
    }
    else if (v.getId() == R.id.utkButton)
    {
      Log.d("net.worthington", "UTK button was clicked");
      startActivity(new Intent(Main.this, ProgressBarExample.class));
    }
    else
    {
      Log.d("net.worthington", "Another field was clicked");
    }
  }

}
