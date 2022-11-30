package com.robin.fragments;







import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class elibrary extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_elibrary, container, false);
        final TypeWriter tw = v.findViewById(R.id.tw);
        tw.setText("");
        tw.setCharacterDelay(55);
        tw.animateText("The PTU Library \n has 1893 e-books,\n 78 e-journals.It is a member of DELNET, MALIBNET and NDL..");

        Button delnet = v.findViewById(R.id.delnet);
        Button malibnet = v.findViewById(R.id.malinet);
        Button ebc=v.findViewById(R.id.ebcentral);
        Button ieee=v.findViewById(R.id.ieee);
        Button asme=v.findViewById(R.id.asme);
        Button asce=v.findViewById(R.id.asce);
delnet.setOnClickListener(view -> {
    //MainActivity a = new MainActivity();
    //a.addNotification();
    openWebPage("http://164.100.247.26/");
    Toast.makeText(getContext(), "Username: PCPEC \n Password: pec1809", Toast.LENGTH_LONG).show();

});
        malibnet.setOnClickListener(view -> {
            //MainActivity a = new MainActivity();
            //a.addNotification();
            openWebPage("https://www.angelfire.com/in/malibnet/genesis.html");
            Toast.makeText(getContext(), "Username :pondi \n Password: pondi-malib-001", Toast.LENGTH_LONG).show();

        });
        ebc.setOnClickListener(view -> {
            openWebPage("http://ebookcentral.proquest.com/lib/pecen");

        });
        ieee.setOnClickListener(view -> {
            openWebPage("https://ieeexplore.ieee.org/document/6461145");

        });
        asme.setOnClickListener(view -> {
            openWebPage("https://asmedigitalcollection.asme.org/");

        });
        asce.setOnClickListener(view -> {
            openWebPage("https://ascelibrary.org/journal/joeedu");

        });

        return v;
    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
       {startActivity(intent);
        }
    }
    }



