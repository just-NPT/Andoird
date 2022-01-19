package com.example.prj1.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.prj1.R;


import org.w3c.dom.Text;

public class ScienceFragment extends Fragment {
    //FragmentScienceBinding binding;

    String so_pi = "3.1415926535897932384626433832795";
    String euler_num = "2.7182818284590452353602874713527";
    String op;
    boolean flag = true;
    public String input ;
    private TextView SCResult ,SCCalculation;
    private Button Trigo,Func;
    boolean hypFlag = false,secFlag = false,secSCFlag = false;
    Button it_sin,it_cos,it_tan,it_csc,it_sec,it_cot;
    Button Ln,SCLog,SCCan2,SCxMuY,SCSquare,muoiMu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //binding = FragmentScienceBinding.inflate(getLayoutInflater());
        //return binding.getRoot();


        return inflater.inflate(R.layout.fragment_science, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button SCZero = view.findViewById(R.id.SC_zero);
        Button SCOne = view.findViewById(R.id.SC_One);
        Button SCTwo = view.findViewById(R.id.SC_Two);
        Button SCThree = view.findViewById(R.id.SC_Three);
        Button SCFour = view.findViewById(R.id.SC_Four);
        Button SCFive = view.findViewById(R.id.SC_Five);
        Button SCSix = view.findViewById(R.id.SC_Six);
        Button SCSeven = view.findViewById(R.id.SC_Seven);
        Button SCEight = view.findViewById(R.id.SC_Eight);
        Button SCNine = view.findViewById(R.id.SC_Nine);
        Button SCPlus = view.findViewById(R.id.SC_Plus);
        Button SCMinus = view.findViewById(R.id.SC_Minus);
        Button SCMulti = view.findViewById(R.id.SC_Multi);
        Button SCDiv = view.findViewById(R.id.SC_Div);
        Button SCDot = view.findViewById(R.id.SC_Dot);
        Button SCFraction = view.findViewById(R.id.SC_Fraction);
        Button SCNFactorial = view.findViewById(R.id.SC_n_factorial);
        Button SCChangeOP = view.findViewById(R.id.SC_changeOp);
        Ln = view.findViewById(R.id.Ln);
        SCLog = view.findViewById(R.id.SC_Log);
        Button SCLPar = view.findViewById(R.id.SC_L_par);
        Button SCRPar = view.findViewById(R.id.SC_R_par);
        Button SCClearEntryBTN = view.findViewById(R.id.SC_Clear_EntryBTN);
        SCCan2 = view.findViewById(R.id.SC_can_2);
        Button SCMod = view.findViewById(R.id.SC_Mod);
        SCxMuY = view .findViewById(R.id.x_mu_y);
        muoiMu = view.findViewById(R.id.muoi_mu);
        Button SCAbs = view.findViewById(R.id.SC_abs);
        Button pi = view.findViewById(R.id.pi);
        Button e = view.findViewById(R.id.e);
        SCSquare = view.findViewById(R.id.SC_square);
        Button SCEXP = view.findViewById(R.id.SC_EXP);
        Button SCEqual = view.findViewById(R.id.SC_equal);
        Button Second =view.findViewById(R.id.second);
        ImageButton SCBackspace = view.findViewById(R.id.SC_backspace);
        Trigo = view.findViewById(R.id.trigo);
        Func = view.findViewById(R.id.function);

        SCResult = (TextView) view.findViewById(R.id.SC_result);
        SCCalculation =(TextView) view.findViewById(R.id.SC_calculation);

        SCOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("1");
            }
        });

        SCTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("2");
            }
        });

        SCThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("3");
            }
        });

        SCFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("4");
            }
        });

        SCFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("5");
            }
        });

        SCSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("6");
            }
        });

        SCSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("7");
            }
        });

        SCEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("8");
            }
        });

        SCNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("9");
            }
        });

        SCZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("0");
            }
        });

        SCDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput(".");
            }
        });

        Trigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogTrigo();
            }
        });

        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secSCFlag = !secSCFlag;
                changeSec();
            }
        });

        SCEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SCCalculation.getText().length() == 0){
                    SCCalculation.setText(SCResult.getText());
                    String s = SCCalculation.getText().toString();
                        double d = eval(s);
                        input = deleteZeroTail(d);
                        SCResult.setText(input);
                        SCCalculation.setText(s + "=");
                        flag = true;
                }else{
                    String s = SCCalculation.getText().toString();
                    if (s.charAt(s.length() - 1) == ')') {
                        double d = eval(s);
                        input = deleteZeroTail(d);
                        SCResult.setText(input);
                        SCCalculation.setText(s + "=");
                        flag = true;
                    } else {
                        s += SCResult.getText().toString();
                        double d = eval(s);
                        input = deleteZeroTail(d);
                        SCResult.setText(input);
                        SCCalculation.setText(s + "=");
                        flag = true;
                    }
                }
            }
        });

        SCPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    SCCalculation.setText(SCResult.getText().toString()+"+");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        SCCalculation.setText(input + "+");
                    }else if(s.charAt(s.length()-1) == ')'){
                        double d = eval(s);
                        SCCalculation.setText(s+"+");
                        SCResult.setText(deleteZeroTail(d));
                    }else {
                        String temp = SCResult.getText().toString();
                        s += temp;
                        double d = eval(s);
                        SCCalculation.setText(s+"+");
                        SCResult.setText(deleteZeroTail(d));
                    }
                }
                flag = true;
            }
        });

        SCMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    SCCalculation.setText(SCResult.getText().toString()+"-");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        SCCalculation.setText(input + "-");
                    }else if(s.charAt(s.length()-1) == ')'){
                        double d = eval(s);
                        SCCalculation.setText(s+"-");
                        SCResult.setText(deleteZeroTail(d));
                    }else {
                        String temp = SCResult.getText().toString();
                        s += temp;
                        double d = eval(s);
                        SCCalculation.setText(s+"-");
                        SCResult.setText(deleteZeroTail(d));
                    }
                }
                flag = true;
            }
        });

        SCMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    SCCalculation.setText(SCResult.getText().toString()+"*");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        SCCalculation.setText(input+"*");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            double d = eval(temp);
                            SCResult.setText(deleteZeroTail(d));
                        }else{
                            double d = eval(s);
                            SCResult.setText(deleteZeroTail(d));
                        }
                        SCCalculation.setText(s + "*");
                    }else{
                        s += SCResult.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            double d = eval(temp);
                            SCResult.setText(deleteZeroTail(d));
                        }else{
                            double d = eval(s);
                            SCResult.setText(deleteZeroTail(d));
                        }
                        SCCalculation.setText(s + "*");
                    }
                }
                flag = true;
            }
        });
        SCDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    SCCalculation.setText(SCResult.getText().toString()+"/");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        SCCalculation.setText(input+"/");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            double d = eval(temp);
                            SCResult.setText(deleteZeroTail(d));
                        }else{
                            double d = eval(s);
                            SCResult.setText(deleteZeroTail(d));
                        }
                        SCCalculation.setText(s + "/");
                    }else{
                        s += SCResult.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            double d = eval(temp);
                            SCResult.setText(deleteZeroTail(d));
                        }else{
                            double d = eval(s);
                            SCResult.setText(deleteZeroTail(d));
                        }
                        SCCalculation.setText(s + "/");
                    }
                }
                flag = true;
            }
        });

        SCChangeOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if (s.equals("")) {
                    s = "negate(" + SCResult.getText().toString() + ")";
                    SCCalculation.setText(s);
                    double d = Math.log10(Double.parseDouble(SCResult.getText().toString()));
                    input = s;
                    SCResult.setText(deleteZeroTail(d));
                } else {
                    if (s.lastIndexOf("=") > 0) {
                        s = "negate(" + input + ")";
                        input = s;
                    } else if (s.charAt(s.length() - 1) != ')') {
                        String temp = "negate(" + SCResult.getText().toString() + ")";
                        s += temp;
                        input = temp;
                    } else {
                        s = s.substring(0, s.length() - input.length());
                        s += "negate(" + input + ")";
                        input = "negate(" + input + ")";
                    }
                    SCCalculation.setText(s);
                    SCResult.setText(deleteZeroTail(eval(input)));
                }
                flag = true;
            }
        });

        SCxMuY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    SCCalculation.setText(SCResult.getText().toString()+"^");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        SCCalculation.setText(input+"^");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            double d = eval(temp);
                            SCResult.setText(deleteZeroTail(d));
                        }else{
                            double d = eval(s);
                            SCResult.setText(deleteZeroTail(d));
                        }
                        SCCalculation.setText(s + "^");
                    }else{
                        s += SCResult.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            double d = eval(temp);
                            SCResult.setText(deleteZeroTail(d));
                        }else{
                            double d = eval(s);
                            SCResult.setText(deleteZeroTail(d));
                        }
                        SCCalculation.setText(s + "^");
                    }
                }
                flag = true;
            }
        });

        SCLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secSCFlag){
                    String s = SCCalculation.getText().toString();
                    if (s.equals("")) {
                        s = "log(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = Math.log10(Double.parseDouble(SCResult.getText().toString()));
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "log(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "log(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "log(" + input + ")";
                            input = "log(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                }else {
                    String s = SCCalculation.getText().toString();
                    if (s.equals("")) {
                        s = "log(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = Math.log10(Double.parseDouble(SCResult.getText().toString()));
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "log(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "log(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "log(" + input + ")";
                            input = "log(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                    secSCFlag = false;
                    changeSec();
                }
            }
        });

        SCAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    s = "abs(" + SCResult.getText().toString() +")";
                    SCCalculation.setText(s);
                    double d = Math.abs(Double.parseDouble(SCResult.getText().toString()));
                    input = s;
                    SCResult.setText(deleteZeroTail(d));
                }else {
                    if (s.lastIndexOf("=") > 0) {
                        s = "abs(" + input + ")";
                        input = s;
                    } else if (s.charAt(s.length() - 1) != ')') {
                        String temp = " abs("+ SCResult.getText().toString() + ")";
                        s += temp;
                        input = temp;
                    } else {
                        s = s.substring(0, s.length() - input.length());
                        s += "abs(" + input + ")";
                        input = "abs(" + input + ")";
                    }
                    SCCalculation.setText(s);
                    SCResult.setText(deleteZeroTail(eval(input)));
                }
                flag = true;
            }
        });

        SCNFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    s = "fac(" + SCResult.getText().toString() +")";
                    SCCalculation.setText(s);
                    double d = eval(s);
                    input = s;
                    SCResult.setText(deleteZeroTail(d));
                }else {
                    if (s.lastIndexOf("=") > 0) {
                        s = "fac(" + input + ")";
                        input = s;
                    } else if (s.charAt(s.length() - 1) != ')') {
                        String temp = "fac(" +SCResult.getText().toString() + ")";
                        s += temp;
                        input = temp;
                    } else {
                        s = s.substring(0, s.length() - input.length());
                        input = "fac(" + input + ")";
                        s +=  input;
                    }
                    SCCalculation.setText(s);
                    SCResult.setText(deleteZeroTail(eval(input)));
                }
                flag = true;
            }
        });

        Ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secSCFlag){
                    String s = SCCalculation.getText().toString();
                    if (s.equals("")) {
                        s = "ln(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "ln(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "ln(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "ln(" + input + ")";
                            input = "ln(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                }else{
                    String s = SCCalculation.getText().toString();
                    if (s.equals("")) {
                        s = "e^(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "e^(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "e^(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "e^(" + input + ")";
                            input = "e^(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                    secSCFlag = false;
                    changeTrigoSec();
                }
            }
        });

        muoiMu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secSCFlag){
                    String s = SCCalculation.getText().toString();
                    if (s.equals("")) {
                        s = "10^(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "10^(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "10^(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "10^(" + input + ")";
                            input = "10^(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                }else{
                    String s = SCCalculation.getText().toString();
                    if (s.equals("")) {
                        s = "2^(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "2^(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "2^(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "2^(" + input + ")";
                            input = "2^(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                    secSCFlag = false;
                    changeSec();
                }
            }
        });

        SCCan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(!secSCFlag){
                    if (s.equals("")) {
                        s = "sqrt(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "sqrt(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "sqrt(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "sqrt(" + input + ")";
                            input = "sqrt(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                }else{
                    if (s.equals("")) {
                        s = "cuberoot(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "cuberoot(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "cuberoot(" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "cuberoot(" + input + ")";
                            input = "cuberoot(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                    secSCFlag = false;
                    changeSec();
                }
            }
        });

        SCSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(!secSCFlag){
                    if (s.equals("")) {
                        s = "sqr(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "sqr(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "sqr" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "sqr(" + input + ")";
                            input = "sqr(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                }else{
                    if (s.equals("")) {
                        s = "cube(" + SCResult.getText().toString() + ")";
                        SCCalculation.setText(s);
                        double d = eval(s);
                        input = s;
                        SCResult.setText(deleteZeroTail(d));
                    } else {
                        if (s.lastIndexOf("=") > 0) {
                            s = "cube(" + input + ")";
                            input = s;
                        } else if (s.charAt(s.length() - 1) != ')') {
                            String temp = "cube" + SCResult.getText().toString() + ")";
                            s += temp;
                            input = temp;
                        } else {
                            s = s.substring(0, s.length() - input.length());
                            s += "cube(" + input + ")";
                            input = "cube(" + input + ")";
                        }
                        SCCalculation.setText(s);
                        SCResult.setText(deleteZeroTail(eval(input)));
                    }
                    flag = true;
                    secSCFlag = false;
                    changeSec();
                }
            }
        });

        SCFraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.equals("")){
                    s = "1/(" + SCResult.getText().toString() +")";
                    SCCalculation.setText(s);
                    double d = eval(SCResult.getText().toString());
                    input = s;
                    SCResult.setText(deleteZeroTail(d));
                }else {
                    if (s.lastIndexOf("=") > 0) {
                        s = "1/(" + input + ")";
                        input = s;
                    } else if (s.charAt(s.length() - 1) != ')') {
                        String temp ="1/(" + SCResult.getText().toString() + ")";
                        s += temp;
                        input = temp;
                    } else {
                        s = s.substring(0, s.length() - input.length());
                        s += "1/(" + input + ")";
                        input = "1/(" + input + ")";
                    }
                    SCCalculation.setText(s);
                    SCResult.setText(deleteZeroTail(eval(input)));
                }
                flag = true;
            }
        });

        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SCResult.setText(so_pi);
                flag = true;
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SCResult.setText(euler_num);
                flag = true;
            }
        });

        SCEXP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                String temp = SCResult.getText().toString();
                temp = temp + "*10^";
                SCResult.setText(temp);
            }
        });

        SCMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(s.charAt(s.length()-1) == '='){
                    s = input ;
                }else if(s.charAt(s.length()-1) == ')'){
                    if(s.contains("+")||s.contains("-")) {
                        int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                        String temp = s.substring(i + 1);
                        double d = eval(temp);
                        SCResult.setText(deleteZeroTail(d));
                    }else{
                        double d = eval(s);
                        SCResult.setText(deleteZeroTail(d));
                    }
                    SCCalculation.setText(s + "%");
                }else{
                    s += SCResult.getText().toString();
                    if(s.contains("+")||s.contains("-")){
                        int i = Math.max(s.lastIndexOf("+"),s.lastIndexOf("-"));
                        String temp = s.substring(i+1);
                        double d = eval(temp);
                        SCResult.setText(deleteZeroTail(d));
                    }else{
                        Double d = eval(s);
                        SCResult.setText(deleteZeroTail(d));
                    }
                }
                SCCalculation.setText(s+"%");
                flag = true;
            }
        });

        SCClearEntryBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SCResult.getText().toString().equals("") || SCCalculation.getText().toString().endsWith("=")){
                    SCCalculation.setText("");
                    input = "";
                }else{
                    SCResult.setText("");
                }
            }
        });

        SCBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = SCResult.getText().toString();
                if(temp.equals("")||temp.length() == 1){
                    SCResult.setText("0");
                }else{
                    SCResult.setText(temp.substring(0,temp.length()-1));
                }
            }
        });

        SCLPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                s += "(";
                SCCalculation.setText(s);
            }
        });

        SCRPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(checkPar(s) > 0){
                    s += ")";
                    SCCalculation.setText(s);
                    updateInput();
                }
            }
        });
    }

    private void changeSec() {
        if(secSCFlag){
            SCCan2.setText(R.string.cuberoot);
            SCSquare.setText(R.string.cube);
            SCxMuY.setText(R.string.xCanY);
            muoiMu.setText(R.string.haiMu);
            SCLog.setText(R.string.logY);
            Ln.setText(R.string.eMu);
        }else{
            SCCan2.setText(R.string.root);
            SCSquare.setText(R.string.square);
            SCxMuY.setText(R.string.xMuY);
            muoiMu.setText(R.string.muoiMu);
            SCLog.setText(R.string.log);
            Ln.setText(R.string.ln);
        }

    }

    private void showDialogTrigo() {
        Dialog dialog = new Dialog(this.getActivity(),
                android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_trigo_layout);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.x = 0; lp.y = 550 ;
        lp.gravity = Gravity.TOP|Gravity.LEFT;

        dialog.getWindow().setAttributes(lp);
        dialog.setCancelable(true);

        it_sin = dialog.findViewById(R.id.it_sin);
        it_cos = dialog.findViewById(R.id.it_cos);
        it_tan = dialog.findViewById(R.id.it_tan);
        it_csc = dialog.findViewById(R.id.it_csc);
        it_cot = dialog.findViewById(R.id.it_cot);
        it_sec = dialog.findViewById(R.id.it_sec);
        Button it_2nd = dialog.findViewById(R.id.it_second);
        Button it_hyp = dialog.findViewById(R.id.it_hyp);

        it_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secFlag){
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "sin(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "sin(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "sin(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "sin(" + input + ")";
                                input = "sin(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "sinh(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "sinh(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "sinh(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "sinh(" + input + ")";
                                input = "sinh(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }else{
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arcsin(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arcsin(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arcsin(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arcsin(" + input + ")";
                                input = "arcsin(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        changeTrigoSec();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arcsinh(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arcsinh(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arcsinh(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arcsinh(" + input + ")";
                                input = "arcsinh(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }
            }
        });

        it_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secFlag){
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "cos(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "cos(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "cos(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "cos(" + input + ")";
                                input = "cos(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                    }else {
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "cosh(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "cosh(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "cosh(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "cosh(" + input + ")";
                                input = "cosh(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }else{
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arccos(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arccos(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arccos(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arccos(" + input + ")";
                                input = "arccos(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        changeTrigoSec();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arccosh(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arccosh(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arccosh(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arccosh(" + input + ")";
                                input = "arccosh(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                        secFlag = false;
                        changeTrigoSec();
                    }
                }
            }
        });

        it_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secFlag){
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "tan(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "tan(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "tan(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "tan(" + input + ")";
                                input = "tan(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "tanh(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "tanh(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "tanh(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "tanh(" + input + ")";
                                input = "tanh(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }else{
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arctan(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arctan(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arctan(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arctan(" + input + ")";
                                input = "arctan(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        changeTrigoSec();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arctanh(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arctanh(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arctanh(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arctanh(" + input + ")";
                                input = "arctanh(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }
            }
        });

        it_cot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secFlag){
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "cot(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "cot(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "cot(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "cot(" + input + ")";
                                input = "cot(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "coth(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "coth(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "coth(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "coth(" + input + ")";
                                input = "coth(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }else{
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arccot(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arccot(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arccot(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arccot(" + input + ")";
                                input = "arccot(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        changeTrigoSec();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arccoth(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arccoth(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arccoth(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arccoth(" + input + ")";
                                input = "arccoth(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }
            }
        });

        it_csc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = SCCalculation.getText().toString();
                if(!secFlag){
                    if(!hypFlag){
                        if (s.equals("")) {
                            s = "csc(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "csc(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "csc(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "csc(" + input + ")";
                                input = "csc(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                    }else{
                        if (s.equals("")) {
                            s = "csch(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "csch(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "csch(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "csch(" + input + ")";
                                input = "csch(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                        changeTrigoSec();
                    }
                }else{
                    if(!hypFlag){
                        if (s.equals("")) {
                            s = "arccsc(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arccsc(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arccsc(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arccsc(" + input + ")";
                                input = "arccsc(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(deleteZeroTail(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                        changeTrigoSec();
                    }else{
                        if (s.equals("")) {
                            s = "arccsch(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(deleteZeroTail(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arccsch(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arccsch(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arccsch(" + input + ")";
                                input = "arccsch(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(Double.toString(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                    }
                }
            }
        });

        it_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!secFlag){
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "sec(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(Double.toString(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "sec(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "sec(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "sec(" + input + ")";
                                input = "sec(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(Double.toString(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "sech(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(Double.toString(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "sech(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "sech(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "sech(" + input + ")";
                                input = "sech(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(Double.toString(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                    }
                }else{
                    if(!hypFlag){
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arcsec(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(Double.toString(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arcsec(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arcsec(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arcsec(" + input + ")";
                                input = "arcsec(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(Double.toString(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        secFlag = false;
                    }else{
                        String s = SCCalculation.getText().toString();
                        if (s.equals("")) {
                            s = "arcsech(" + SCResult.getText().toString() + ")";
                            SCCalculation.setText(s);
                            double d = eval(s);
                            input = s;
                            SCResult.setText(Double.toString(d));
                        } else {
                            if (s.lastIndexOf("=") > 0) {
                                s = "arcsech(" + input + ")";
                                input = s;
                            } else if (s.charAt(s.length() - 1) != ')') {
                                String temp = "arcsech(" + SCResult.getText().toString() + ")";
                                s += temp;
                                input = temp;
                            } else {
                                s = s.substring(0, s.length() - input.length());
                                s += "arcsech(" + input + ")";
                                input = "arcsech(" + input + ")";
                            }
                            SCCalculation.setText(s);
                            SCResult.setText(Double.toString(eval(input)));
                        }
                        flag = true;
                        dialog.dismiss();
                        hypFlag = false;
                        secFlag = false;
                    }
                }
            }
        });

        it_2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secFlag = !secFlag;
                changeTrigoSec();
            }
        });

        it_hyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hypFlag = !hypFlag;
                changeTrigoSec();
            }
        });
        dialog.show();
    }

    public void changeTrigoSec(){
        if(secFlag){
            if(hypFlag){
                it_sec.setText(R.string.arcsech);
                it_cos.setText(R.string.arccosh);
                it_sin.setText(R.string.arcsinh);
                it_tan.setText(R.string.arctanh);
                it_csc.setText(R.string.arccsch);
                it_cot.setText(R.string.arccoth);
            }else{
                it_sec.setText(R.string.arcsec);
                it_cos.setText(R.string.arccos);
                it_sin.setText(R.string.arcsin);
                it_tan.setText(R.string.arctan);
                it_csc.setText(R.string.arccsc);
                it_cot.setText(R.string.arccot);
            }
        }else{
            if(hypFlag){
                it_sec.setText(R.string.sech);
                it_cos.setText(R.string.cosh);
                it_sin.setText(R.string.sinh);
                it_tan.setText(R.string.tanh);
                it_csc.setText(R.string.csch);
                it_cot.setText(R.string.coth);
            }else{
                it_sec.setText(R.string.sec);
                it_cos.setText(R.string.cos);
                it_sin.setText(R.string.sin);
                it_tan.setText(R.string.tan);
                it_csc.setText(R.string.csc);
                it_cot.setText(R.string.cot);
            }
        }
    }

    public static long factorial(long n){
        return ( n == 1 || n == 0) ? 1 : n * factorial(n-1);
    }

    public void updateInput(){
        String s = SCCalculation.getText().toString();
        if(s.charAt(s.length()-1) == ')'){
            int n = checkPar(s);
            int i;
            int cnt = 0;
            for(i=0;i<s.length();i++){
                if(s.charAt(i) == '(') cnt++;
                if(cnt == n+1) break;
            }
            input = s.substring(i);
            double d = eval(input);
            SCResult.setText(Double.toString(d));
        }else{
            throw new RuntimeException("??????");
        }
    }

    public void NumInput(String s){
        if(SCResult.getText().toString().equals("0") || flag ){
            SCResult.setText(s);
            flag = false;
            input = s;
        }else if(s.equals(".")){
            if(!SCResult.getText().toString().contains(".")) {
                SCResult.setText(SCResult.getText().toString() + s);
                input = SCResult.getText().toString();
            }
        }else{
            SCResult.setText(SCResult.getText().toString()+s);
            input += s;
        }
    }
    public int checkPar(String s){
        int closePar = 0,openPar = 0;
        for(int i = 0;i<s.length();++i){
            if(s.charAt(i) == ')'){
                closePar ++;
            }
            if(s.charAt(i) == '('){
                openPar ++;
            }
        }
        return openPar - closePar;
    }

    private String deleteZeroTail(double d){
        String s = Double.toString(d);
        if(s.charAt(s.length()-1) == '0'){
            if(s.charAt(s.length()-2) == '.'){
                s = s.substring(0,s.length()-2);
            }
        }
        return s;
    }

    private void solve() {
        String temp = SCCalculation.getText().toString();
        double d = eval(temp);
        input = Double.toString(d);
    }

    //evaluate function
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else if (eat('%')) x %= parseFactor(); // mod
                    else if (eat('^')) x = Math.pow(x, parseFactor());
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x = 0;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if (eat('e')){
                    x = Math.E;
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("abs")) x = Math.abs(x);
                    else if (func.equals("sqr")) x = Math.pow(x,2);
                    else if (func.equals("10^")) x = Math.pow(10,x);
                    else if (func.equals("fac")) x = (double)factorial((long)x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("sinh")) x = Math.sinh(Math.toRadians(x));
                    else if (func.equals("arcsin")) x = Math.asin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("cosh")) x = Math.cosh(Math.toRadians(x));
                    else if (func.equals("arccos")) x = Math.acos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("tanh")) x = Math.tanh(Math.toRadians(x));
                    else if (func.equals("arctan")) x = Math.atan(Math.toRadians(x));
                    else if (func.equals("cot")) x = 1/(Math.tan(Math.toRadians(x)));
                    else if (func.equals("sec")) x = 1/Math.cos(Math.toRadians(x));
                    else if (func.equals("csc")) x = 1/Math.sin(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else if (func.equals("cube")) x = Math.pow(x,3);
                    else if (func.equals("cuberoot")) x = Math.cbrt(x);
                    else if (func.equals("negate")) x = -x;

                    else throw new RuntimeException("Unknown function: " + func);
                } else throw new RuntimeException("Unexpected: " + (char)ch);

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}