package in.raseel.rmenu;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CategoryList extends Activity {

	String categoryName;
	TabHost th;
	TableLayout table;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categorylist);

		table = (TableLayout)findViewById(R.id.tableLayout1);

		th = (TabHost)findViewById(R.id.tabhost);

		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Non-Veg");
		th.addTab(specs);

		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Veg");
		th.addTab(specs);

		// Get the intent though which we reached to this class
		Bundle gotBasket = getIntent().getExtras();
		categoryName = gotBasket.getString("categoryName");
		
		table.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		TableRow row1 = new TableRow(this);
		row1.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		TextView item1 = new TextView(this);
		item1.setText("Butter Chicken");
		item1.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,1f));
		item1.setGravity(Gravity.CENTER_HORIZONTAL);
		
		TextView price1 = new TextView(this);
		price1.setText("Rs.666/-");
		price1.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,1f));
		price1.setGravity(Gravity.CENTER_HORIZONTAL);
			
				
		if (categoryName.equals("Salads")){
			item1.setText("Ceasar's Salad");
			price1.setText("Rs.777/-");
			
		} else if (categoryName.equals("Appetizers")){
			item1.setText("Masala Papad");
			price1.setText("Rs.120/-");
			
		} else if (categoryName.equals("Soups")){
			item1.setText("Hot N' Sour");
			price1.setText("Rs.100/-");
			
		} else if (categoryName.equals("Beverages")){
			item1.setText("Antiquity");
			price1.setText("Rs.230/-");
			
		} else if (categoryName.equals("Desserts")){
			item1.setText("Kulfi");
			price1.setText("Rs.444/-");
			
		}
		
		row1.addView(item1);
		row1.addView(price1);
		table.addView(row1);		

	}

}
