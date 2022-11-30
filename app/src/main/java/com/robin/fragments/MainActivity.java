package com.robin.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bt;
    FragmentManager fragmentManager;
    Fragment temp;
    Fragment fragment;
    MenuItem temp2;
    MenuItem home;
    long pressedTime;
    TextView tvlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //tvlog = findViewById(R.id.tvlog);
        bt = findViewById(R.id.bottomNavigationView);
        fragment = new HomeFragment();
        temp = fragment;
        if(savedInstanceState==null)
        {
            bt.setSelectedItemId(R.id.uchomebut);
        }
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment())
                .commit();
        //BottomNavigationView.OnNavigationItemSelectedListener selectedListner;
        bt.setOnNavigationItemSelectedListener(selectedListner);

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener selectedListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.uccalbut:
                    fragment = new CalcFragment();
                    temp = null;

                    break;
                case R.id.ucconvbut:
                    fragment = new unitFragment();
                    temp = null;

                    break;
                case R.id.uchomebut:
                    fragment = new LoginFragment();
                    temp = fragment;
                    break;
                case R.id.trfnav:
                    fragment = new WebsiteFragment();
                    temp = null;
                    break;
                case R.id.uclogbut:
                    fragment = new HomeFragment();
                    temp = null;
                    break;
               /* default:
                    Toast toast = Toast.makeText(getApplicationContext(),"Revoked",Toast.LENGTH_LONG);
                    toast.show();*/
            }
            if (fragment != null && item != temp2) {

                //fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        //.addToBackStack(null)
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.fragment_container, fragment)
                        .commit();
                temp2 = item;
            }


            return true;
        }
    };

    @Override
    public void onBackPressed() {
        //pressedTime = System.currentTimeMillis();

        if (pressedTime + 2000 > System.currentTimeMillis() && fragment == temp) {
            super.onBackPressed();
            finish();
        } else {
            bt.setSelectedItemId(R.id.uchomebut);
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
            fragment = temp;
            //if(fragment==new h)
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
    public void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ptu) //set icon for notification
                        .setContentTitle("Notifications Example") //set title of notification
                        .setContentText("This is a notification message")//this is notification message
                        .setAutoCancel(true) // makes auto cancel of notification
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification


        Intent notificationIntent = new Intent(MainActivity.this, NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", "This is a notification message");

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }}















       /*bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.uccalbut:
                        fragment= new CalcFragment();
                        break;
                    case R.id.ucconvbut:
                        fragment = new unitFragment();
                        break;
                    default:
                        Toast toast = Toast.makeText(getApplicationContext(),"Revoked",Toast.LENGTH_LONG);
                        toast.show();
                }
                if(fragment != null && item != temp2)
                {

                    fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in,R.anim.fade_out)
                            .replace(R.id.fragment_container,fragment)
                            .commit();
                    temp2=item;
                }


                return false;
            }
        });*/

