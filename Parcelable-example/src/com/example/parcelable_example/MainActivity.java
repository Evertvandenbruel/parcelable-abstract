package com.example.parcelable_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.parcelable_example.model.Cat;
import com.example.parcelable_example.model.Dog;
import com.example.parcelable_example.model.House;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        House house = new House("My house");
        house.getAnimals().add(new Dog("Hond", 2));
        house.getAnimals().add(new Cat("Kat"));
        
        Intent i = new Intent(getApplicationContext(), ReceiveActivity.class);
        i.putExtra("house", house);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
