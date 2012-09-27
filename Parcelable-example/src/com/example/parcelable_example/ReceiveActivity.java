package com.example.parcelable_example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.parcelable_example.model.House;

public class ReceiveActivity extends Activity{

	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        Bundle data = getIntent().getExtras();
			House house = data.getParcelable("house");
			Log.d("Example", "Housename: " + house.getName() + " animalcount: " + house.getAnimals().size());
	  }
}
