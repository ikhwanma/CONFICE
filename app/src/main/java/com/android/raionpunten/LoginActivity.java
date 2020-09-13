package com.android.raionpunten;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail,inputPassword;
    private Button btnLogin;
    private ProgressDialog loadingbar;
    private String parentDb = "User";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        loadingbar = new ProgressDialog(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }


    private void loginUser() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        email = email.replace("@","%1").replace(".","%2");
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please Write Your Email...",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please Write Your Password...",Toast.LENGTH_SHORT).show();
        }
        else{
            loadingbar.setTitle("Logging in");
            loadingbar.setMessage("Please wait!");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            allowAccess(email,password);
        }
    }

    private void allowAccess(final String email ,final String password) {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDb).child(email).exists()){
                    User userData = dataSnapshot.child(parentDb).child(email).getValue(User.class);
                    if(userData.getEmail().equals(email)){
                        if(userData.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this, "Logged In Successfull", Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();
                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                            CurrentOnline.currentOnlineUser = userData;
                            startActivity(intent);
                        }else{
                            loadingbar.dismiss();
                            Toast.makeText(LoginActivity.this, "Password incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this, "Account with this "+email+" doesn't exist", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(LoginActivity.this, "You must create a new account", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}

