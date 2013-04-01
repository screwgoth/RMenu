package in.raseel.rmenu;

import in.raseel.rmenu.DefaultFragment;
import in.raseel.rmenu.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainView extends FragmentActivity implements OnClickListener {

	public static final String TAG = "RMenuMainView";
	Button categories;
	Button help;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);

		init();
		categories.setOnClickListener(this);
		help.setOnClickListener(this);

		Log.v(TAG, "Initialised");
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft;
		Fragment f = null;
		Log.v(TAG, "Setting Default Fragment");
		f = new DefaultFragment();
		if(fm.findFragmentByTag("rightfragment")!=null) {
			Log.v(TAG, "Remove rightfragment before DefaultFragment");
			ft = fm.beginTransaction();
			ft.remove(fm.findFragmentByTag("rightfragment"));
			ft.commit();
		}
		ft = fm.beginTransaction();
		ft.add(R.id.rightcontent, f, "rightfragment");
		ft.commit();
	}

	public void init(){
		categories = (Button)findViewById(R.id.bCategories);
		help = (Button)findViewById(R.id.bHelp);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft;
		Fragment f = null;

		switch(view.getId()){
		case R.id.bCategories:
			f = new Categories();
			if(fm.findFragmentByTag("rightfragment")!=null) {
				Log.v(TAG, "Remove rightfragment before AnimalFragment");
				ft = fm.beginTransaction();
				ft.remove(fm.findFragmentByTag("rightfragment"));
				ft.commit();
			}
			ft = fm.beginTransaction();
			ft.add(R.id.rightcontent, f, "rightfragment");
			ft.commit();
			break;
		case R.id.bHelp:
			f = new HelpFragment();
			if(fm.findFragmentByTag("rightfragment")!=null) {
				Log.v(TAG, "Remove rightfragment before BirdFragment");
				ft = fm.beginTransaction();
				ft.remove(fm.findFragmentByTag("rightfragment"));
				ft.commit();
			}
			ft = fm.beginTransaction();
			ft.add(R.id.rightcontent, f, "rightfragment");
			ft.commit();
			break;
		}

	}

	
	
	

}
