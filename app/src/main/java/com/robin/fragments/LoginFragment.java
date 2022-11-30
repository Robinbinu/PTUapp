package com.robin.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginFragment<bool> extends Fragment {
public String name;
CircleImageView profile;
TypeWriter greet;
TextView mailid;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        profile = v.findViewById(R.id.profile_image);
        greet = v.findViewById(R.id.greet);
        mailid = v.findViewById(R.id.mail);
        Button login=v.findViewById(R.id.log);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        gsc = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(getActivity(),gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getActivity());
        assert account != null;
        name = account.getDisplayName();
        String mail = account.getEmail();
        Uri img = account.getPhotoUrl();
        //greet.setText("Hi "+name+"!");
        greet.setText("");
        greet.setCharacterDelay(55);
        greet.animateText("Hi "+name+"!"+".");
        mailid.setText(mail);
        Picasso
                .get()
                .load(img)
                .into(profile);
       Bundle userinfo = new Bundle();
       userinfo.putString("name",name);
       userinfo.putString("mail",mail);
        gpa_result gpar = new gpa_result();
        gpar.setArguments(userinfo);





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.fragment_container,new HomeFragment())
                        .commit();


            }

        });
        return v;
    }

}