package in.raseel.rmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Categories extends Fragment implements View.OnClickListener{
	
	ImageButton beverages, salads, soups, appetizers, maincourse, desserts; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.categories);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.categories, null, false);
		beverages = (ImageButton)v.findViewById(R.id.ibBeverages);
		salads = (ImageButton)v.findViewById(R.id.ibSalads);
		soups = (ImageButton)v.findViewById(R.id.ibSoups);
		appetizers = (ImageButton)v.findViewById(R.id.ibAppetizers);
		maincourse = (ImageButton)v.findViewById(R.id.ibMainCourse);
		desserts = (ImageButton)v.findViewById(R.id.ibDesserts);
		
		beverages.setOnClickListener(this);
		salads.setOnClickListener(this);
		soups.setOnClickListener(this);
		appetizers.setOnClickListener(this);
		maincourse.setOnClickListener(this);
		desserts.setOnClickListener(this);
		
		
		return v;
	}

	@Override
	public void onClick(View arg0) {
		String categoryName = "Appetizers";
		Bundle basket = new Bundle();
		
		switch(arg0.getId()){
		case R.id.ibBeverages:
			categoryName = "Beverages";
			break;
		case R.id.ibAppetizers:
			categoryName = "Appetizers";
			break;
		case R.id.ibSalads:
			categoryName = "Salads";
			break;
		case R.id.ibSoups:
			categoryName = "Soups";
			break;
		case R.id.ibMainCourse:
			categoryName = "MainCourse";
			break;
		case R.id.ibDesserts:
			categoryName = "Desserts";
			break;
		}
		/*basket.putString("categoryName", categoryName);
		Intent a = new Intent(this, CategoryList.class);
		a.putExtras(basket);
		startActivity(a);*/
		
	}
	

}
