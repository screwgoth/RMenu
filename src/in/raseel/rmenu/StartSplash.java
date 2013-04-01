package in.raseel.rmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class StartSplash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startsplash);
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent intent = new Intent("in.raseel.rmenu.STAFFSCREEN");
					startActivity(intent);
				}
			} // run()
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}

}


