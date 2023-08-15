package com.example.ver_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class bd extends AppCompatActivity {

    RecyclerView recyclerView;

    private DatabaseReference myRef;

    private ArrayList<Calendar> messagesList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;
    protected Button btn22, btn33;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bd);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef = FirebaseDatabase.getInstance().getReference();

        messagesList = new ArrayList<>();

        init();

        ClearAll();

        GetDataFromFirebase();
    }

    private void init(){

        btn22 = findViewById(R.id.btn22);
        btn33 = findViewById(R.id.btn33);}

    private void GetDataFromFirebase() {

        Query query = myRef.child("Calendar");
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Calendar messages = new Calendar();

                    messages.setImageUrl(snapshot.child("Image").getValue().toString());
                    messages.setName(snapshot.child("Name").getValue().toString());

                    messagesList.add(messages);

                }
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), messagesList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void onClick22(View view){
        Intent i = new Intent(bd.this, polzvt.class);
        startActivity(i);
        finish();
    }

    public void onClick33(View view){
        Intent i = new Intent(bd.this, mapa.class);
        startActivity(i);
        finish();
    }

    private void ClearAll(){

        if (messagesList != null){
            messagesList.clear();

            if (recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();
    }
}
