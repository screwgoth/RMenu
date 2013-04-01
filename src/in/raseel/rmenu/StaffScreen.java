package in.raseel.rmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class StaffScreen extends Activity implements OnItemSelectedListener, OnClickListener {

	Spinner staffName, tableId, noOfPpl;
	Button start;
	String[] staffList  = {"Rahul", "Pravin", "Swapnil", "Manoj", "Vandita"};
	Integer[] tableNo = { 1, 2, 3};
	Integer[] numPpl = { 2, 3, 4, 5, 6};
	int staffPosition=0, tablePostion=0, pplPosition=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.staffscreen);
		
		ArrayAdapter<String> staffAdaptor = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, staffList);
		staffName = (Spinner)findViewById(R.id.spStaffName);
		staffName.setAdapter(staffAdaptor);
		staffName.setOnItemSelectedListener(this);
		
		ArrayAdapter<Integer> tableAdaptor = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, tableNo);
		tableId = (Spinner)findViewById(R.id.spTableID);
		tableId.setAdapter(tableAdaptor);
		tableId.setOnItemSelectedListener(this);
		
		ArrayAdapter<Integer> pplAdaptor = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, numPpl);
		noOfPpl = (Spinner)findViewById(R.id.spNoOfPpl);
		noOfPpl.setAdapter(pplAdaptor);
		noOfPpl.setOnItemSelectedListener(this);
		
		start = (Button)findViewById(R.id.bStartSession);
		start.setOnClickListener(this);
		

		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		staffPosition = staffName.getSelectedItemPosition();
		
		tablePostion = tableId.getSelectedItemPosition();

		pplPosition = noOfPpl.getSelectedItemPosition();	
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {

		String servingStaff = staffList[staffPosition];
		int tableNum = tableNo[tablePostion];
		int pplNum = numPpl[pplPosition];
		
		Bundle basket = new Bundle();
		basket.putString("staffName", servingStaff);
		basket.putInt("tableNum", tableNum);
		basket.putInt("NumbePpl", pplNum);
		
		Intent a = new Intent(this, RestaurantSplash.class);
		a.putExtras(basket);
		startActivity(a);
		
	}
	
}
