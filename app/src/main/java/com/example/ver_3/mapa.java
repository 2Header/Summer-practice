package com.example.ver_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapa extends AppCompatActivity {

    protected Button btn44, btn55;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.mapa);
        Fragment fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fragment).commit();

        init();

    }

    private void init(){

        btn44 = findViewById(R.id.btn44);
        btn55 = findViewById(R.id.btn55);}

    public void onClick44(View view){
        Intent i = new Intent(mapa.this, bd.class);
        startActivity(i);
        finish();
    }

    public void onClick55(View view){
        Intent i = new Intent(mapa.this, polzvt.class);
        startActivity(i);
        finish();
    }



}
