package com.robin.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import org.mariuszgromada.math.mxparser.*;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CalcFragment extends Fragment {
    String input;
    public int len;
    int check=0;
    Button bc;
    Button b7;
    Button b4;
    Button b1 ;
    Button b00;
    Button bmod;
    Button b8;
    Button b5;
    Button b2;
    Button b0;
    Button bs;
    Button b9;
    Button b6;
    Button b3;
    Button bdot;
    Button div;
    Button mul;
    Button sub;
    Button add;
    Button equ;
    EditText in;
    EditText res;
    String s;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calc, container, false);
        bc=v.findViewById(R.id.clear);
        b7=v.findViewById(R.id.but7);
        b4=v.findViewById(R.id.but4);
        b1=v.findViewById(R.id.but1);
        b00=v.findViewById(R.id.but00);
        bmod=v.findViewById(R.id.butmod);
        b8=v.findViewById(R.id.but8);
        b5=v.findViewById(R.id.but5);
        b2=v.findViewById(R.id.but2);
        b0=v.findViewById(R.id.but0);
        bs=v.findViewById(R.id.backspace);
        b9=v.findViewById(R.id.but9);
        b6=v.findViewById(R.id.but6);
        b3=v.findViewById(R.id.but3);
        bdot=v.findViewById(R.id.butdot);
        div=v.findViewById(R.id.div);
        mul=v.findViewById(R.id.mul);
        sub=v.findViewById(R.id.sub);
        add=v.findViewById(R.id.add);
        equ=v.findViewById(R.id.equal);
        in=v.findViewById(R.id.enter);
        res=v.findViewById(R.id.res);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString();
                len=input.length();
                if(len>0)
                {
                    in.setText(input.substring(0,len-1));
                    result(in.getText().toString());
                    String find = in.getText().toString();
                    len=find.length();
                    String find2=find.substring(len);
                    /*if(find2.equals("+")||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('=')||find2.equals('%'))
                    {

                    }*/
                }
                else res.setText(null);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"1";
                in.setText(input);
                result(input);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"2";
                in.setText(input);
                result(input);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"3";
                in.setText(input);
                result(input);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"4";
                in.setText(input);
                result(input);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"5";
                in.setText(input);
                result(input);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"6";
                in.setText(input);
                result(input);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"7";
                in.setText(input);
                result(input);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"8";
                in.setText(input);
                result(input);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"9";
                in.setText(input);
                result(input);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"0";
                in.setText(input);
                result(input);
            }
        });
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"00";
                in.setText(input);
                result(input);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"+";
                check+=check;
                in.setText(input);
                result(input);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"-";
                check+=check;
                in.setText(input);
                result(input);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"*";
                check+=check;
                in.setText(input);
                result(input);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"/";
                check+=check;
                in.setText(input);
                result(input);
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+".";
                check+=check;
                in.setText(input);
                result(input);
            }
        });
        bmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=in.getText().toString()+"!";
                check+=check;
                in.setText(input);
                result(input);
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.setText(null);
                check=0;
            }
        });
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=res.getText().toString();
                in.setText(s);
                res.setText(null);
                check=0;
            }
        });




        return v;
    }
    public void result(String input) {
        Expression exp = new Expression(input);
        s = String.valueOf(exp.calculate());
        len=input.length();
        if(len>1)
            res.setText(s);
        else
            res.setText(null);
        //in.setText(s);
        if (res.getText().toString().equals("NaN"))
        {
            res.setText(null);
        }

    }
    @Override
        public void onPause() {
            Intent i = new Intent(this.getContext(),MainActivity.class);
            Log.e("Tag","Pause");
            //startActivity(i);
            super.onPause();


    }
    @Override
    public void onDetach() {
        Intent intent = new Intent(this.getContext(),MainActivity.class);
        Log.e("Tag","DetachCalc");
        //startActivity(intent);
        super.onDetach();
    }
}