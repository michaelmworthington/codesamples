package com.helloandroid.android.progressdialogexample;

import net.worthington.codesamples.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.TextView;

/**
 * http://www.helloandroid.com/tutorials/using-threads-and-progressdialog
 * @author Michael
 *
 */
public class ProgressDialogExample extends Activity implements Runnable {

	private String pi_string;
	private TextView tv;
	private ProgressDialog pd;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.progress_dialog_example);

		tv = (TextView) this.findViewById(R.id.main);
		tv.setText("Press any key to start calculation");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		pd = ProgressDialog.show(this, "Working..", "Calculating Pi", true,
				false);

		Thread thread = new Thread(this);
		thread.start();

		return super.onKeyDown(keyCode, event);
	}

	public void run() {
		pi_string = Pi.computePi(800).toString();
		handler.sendEmptyMessage(0);
	}

	/*
	 * Why use a Handler? 
	 * 
	 * We must use a Handler object because we cannot update most UI objects 
	 * while in a separate thread. When we send a message to the Handler it 
	 * will get saved into a queue and get executed by the UI thread as soon as possible.
	 */
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			pd.dismiss();
			tv.setText(pi_string);

		}
	};

}