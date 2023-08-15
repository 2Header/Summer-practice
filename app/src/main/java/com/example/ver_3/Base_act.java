package com.example.ver_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


/*public class Base_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PageAdapter2(this));

        TabLayout tabLayout = findViewById((R.id.tabLayout));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position){

                switch (position) {
                    case 0:{
                        tab.setText("1");
                        tab.setIcon(R.drawable.ic_calendar);
                        break;
                    }
                    case 1: {

                        tab.setText("2");
                        tab.setIcon(R.drawable.ic_map);
                        break;
                    }
                    case 2: {
                        tab.setText("3");
                        tab.setIcon(R.drawable.ic_person);
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();
    }
}
*/