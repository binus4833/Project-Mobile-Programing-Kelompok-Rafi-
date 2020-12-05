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
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends Fragment {

    EditText Memail, Mpassword, Mname;
    Button RegistBtn;
    ProgressBar BarRegist;
    FirebaseAuth fAuth;
//    DatabaseReference reff;
//    Member member;

    Boolean isDataValid = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        Memail = view.findViewById(R.id.EmailReg);
        Mpassword = view.findViewById(R.id.PasswordReg);
        Mname = view.findViewById(R.id.NameReg);
        RegistBtn = view.findViewById(R.id.ButtonReg);
        fAuth = FirebaseAuth.getInstance();



        RegistBtn.setOnClickListener(new View.OnClickListener() {
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

                fAuth.createUserWithEmailAndPassword(Memail.getText().toString().trim(),Mpassword.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(getActivity(), "Welcome To CompShop " + Mname.getText().toString(), Toast.LENGTH_SHORT).show();
//                        String id = fAuth.getCurrentUser().getUid();
//                        member = new Member();
//                        reff = FirebaseDatabase.getInstance().getReference().child("Member").child(id);
//                        member.setName(Mname.getText().toString());
//                        reff.child(id).setValue(member);
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