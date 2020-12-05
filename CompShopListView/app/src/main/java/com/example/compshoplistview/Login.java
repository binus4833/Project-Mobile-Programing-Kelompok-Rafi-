package com.example.compshoplistview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;


public class Login extends Fragment {


    EditText Memail, Mpassword, Mname;
    Button LoginBtn;
    ProgressBar BarLogin;
    FirebaseAuth fAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        Memail = view.findViewById(R.id.EmailLog);
        Mpassword = view.findViewById(R.id.PasswordLog);
        LoginBtn = view.findViewById(R.id.ButtonLog);
        fAuth = FirebaseAuth.getInstance();


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(Memail.getText().toString().trim()))
                {
                    Memail.setError("E-Mail is Required");
                    return;
                }

                if(TextUtils.isEmpty(Mpassword.getText().toString().trim()))
                {
                    Mpassword.setError("Password is Required");
                    return;
                }

                fAuth.signInWithEmailAndPassword(Memail.getText().toString().trim(),Mpassword.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(getActivity(), "Welcome To CompShop", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), MainActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Error ! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        return view;


    }
}