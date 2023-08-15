package com.example.ver_3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Base_act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_2);

        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = (BottomNavigationView.OnNavigationItemSelectedListener) item -> {
        Fragment selectedFragment = null;

        switch(item.getItemId()){

            case R.id.item1:
                selectedFragment = new Fragment_11();
                break;

            case R.id.item2:
                selectedFragment = new Fragment_22();
                break;

            case R.id.item3:
                selectedFragment = new Fragment_33();
                break;

        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout
                ,selectedFragment).commit();
        return true;


    };
}
