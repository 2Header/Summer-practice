package com.example.ver_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_3 extends Fragment {

    public Fragment_3() {
        // Required empty public constructor

    }

    public FirebaseUser user;
    public DatabaseReference reference;
    public String userID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_3, container, false);


        View view = inflater.inflate(R.layout.fragment_3, container, false);


        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("User");
        userID = user.getUid();

        final TextView firstnameTextView = (TextView) view.findViewById(R.id.firstname1);
        final TextView secondnameTextView = (TextView) view.findViewById(R.id.secondname1);
        final TextView phonenumberTextView = (TextView) view.findViewById(R.id.edPN);
        final TextView emailTextView = (TextView) view.findViewById(R.id.edEmail2);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String FirstName = userProfile.firstName;
                    String SecondName = userProfile.secondName;
                    String Phone = userProfile.phoneNumber;
                    String Email = userProfile.email;

                    firstnameTextView.setText(FirstName);
                    secondnameTextView.setText(SecondName);
                    phonenumberTextView.setText(Phone);
                    emailTextView.setText(Email);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(getActivity(), "Проблемки", Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}