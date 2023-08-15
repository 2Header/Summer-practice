package com.example.ver_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class log extends AppCompatActivity {
    private EditText edEmail1, edPass1, edEmail2, edPass2, edPass3, edFn, edSec, edPN;
    private FirebaseAuth mAuth;
    private Button button3, button1, button2, button4, button5;
    private TextView textView2, textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        init();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
    }

    private void init(){

        textView2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.textView);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button2 = findViewById(R.id.button2);
        button1 = findViewById(R.id.button);
        edEmail1 = findViewById(R.id.edEmail1);
        edPass1 = findViewById(R.id.edPass1);

        edEmail2 = findViewById(R.id.edEmail2);
        edPass2 = findViewById(R.id.edPass2);
        edPass3 = findViewById(R.id.edPass3);
        edFn = findViewById(R.id.edFn);
        edSec = findViewById(R.id.edSec);
        edPN = findViewById(R.id.edPN);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart(){

        super.onStart();
        notsig();
        /*FirebaseUser cUser = mAuth.getCurrentUser();

        if(cUser != null){
            sig();
            String userName = "Вы вошли как: " + cUser.getEmail();
            textView2.setText(userName);
            Toast.makeText(this,"user not null",Toast.LENGTH_SHORT).show();
        }
        else{

            Toast.makeText(this,"user null",Toast.LENGTH_SHORT).show();
        }*/
    }

    public void onClickLogIn(View view) {
        if (!TextUtils.isEmpty(edEmail1.getText().toString()) && !TextUtils.isEmpty(edPass1.getText().toString())) {
            //if (Patterns.EMAIL_ADDRESS.matcher(edEmail2.getText().toString()).matches()) {
                mAuth.signInWithEmailAndPassword(edEmail1.getText().toString(), edPass1.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                           /*FirebaseUser Vuser = mAuth.getCurrentUser();
                            if (Vuser.isEmailVerified()) {*/

                                Intent i = new Intent(log.this, bd.class);
                                startActivity(i);
                                Toast.makeText(getApplicationContext(), "User SignUp Successful", Toast.LENGTH_SHORT).show();
                           /*} else {
                                Toast.makeText(getApplicationContext(), "Подтвердите почту", Toast.LENGTH_SHORT).show();
                            }*/
                        } else {
                            notsig();
                            Toast.makeText(getApplicationContext(), "User SignUp failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            /*} else {
                Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
            }*/
        }else{
            Toast.makeText(getApplicationContext(), "Please entre Email and Password", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSignIn(View view) {
        if (!TextUtils.isEmpty(edEmail2.getText().toString()) && !TextUtils.isEmpty(edPass2.getText().toString()) && !TextUtils.isEmpty(edPass3.getText().toString()) && !TextUtils.isEmpty(edFn.getText().toString()) && !TextUtils.isEmpty(edSec.getText().toString())&& !TextUtils.isEmpty(edPN.getText().toString())) {
            if ((edPass2.getText().toString()).equals(edPass3.getText().toString())) {
                //if (Patterns.EMAIL_ADDRESS.matcher(edEmail2.getText().toString()).matches()) {


                    mAuth.createUserWithEmailAndPassword(edEmail2.getText().toString(), edPass2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User user = new User(edFn.getText().toString(), edSec.getText().toString(), edPass2.getText().toString(), edEmail2.getText().toString(), edPN.getText().toString());
                                FirebaseDatabase.getInstance().getReference("User")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    ver();
                                                    /*FirebaseUser Vuser = mAuth.getCurrentUser();
                                                    if (Vuser.isEmailVerified()) {*/

                                                        Intent i = new Intent(log.this, bd.class);
                                                        startActivity(i);
                                                        Toast.makeText(getApplicationContext(), "User has been register", Toast.LENGTH_SHORT).show();
                                                    /*} else {
                                                        Toast.makeText(getApplicationContext(), "Подтвердите почту", Toast.LENGTH_SHORT).show();
                                                    }*/
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "User hasn`t been register", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                sig3();
                                ver();
                                Toast.makeText(getApplicationContext(), "User SignIn Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                notsig();
                                Toast.makeText(getApplicationContext(), "User SignIn failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                /*}  else {
                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                }*/
            } else {
                Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getApplicationContext(), "You forgot something", Toast.LENGTH_SHORT).show();
        }
    }

    public  void onClickb4(View view){
        FirebaseAuth.getInstance().signOut();
        notsig();
    }

    public void onClickb5(View view){
        sig3();
    }

    public void onClickb3(View view){
        Intent i = new Intent(log.this, bd.class);
        startActivity(i);
    }

    private void ver(){
        FirebaseUser Zuser = mAuth.getCurrentUser();

        assert Zuser != null;
        Zuser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Проверка почты", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Проверка почты не прошла", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*private void sig(){

        FirebaseUser Zuser = mAuth.getCurrentUser();

        assert Zuser != null;
            if (Zuser.isEmailVerified()) {
                String userName = "Вы вошли как: " + Zuser.getEmail();
                textView2.setText(userName);
                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);

                button5.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                edEmail1.setVisibility(View.GONE);
                edPass1.setVisibility(View.GONE);

                button1.setVisibility(View.GONE);
                edEmail2.setVisibility(View.GONE);
                edPass2.setVisibility(View.GONE);
                edPass3.setVisibility(View.GONE);
                edFn.setVisibility(View.GONE);
                edSec.setVisibility(View.GONE);
                edPN.setVisibility(View.GONE);

            } else {
                Toast.makeText(getApplicationContext(), "Подтвердите почту", Toast.LENGTH_SHORT).show();
            }
        }*/

    private void sig3(){

            button3.setVisibility(View.GONE);
            button4.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);

            button5.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            edEmail1.setVisibility(View.GONE);
            edPass1.setVisibility(View.GONE);

            button1.setVisibility(View.VISIBLE);
            edEmail2.setVisibility(View.VISIBLE);
            edPass2.setVisibility(View.VISIBLE);
            edPass3.setVisibility(View.VISIBLE);
            edFn.setVisibility(View.VISIBLE);
            edSec.setVisibility(View.VISIBLE);
            edPN.setVisibility(View.VISIBLE);

        }

    /*private void sig2(){
        FirebaseUser Zuser = mAuth.getCurrentUser();

        assert Zuser != null;
            if (Zuser.isEmailVerified()) {
                String userName = "Вы вошли как: " + Zuser.getEmail();
                textView2.setText(userName);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                textView2.setVisibility(View.GONE);

                button5.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                edEmail1.setVisibility(View.GONE);
                edPass1.setVisibility(View.GONE);

                button1.setVisibility(View.VISIBLE);
                edEmail2.setVisibility(View.VISIBLE);
                edPass2.setVisibility(View.VISIBLE);
                edPass3.setVisibility(View.VISIBLE);
                edFn.setVisibility(View.VISIBLE);
                edSec.setVisibility(View.VISIBLE);
                edPN.setVisibility(View.VISIBLE);

            } else {
                Toast.makeText(getApplicationContext(), "Подтвердите почту", Toast.LENGTH_SHORT).show();
            }
        }*/

    private void notsig(){

        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);

        button5.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        edEmail1.setVisibility(View.VISIBLE);
        edPass1.setVisibility(View.VISIBLE);

        button1.setVisibility(View.GONE);
        edEmail2.setVisibility(View.GONE);
        edPass2.setVisibility(View.GONE);
        edPass3.setVisibility(View.GONE);
        edFn.setVisibility(View.GONE);
        edSec.setVisibility(View.GONE);
        edPN.setVisibility(View.GONE);
    }
}