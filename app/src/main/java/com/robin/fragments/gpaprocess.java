package com.robin.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


public class gpaprocess extends Fragment {
    int a;
String dept;
String sem;
public Character[] grades,grader;
public String[] CSE1, CSE2, CSE3, CSE4, CSE5, CSE6, CSE7, CSE8, temp,grget;
public float[] CPCSE1, CPCSE2, CPCSE3, CPCSE4, CPCSE5, CPCSE6, CPCSE7, CPCSE8, CP;
public int[] score;
    Character one,two,three,four,five,six,seven,eight,nine;
ArrayAdapter<Character> grade;
   


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gpaprocess, container, false);
        extracteddata();
        grade = new ArrayAdapter<Character>(getContext(),R.layout.list_item,grades);
        TextView sub1 = v.findViewById(R.id.sub1);
        TextView sub2 = v.findViewById(R.id.sub2);
        TextView sub3 = v.findViewById(R.id.sub3);
        TextView sub4 = v.findViewById(R.id.sub4);
        TextView sub5 = v.findViewById(R.id.sub5);
        TextView sub6 = v.findViewById(R.id.sub6);
        TextView sub7 = v.findViewById(R.id.sub7);
        TextView sub8 = v.findViewById(R.id.sub8);
        TextView sub9 = v.findViewById(R.id.sub9);

        AutoCompleteTextView acsub1 = v.findViewById(R.id.actvsub1);
        AutoCompleteTextView acsub2 = v.findViewById(R.id.actvsub2);
        AutoCompleteTextView acsub3 = v.findViewById(R.id.actvsub3);
        AutoCompleteTextView acsub4 = v.findViewById(R.id.actvsub4);
        AutoCompleteTextView acsub5 = v.findViewById(R.id.actvsub5);
        AutoCompleteTextView acsub6 = v.findViewById(R.id.actvsub6);
        AutoCompleteTextView acsub7 = v.findViewById(R.id.actvsub7);
        AutoCompleteTextView acsub8 = v.findViewById(R.id.actvsub8);
        AutoCompleteTextView acsub9 = v.findViewById(R.id.actvsub9);

        TextInputLayout t5 = v.findViewById(R.id.ti5);
        TextInputLayout t6 = v.findViewById(R.id.ti6);
        TextInputLayout t7 = v.findViewById(R.id.ti7);
        TextInputLayout t8 = v.findViewById(R.id.ti8);
        TextInputLayout t9 = v.findViewById(R.id.ti9);

        Button gpacal = v.findViewById(R.id.gpacalc);



        Bundle bundle = this.getArguments();
        assert bundle != null;
        dept =bundle.getString("dept");
        sem  = bundle.getString("sem");
        //t.setText(dept+" "+sem);
        //data assignment
        if (dept == "CSE") {
            if (sem == "1") {
                temp = CSE1;
                CP   = CPCSE1;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setText(temp[5]);
                acsub6.setAdapter(grade);
                sub7.setText(temp[6]);
                acsub7.setAdapter(grade);
                sub8.setVisibility(View.GONE);
                t8.setVisibility(View.GONE);
                sub9.setVisibility(View.GONE);
                t9.setVisibility(View.GONE);

            }
            else if (sem == "2") {
                temp = CSE2;
                CP   = CPCSE2;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setText(temp[5]);
                acsub6.setAdapter(grade);
                sub7.setText(temp[6]);
                acsub7.setAdapter(grade);
                sub8.setVisibility(View.GONE);
                t8.setVisibility(View.GONE);
                sub9.setVisibility(View.GONE);
                t9.setVisibility(View.GONE);

            }
            else if (sem == "3") {
                temp = CSE3;
                CP   = CPCSE3;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setText(temp[5]);
                acsub6.setAdapter(grade);
                sub7.setText(temp[6]);
                acsub7.setAdapter(grade);
                sub8.setText(temp[7]);
                acsub8.setAdapter(grade);
                sub9.setText(temp[8]);
                acsub9.setAdapter(grade);

            }
            else if (sem == "4") {
                temp = CSE4;
                CP   = CPCSE4;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setText(temp[5]);
                acsub6.setAdapter(grade);
                sub7.setText(temp[6]);
                acsub7.setAdapter(grade);
                sub8.setText(temp[7]);
                acsub8.setAdapter(grade);
                sub9.setVisibility(View.GONE);
                t9.setVisibility(View.GONE);

            }
            else if (sem == "5") {
                temp = CSE5;
                CP   = CPCSE5;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setText(temp[5]);
                acsub6.setAdapter(grade);
                sub7.setText(temp[6]);
                acsub7.setAdapter(grade);
                sub8.setText(temp[7]);
                acsub8.setAdapter(grade);
                sub9.setVisibility(View.GONE);
                t9.setVisibility(View.GONE);

            }
            else if (sem == "6") {
                temp = CSE6;
                CP   = CPCSE6;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setText(temp[5]);
                acsub6.setAdapter(grade);
                sub7.setText(temp[6]);
                acsub7.setAdapter(grade);
                sub8.setText(temp[7]);
                acsub8.setAdapter(grade);
                sub9.setVisibility(View.GONE);
                t9.setVisibility(View.GONE);

            }
            else if (sem =="7") {
                temp = CSE7;
                CP   = CPCSE7;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setText(temp[5]);
                acsub6.setAdapter(grade);
                sub7.setText(temp[6]);
                acsub7.setAdapter(grade);
                sub8.setText(temp[7]);
                acsub8.setAdapter(grade);
                sub9.setVisibility(View.GONE);
                t9.setVisibility(View.GONE);

            }
            else if (sem =="8") {
                temp = CSE8;
                CP   = CPCSE8;
                sub1.setText(temp[0]);
                acsub1.setAdapter(grade);
                sub2.setText(temp[1]);
                acsub2.setAdapter(grade);
                sub3.setText(temp[2]);
                acsub3.setAdapter(grade);
                sub4.setText(temp[3]);
                acsub4.setAdapter(grade);
                sub5.setText(temp[4]);
                acsub5.setAdapter(grade);
                sub6.setVisibility(View.GONE);
                t6.setVisibility(View.GONE);
                sub7.setVisibility(View.GONE);
                t7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                t8.setVisibility(View.GONE);
                sub9.setVisibility(View.GONE);
                t9.setVisibility(View.GONE);

            }
        }
        //sub1.startAnimation((Animation) AnimationUtils.loadAnimation(getContext(),R.anim.textscroll));
        int size = temp.length;
        grget= new String[size];
        score = new int[size];

       /* sub1.setText(temp[0]);
        acsub1.setAdapter(grade);
        sub2.setText(temp[1]);
        acsub2.setAdapter(grade);
        sub3.setText(temp[2]);
        acsub3.setAdapter(grade);
        sub4.setText(temp[3]);
        acsub4.setAdapter(grade);
        sub5.setText(temp[4]);
        acsub5.setAdapter(grade);
        sub6.setText(temp[5]);
        acsub6.setAdapter(grade);
        sub7.setText(temp[6]);
        acsub7.setAdapter(grade);
        sub8.setText(temp[7]);
        acsub8.setAdapter(grade);
        sub9.setText(temp[8]);
        acsub9.setAdapter(grade);*/
grader = new Character[temp.length];
acsub1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        one = grade.getItem(i);
        String s = String.valueOf(one);
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        grget[0] = s;
        a = 0;
        int b = credit(a);
        s= String.valueOf(b);
        //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();

    }
});
        acsub2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
                //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[1]=s;
                a = 1;
                int b = credit(a);

            }
        });
        acsub3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
                //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[2]=s;
                a = 2;
                int b = credit(a);

            }
        });
        acsub4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
                //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[3]=s;
                a = 3;
                int b = credit(a);

            }
        });
        acsub5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
                //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[4]=s;
                a = 4;
                int b = credit(a);

            }
        });
        acsub6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
                //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[5]=s;
                a = 5;
                int b = credit(a);

            }
        });
        acsub7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
                //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[6]=s;
                a = 6;
                int b = credit(a);

            }
        });
        acsub8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
               // Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[7]=s;
                a = 7;
                int b = credit(a);

            }
        });
        acsub9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                one = grade.getItem(i);
                String s = String.valueOf(one);
                //Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
                grget[8]=s;
                a = 8;
                int b = credit(a);

            }
        });

        gpacal.setOnClickListener(view -> {
            float gpaNUM = 0;
            float gpaDEN = 0;
            float GPA = 0;
            //var end
            for (int i = 0; i < size; i++)
            {
                gpaNUM = CP[i] * score[i] + gpaNUM;
                gpaDEN = CP[i] + gpaDEN;
            }
            GPA = gpaNUM / gpaDEN;


                Bundle bundl = new Bundle();
                bundl.putFloat("gpa",GPA);
                bundl.putString("sem",sem);
                bundl.putString("dept",dept);
                gpa_result gpar = new gpa_result();
            gpar.setArguments(bundl);
                getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out).replace(R.id.fragment_container,gpar).commit();

        });


        return v;
    }
















   private int credit(int a)
   {
       switch (grget[a]) {
           case "S":
               score[a] = 10;
               break;
           case "A":
               score[a] = 9;
               break;
           case "B":
               score[a] = 8;
               break;
           case "C":
               score[a] = 7;
               break;
           case "D":
               score[a] = 6;
               break;
           case "E":
               score[a] = 5;
               break;
           case "F":
               score[a] = 0;
               break;
           case "P":
               score[a] = 0;
               break;
       }
       return score[a];
   }





    private void extracteddata() {
        grades = new Character[]{'S','A','B','C','D','E','F','P'};
        CPCSE1 = new float[] { 4.0f, 4.0f, 4.0f, 3.0f, 3.0f, 1.5f, 1.5f, 1.5f};
        CPCSE2 = new float[] { 4.0f, 4f, 3.0f, 3f, 0f, 1.5f, 1.5f };
        CPCSE3 = new float[] { 2f, 3f, 4f, 3f, 3f, 1.5f, 1.5f, 1.5f, 0 };
        CPCSE4 = new float[] { 4f, 3f, 3f, 3f, 4f, 1.5f, 1.5f, 1.5f };
        CPCSE5 = new float[] { 3f, 3f, 3f, 4f, 3f, 1.5f, 1.5f, 0f };
        CPCSE6 = new float[] { 2f, 3f, 3f, 4f, 3f, 3f, 1.5f, 1.5f };
        CPCSE7 = new float[] { 3f, 4f, 4f, 3f, 3f, 1.5f, 1f, 0f };
        CPCSE8 = new float[] { 2f, 2f, 1f, 2f, 8f };

        CSE1 = new String[] { "MA201 Mathematics", "PH201 Physics", "CY201 Chemistry", "HS201 English for Communication", "ME201 Workshop and Manufacturing Practice", "PH202 Physics Laboratory", "CY202 Chemistry Laboratory" };
        CSE2 = new String[] { "MA202 Mathematics II", "EE201 Basic Electrical Engineering", "CS201 Programming for Problem Solving", "ME202 Engineering Graphics and Computer Aided Drawing", "CE201 Environmental Science", "EE202 Basic Electrical Engineering Laboratory", "CS202 Programming Laboratory" };
        CSE3 = new String[] { "SH201 Biology for Engineers", "EC235 Electronic Devices and Digital Systems", "CS203 Computer Organization and Architecture", "CS204 Data Structures", "CS205 Object Oriented Programming Languages", "EC236 Electronic Devices and Digital Systems Laboratory", "CS206 Data Structures Laboratory", "CS207 Object Oriented Programming Languages Laboratory", "SH202 Indian Constitution" };
        CSE4 = new String[] { "MA206 Mathematics for Computing", "CS208 Operating Systems", "CS209 Design and Analysis of Algorithms", "CS210 Database Management Systems", "CS211 Software Engineering", "CS212 Operating System Laboratory", "CS213 Design and Analysis of Algorithms Laboratory", "CS214 Database Management Systems Laboratory" };
        CSE5 = new String[] { "HS202 Industrial Economics and Management", "CS215 Platform Technologies", "CS216 Computer Networks", "CS217 Automata Theory and Compiler Design", "CSYXX Professional Elective Course - I", "CS218 Platform Technologies Laboratory", "CS219 Computer Networks Laboratory", "SH203 Essence of Indian Traditional Knowledge" };
        CSE6 = new String[] { "P201 Entrepreneurship", "CS220 Microprocessors and Microcontrollers", "CS221 Web Technologies", "CS222 Information Security", "CSYXX Professional Elective Course – II", "CSYXX Professional Elective Course – III", "CS223 Microprocessors and Microcontrollers Laboratory", " CS224 Web Technologies Laboratory" };
        CSE7 = new String[] { "CS225 Artificial Intelligence", "CS226 Parallel and Distributed", "CS227 Data Science Essentials", "CSYXX Professional Elective Co", "CSYXX Professional Elective Co", "CS228 Artificial Intelligence Lab", "CS229 Seminar", "CS230 Professional Ethics" };
        CSE8 = new String[] { "SWOXX Open Elective through SWAYAM ","WOXX Open Elective through SWAYAM","CS231 Comprehensive Test","CS232 Internship","CS233 Project Work PAC PR "};
    }
}