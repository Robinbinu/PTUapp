package com.robin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class gpa_result extends Fragment {
    Float gpa;
    String Name,dept,sem,score;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    FirebaseDatabase fdb;
    DatabaseReference dbr;
    gpastorage gpastorage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_gpa_result, container, false);
        TextView gparesult = v.findViewById(R.id.gparesult);
        fdb = FirebaseDatabase.getInstance();
        dbr = fdb.getReference("gpastorage");
        gpastorage = new gpastorage();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        gsc = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(getActivity(),gso);
        //GoogleSignInAccount account = GoogleSignInAccount.fromAccount(;//String name = account.getDisplayName();// String mail = account.getEmail();

        Bundle bundl = this.getArguments();
        assert bundl != null;
        String name = bundl.getString("name");
        gpa = bundl.getFloat("gpa");
        dept= bundl.getString("dept");
        sem=bundl.getString("sem");
        score=String.valueOf(gpa);
        gparesult.setText(String.valueOf(gpa));
        addDatatoFirebase(name,sem,dept,score);
       return v;
    }
    private void addDatatoFirebase(String name, String sem, String dept,String gpa) {
        // below 3 lines of code is used to set
        // data in our object class.
        gpastorage.setName(name);
        gpastorage.setsem(sem);
        gpastorage.setdept(dept);
        gpastorage.setgpa(gpa);

        // we are use add value event listener method
        // which is called with database reference.
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                dbr.setValue(gpastorage);

                // after adding this data we are showing toast message.
                Toast.makeText(getActivity(), "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(getActivity(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}