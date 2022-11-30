package com.robin.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import org.mariuszgromada.math.mxparser.*;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class unitFragment extends Fragment {

    public static final String my_pref_key = "sba_data";
    public static final String my_pref_sems = "NO_OF_SEMS";
    public static final String[] my_pref_crds = {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10"};
    public static final String[] my_pref_sgpa = {"s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8"};
    private SharedPreferences sharedPreferences;
    private int nos;
    private BarChart chart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_unit, container, false);
        Declaration();
        chart = (BarChart) v.findViewById(R.id.barchart);
        List<BarEntry> entries = new ArrayList<>();

        for (int i = 0; i < nos; i++) {
            entries.add(new BarEntry(i, Float.parseFloat(sharedPreferences.getString(my_pref_sgpa[i], ""))));
        }

        BarDataSet set = new BarDataSet(entries, "");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setValueTextSize(16f);
        set.setValueTextColor(Color.GRAY);
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.getDescription().setEnabled(false);
        chart.animateY(1500);
        chart.invalidate(); // refresh

        XAxis xAxis = chart.getXAxis();

        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.GRAY);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);

        YAxis yAxis = chart.getAxisLeft();
        chart.getAxisRight().setEnabled(false);
        //yAxis.setAxisMinimum(0f); // start at zero
        yAxis.setAxisMaximum(10f); // the axis maximum is 100
        yAxis.setTextColor(Color.GRAY);
        // the labels that should be drawn on the XAxis
        final String[] quarters = new String[]{"SEM 1", "SEM 2", "SEM 3", "SEM 4", "SEM 5", "SEM 6", "SEM 7", "SEM 8", "SEM 9", "SEM 10"};
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };

        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);


        return v;


    }
    private void Declaration(){

        sharedPreferences = getActivity().getSharedPreferences(my_pref_key, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(my_pref_sems) && Integer.parseInt(sharedPreferences.getString(my_pref_sems, "")) != 0) {
            nos = Integer.parseInt(sharedPreferences.getString(my_pref_sems, ""));
        } else {
            updatesemsgpa gpar = new updatesemsgpa();
            Toast.makeText(getContext(), " Update Sems", Toast.LENGTH_LONG).show();
            getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out).replace(R.id.fragment_container,gpar).commit();
        }



    }
}

