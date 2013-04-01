package in.raseel.rmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RestaurantSplash extends Activity implements OnClickListener {

	TextView sN, tId, nppl;
	Button menu;
	String servingStaffName;
	Integer tableId, numOfPpl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurantsplash);
		
		sN = (TextView)findViewById(R.id.tvSentStaffName);
		tId = (TextView)findViewById(R.id.tvSentTableID);
		nppl = (TextView)findViewById(R.id.tvSentNumPpl);
		
		menu = (Button)findViewById(R.id.bShowMenu);
		menu.setOnClickListener(this);
		
		// Get the intent though which we reached to this class
		Bundle gotBasket = getIntent().getExtras();
		//Get Data from the passed Bundle
		servingStaffName = gotBasket.getString("staffName");
		sN.setText(servingStaffName);
		
		tableId = gotBasket.getInt("tableNum");
		tId.setText(tableId.toString());
		
		numOfPpl = gotBasket.getInt("NumbePpl");
		nppl.setText(numOfPpl.toString());
		
		

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent a = new Intent(this, MainView.class);
		startActivity(a);
		
	}
	
	

}
