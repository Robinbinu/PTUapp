package com.robin.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;


public class DepartmentFragment extends Fragment {
    public String[] Depts = { "CSE", "ECE", "EIE", "CHE", "MECH","EEE","CE","IT","MECTR" };
    public String[] Sems = {"1","2","3","4","5","6","7","8"};
    ArrayAdapter<String> deptadapter;
    ArrayAdapter<String> semadapter;
    public String deptselected,semselected;
    Button next;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_department, container, false);
        AutoCompleteTextView dept = v.findViewById(R.id.actv_dept);
        AutoCompleteTextView sem = v.findViewById(R.id.actv_sem);
        next=v.findViewById(R.id.next);
        deptadapter= new ArrayAdapter<String>(getContext(),R.layout.list_item,Depts);
        dept.setAdapter(deptadapter);
        semadapter= new ArrayAdapter<String>(getContext(),R.layout.list_item,Sems);
        sem.setAdapter(semadapter);

      dept.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              deptselected= deptadapter.getItem(i);
              Toast.makeText(getContext(),deptselected, Toast.LENGTH_SHORT).show();
          }
      });
     sem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             semselected= semadapter.getItem(i);
             Toast.makeText(getContext(),semselected, Toast.LENGTH_SHORT).show();
         }
     });
     next.setOnClickListener(view -> {
         if(deptselected!=null&&semselected!=null) {
             Bundle bundle = new Bundle();
             bundle.putString("dept", deptselected);
             bundle.putString("sem", semselected);
             gpaprocess frag = new gpaprocess();
             frag.setArguments(bundle);
             getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out).replace(R.id.fragment_container,frag).commit();
         }
         else
             Toast.makeText(getContext(), "Choose your Dept and Semester", Toast.LENGTH_SHORT).show();
     });

        return v;
    }
}