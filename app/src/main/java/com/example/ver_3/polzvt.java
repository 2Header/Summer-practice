package com.example.ver_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class polzvt extends AppCompatActivity {

    public FirebaseUser user;
    public DatabaseReference reference;
    public String userID;
    protected Button btn66, btn77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);


        //return inflater.inflate(R.layout.fragment_3, container, false);

   // View view = inflater.inflate(R.layout.user, container, false);


    user = FirebaseAuth.getInstance().getCurrentUser();
    reference = FirebaseDatabase.getInstance().getReference("User");
    userID = user.getUid();

    final TextView firstnameTextView = (TextView) findViewById(R.id.textView6);
    final TextView secondnameTextView = (TextView) findViewById(R.id.textView7);
    final TextView phonenumberTextView = (TextView)findViewById(R.id.textView9);
    final TextView emailTextView = (TextView) findViewById(R.id.textView8);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            User userProfile = snapshot.getValue(User.class);


                String FirstName = userProfile.firstName;
                String SecondName = userProfile.secondName;
                String Phone = userProfile.phoneNumber;
                String Email = userProfile.email;

                firstnameTextView.setText(FirstName);
                secondnameTextView.setText(SecondName);
                phonenumberTextView.setText(Phone);
                emailTextView.setText(Email);

        }



        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            //Toast.makeText(getActivity(), "Проблемки", Toast.LENGTH_SHORT).show();
        }
    });
    init();
}

    private void init(){

        btn66 = findViewById(R.id.btn66);
        btn77 = findViewById(R.id.btn77);}

    public void onClick66(View view){
        Intent i = new Intent(polzvt.this, mapa.class);
        startActivity(i);
        finish();
    }

    public void onClick77(View view){
        Intent i = new Intent(polzvt.this, bd.class);
        startActivity(i);
        finish();
    }


}

