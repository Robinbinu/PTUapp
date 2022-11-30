package com.robin.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class syllabus extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_syllabus, container, false);
        Button cse,ece,che,ce,eee,eie,it,mech,mectr;
        cse=v.findViewById(R.id.csesyl);
        ece=v.findViewById(R.id.ecesyl);
        che=v.findViewById(R.id.chesyl);
        ce=v.findViewById(R.id.cesyl);
        eee=v.findViewById(R.id.eeesyl);
        eie=v.findViewById(R.id.eiesyl);
        it=v.findViewById(R.id.itsyl);
        mech=v.findViewById(R.id.mechsyl);
        mectr=v.findViewById(R.id.mectrsyl);

        cse.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1v4iMSunWAh_Ke6B7tdzJSVHEU3PUDE30/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        ece.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1v_uQXPtFQwvgWEoKoPqWFWH7VLfz-R-H/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        che.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1yjBi9KlRZsS3gz_jv7LqX3LhUg-nM6E0/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        ce.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1D4FkJMAXIMKJsA1MzDSaHsbjwv1b8o5X/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        eee.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1ZYF24gmt_Y9S2L2ZMpBumnif0yUbYLWO/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        eie.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1LwCSGgZmF__CxH2DIh8ETi6VqCW5PYXS/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        it.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1qrJB72SGSdFTZZ_Oe-IMo2g43_Ev6esf/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        mech.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/1fWHML_6waLu289KsFh_cy7SZoCD-lImE/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        mectr.setOnClickListener(view -> {
            String url="https://drive.google.com/file/d/12dtsBTHgSg8AtwhT49jqeYMOwAFqvUqH/view?usp=sharing";
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.google.android.apps.docs"));
        });
        return v;
    }
}