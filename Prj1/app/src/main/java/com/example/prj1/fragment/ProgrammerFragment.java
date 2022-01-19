package com.example.prj1.fragment;

import android.app.Dialog;
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

import java.util.HashMap;

public class ProgrammerFragment extends Fragment {
    TextView Calculation,Result;
    boolean flag = true ;
    TextView DEC,HEX,BIN,OCT;
    TextView DECtext,HEXtext,BINtext,OCTtext;
    long heSo = 10;
    Button btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnA,btnB,btnC,btnD,btnE,btnF;
    Button btnChange;
    String input = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programmer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnZero = view.findViewById(R.id.it_btnZero);
        btnOne = view.findViewById(R.id.it_btnOne);
        btnTwo = view.findViewById(R.id.it_btnTwo);
        btnThree = view.findViewById(R.id.it_btnThree);
        btnFour = view.findViewById(R.id.it_btnFour);
        btnFive = view.findViewById(R.id.it_btnFive);
        btnSix = view.findViewById(R.id.it_btnSix);
        btnSeven = view.findViewById(R.id.it_btnSeven);
        btnEight = view.findViewById(R.id.it_btnEight);
        btnNine = view.findViewById(R.id.it_btnNine);
        btnA =view.findViewById(R.id.it_btnA);
        btnD =view.findViewById(R.id.it_btnD);
        btnC =view.findViewById(R.id.it_btnC);
        btnE =view.findViewById(R.id.it_btnE);
        btnF =view.findViewById(R.id.it_btnF);
        btnB =view.findViewById(R.id.it_btnB);

        Button btnEqual = view.findViewById(R.id.it_btnEqual);
        ImageButton btnMulti = view.findViewById(R.id.it_btnMulti);
        ImageButton btnDiv = view.findViewById(R.id.it_btnDiv);
        Button btnPlus = view.findViewById(R.id.it_btnPlus);
        Button btnMinus = view.findViewById(R.id.it_btnMinus);
        ImageButton btnBackspace = view.findViewById(R.id.it_btnbackspace);
        Button btnCE = view.findViewById(R.id.it_btnCE);
        Button btnChangeOP = view.findViewById(R.id.it_btnChangeOP);
        Button btnRpar = view.findViewById(R.id.it_btnRpar);
        Button btnLpar = view.findViewById(R.id.it_btnLpar);
        Button btnRshift = view.findViewById(R.id.it_btnRshift);
        Button btnLshift = view.findViewById(R.id.it_btnLshift);
        Button btnMod = view.findViewById(R.id.it_btnMod);
        btnChange = view.findViewById(R.id.it_change);

        Calculation = view.findViewById(R.id.it_calculation);
        Result = view.findViewById(R.id.it_result);
        DEC = view.findViewById(R.id.DEC);
        BIN = view.findViewById(R.id.BIN);
        HEX = view.findViewById(R.id.HEX);
        OCT = view.findViewById(R.id.OCT);
        DECtext = view.findViewById(R.id.DexText);
        OCTtext = view.findViewById(R.id.OctText);
        BINtext = view.findViewById(R.id.BinText);
        HEXtext = view.findViewById(R.id.HexText);


        if(Result == null) Result.setText("0");

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("6");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("9");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("7");
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("A");
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("B");
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("C");
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("D");
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("E");
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("F");
            }
        });

        HEX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heSo != 16){
                    String s = Result.getText().toString();
                    String temp = DecimalToAny(AnyToDecimal(heSo,s) ,16);
                    Calculation.setText((fixedCalculation(Calculation.getText().toString(),16)));
                    input = temp;
                    Result.setText(temp);
                    setBtnEnabled();
                    heSo = 16;
                    Disable();
                }else{
                    return;
                }
            }
        });
        DEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heSo != 10){
                    String s = Result.getText().toString();
                    String temp = AnyToDecimal(heSo,s);
                    Calculation.setText((fixedCalculation(Calculation.getText().toString(),10)));
                    input = temp;
                    Result.setText(temp);
                    heSo = 10;
                    Disable();
                }else{
                    return;
                }
            }
        });

        OCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heSo != 8){
                    String s = Result.getText().toString();
                    String temp = DecimalToAny(AnyToDecimal(heSo,s) ,8);
                    Calculation.setText((fixedCalculation(Calculation.getText().toString(),8)));
                    input = temp;
                    Result.setText(temp);
                    heSo = 8;
                    Disable();
                }else{
                    return;
                }
            }
        });

        BIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heSo != 2){
                    String s = Result.getText().toString();
                    String temp = DecimalToAny(AnyToDecimal(heSo,s),2);
                    Calculation.setText((fixedCalculation(Calculation.getText().toString(),2)));
                    input = temp;
                    Result.setText(temp);
                    heSo = 2;
                    Disable();
                }else{
                    return;
                }
            }
        });

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAction();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" + ");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " + ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" + ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" + ");
                        Result.setText(d);
                        show();
                    }
                }
                flag = true;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" - ");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " - ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" - ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" - ");
                        Result.setText(d);
                        show();
                    }
                }
                flag = true;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" * ");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+" * ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " * ");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " * ");
                    }
                }
                flag = true;
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" / ");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+" / ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " / ");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " / ");
                    }
                }
                flag = true;
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" % ");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+" % ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " % ");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " % ");
                    }
                }
                flag = true;
            }
        });

        btnLshift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" << ");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+" << ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " << ");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " << ");
                    }
                }
                flag = true;
            }
        });

        btnRshift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" >> ");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+" >> ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " >> ");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d;
                            if(heSo == 10) {
                                d = solve(temp);
                            }else{
                                d = solve(fixedCalculation(temp,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }else{
                            String d;
                            if(heSo == 10) {
                                d = solve(s);
                            }else{
                                d = solve(fixedCalculation(s,10));
                                d = DecimalToAny(d,heSo);
                            }
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + " >> ");
                    }
                }
                flag = true;
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.length()==0){
                    String d;
                    if(heSo == 10) {
                        d = solve(s);
                    }else{
                        d = solve(fixedCalculation(s,10));
                        d = DecimalToAny(d,heSo);
                    }
                    input = d;
                    Result.setText(input);
                    Calculation.setText(s + " = ");
                    show();
                    flag = true;
                }else{
                    if (s.charAt(s.length() - 1) == ')') {
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        input = d;
                        Result.setText(input);
                        Calculation.setText(s + " = ");
                        show();
                        flag = true;
                    } else {
                        s += Result.getText().toString();
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        input = d;
                        Result.setText(input);
                        Calculation.setText(s + " = ");
                        show();
                        flag = true;
                    }
                }
            }
        });

        btnLpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                s += "(";
                Calculation.setText(s);
            }
        });

        btnRpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(checkPar(s) > 0){
                    s += ")";
                    Calculation.setText(s);
                    updateInput();
                    Result.setText(Double.toString(eval(input)));
                    show();
                }
            }
        });

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = Result.getText().toString();
                if(temp.equals("")||temp.length() == 1){
                    Result.setText("0");
                    show();
                }else{
                    Result.setText(temp.substring(0,temp.length()-1));
                    show();
                }
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Result.getText().toString().equals("0") || Calculation.getText().toString().endsWith("=")){
                    Calculation.setText("");
                    input = "";
                }else{
                    Result.setText("0");
                    DECtext.setText("0");
                    HEXtext.setText("0");
                    OCTtext.setText("0");
                    BINtext.setText("0");
                }
            }
        });
    }

    private void changeAction() {
        Dialog dialog = new Dialog(this.getActivity(),
                android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_change_layout);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.x = 0; lp.y = 550;
//        lp.gravity = Gravity.TOP|Gravity.LEFT;

        dialog.getWindow().setAttributes(lp);
        dialog.setCancelable(true);

        Button btnAnd = dialog.findViewById(R.id.it_and);
        Button btnOr = dialog.findViewById(R.id.it_or);
        Button btnNot = dialog.findViewById(R.id.it_not);
        Button btnNand = dialog.findViewById(R.id.it_nand);
        Button btnNor = dialog.findViewById(R.id.it_nor);
        Button btnXor = dialog.findViewById(R.id.it_xor);

        btnAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" and ");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " and ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" and ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" and ");
                        Result.setText(d);
                        show();
                    }
                }
                flag = true;
                dialog.dismiss();
            }
        });

        btnOr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+"or");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " or ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" or ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" or ");
                        Result.setText(d);
                        show();
                    }
                }
                flag = true;
                dialog.dismiss();
            }
        });

        btnNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    s = "not(" + Result.getText().toString() +")";
                    Calculation.setText(s);
                    String d;
                    if(heSo == 10) {
                        d = solve(s);
                    }else{
                        d = solve(fixedCalculation(s,10));
                        d = DecimalToAny(d,heSo);
                    }
                    input = s;
                    Result.setText(d);
                }else {
                    if (s.lastIndexOf("=") > 0) {
                        s = "not(" + input + ")";
                        input = s;
                    } else if (s.charAt(s.length() - 1) != ')') {
                        String temp = " not("+ Result.getText().toString() + ")";
                        s += temp;
                        input = temp;
                    } else {
                        s = s.substring(0, s.length() - input.length());
                        s += "not(" + input + ")";
                        input = "not(" + input + ")";
                    }
                    Calculation.setText(s);
                    String d;
                    if(heSo == 10) {
                        d = solve(input);
                    }else{
                        d = solve(fixedCalculation(input,10));
                        d = DecimalToAny(d,heSo);
                    }
                    Result.setText(d);
                }
                flag = true;
                dialog.dismiss();
            }
        });

        btnNor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" nor ");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " nor ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" nor ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" nor ");
                        Result.setText(d);
                        show();
                    }
                }
                flag = true;
                dialog.dismiss();
            }
        });

        btnNand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" nand ");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " nand ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" nand ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" nand ");
                        Result.setText(d);
                        show();
                    }
                }
                flag = true;
                dialog.dismiss();
            }
        });

        btnXor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.equals("")){
                    Calculation.setText(Result.getText().toString()+" xor ");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " xor ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" xor ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d;
                        if(heSo == 10) {
                            d = solve(s);
                        }else{
                            d = solve(fixedCalculation(s,10));
                            d = DecimalToAny(d,heSo);
                        }
                        Calculation.setText(s+" xor ");
                        Result.setText(d);
                        show();
                    }
                }
                flag = true;
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void updateInput(){
        String s = Calculation.getText().toString();
        if(s.charAt(s.length()-1) == ')'){
            long n = checkPar(s);
            int i;
            long cnt = 0;
            for(i=0;i<s.length();i++){
                if(s.charAt(i) == '(') cnt++;
                if(cnt == n+1) break;
            }
            input = s.substring(i);
            String d = solve(input);
            Result.setText(d);
            show();
        }else{
            throw new RuntimeException("??????");
        }
    }

    public String fixedCalculation(String s,long HeSo){
        String fixedString = "";
        if(s.length() != 0) {
            while (s.contains(" ")) {
                if(s.charAt(0) != ' '){
                    int tmp = s.indexOf(' ');

                    String temp = s.substring(0,tmp);
                    if(heSo == 10){
//
                        fixedString += DecimalToAny(temp,HeSo);
                    }else{
//
                        fixedString += DecimalToAny(AnyToDecimal(heSo,temp),HeSo);
                    }
                    s = s.substring(tmp);
                }else{
//
                    int tmp = s.indexOf(' ',1);
                    fixedString += s.substring(0,tmp+1);
                    s = s.substring(tmp+1);
                }
            }

            if(s.length() > 0){
                if (heSo == 10) {
                    fixedString += DecimalToAny(s, HeSo);
                } else {
                    fixedString += DecimalToAny(AnyToDecimal(heSo, s), HeSo);
                }
            }
        }
        return fixedString;
    }

    public void setBtnEnabled(){
        btnZero.setEnabled(true);
        btnOne.setEnabled(true);
        btnThree.setEnabled(true);
        btnTwo.setEnabled(true);
        btnFour.setEnabled(true);
        btnFive.setEnabled(true);
        btnSix.setEnabled(true);
        btnSeven.setEnabled(true);
        btnEight.setEnabled(true);
        btnNine.setEnabled(true);
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
    }

    public long checkPar(String s){
        long closePar = 0,openPar = 0;
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

    public void NumInput(String s){
        if(Result.getText().toString().equals("0") || flag ){
            Result.setText(s);
            input = s;
            show();
            flag = false;
        }else if(s.equals(".")){
            if(Result.getText().toString().contains(".")) {
                Result.setText(Result.getText().toString() + s);
                show();
                input += ".";
            }
        }else{
            Result.setText(Result.getText().toString()+s);
            show();
            input += s;
        }
    }

    public String solve(String s){
        long d = eval(s);
        return String.valueOf(d);
    }

    public void show(){
        String temp = Result.getText().toString();
        if(heSo != 10){
            String temp1 = AnyToDecimal(heSo,temp);
            HEXtext.setText(DecimalToAny(temp1,16));
            DECtext.setText(temp1);
            BINtext.setText(DecimalToAny(temp1,2));
            OCTtext.setText(DecimalToAny(temp1,8));
        }else{
            System.out.println("show " +DecimalToAny(temp,16));
            HEXtext.setText(DecimalToAny(temp,16));
            DECtext.setText(temp);
            BINtext.setText(DecimalToAny(temp,2));
            OCTtext.setText(DecimalToAny(temp,8));
        }
    }

    public void Disable(){
        if(heSo <= 10) {
            setBtnEnabled();
            btnA.setEnabled(false);
            btnB.setEnabled(false);
            btnC.setEnabled(false);
            btnD.setEnabled(false);
            btnE.setEnabled(false);
            btnF.setEnabled(false);
        }
        if(heSo <= 8 ){
            setBtnEnabled();
            btnEight.setEnabled(false);
            btnNine.setEnabled(false);
        }
        if(heSo <= 2){
            setBtnEnabled();
            btnTwo.setEnabled(false);
            btnThree.setEnabled(false);
            btnFour.setEnabled(false);
            btnFive.setEnabled(false);
            btnSix.setEnabled(false);
            btnSeven.setEnabled(false);
        }
    }

    public String AnyToDecimal(long base,String num){
        long number = 0;
        long n ;
        String res = "";
        if(base == 16){
            int i=num.length()-1;
            int j=0;
            while (i>=0)
            {
                String dig=String.valueOf(num.charAt(i));
                switch (dig) {
                    case "A":
                        dig = "10";
                        break;
                    case "B":
                        dig = "11";
                        break;
                    case "C":
                        dig = "12";
                        break;
                    case "D":
                        dig = "13";
                        break;
                    case "E":
                        dig = "14";
                        break;
                    case "F":
                        dig = "15";
                        break;
                }
                number = number+(Integer.parseInt(dig)*(long)Math.pow(base,j));
                i--;
                j++;
            }
        }else{
            n = Integer.parseInt(num);
            long i=0;
            while (n>0)
            {
                long dig = (long) (n % 10);
                number=number+(long)(dig*Math.pow(base,i));
                i++;
                n=n/10;
            }
        }
        res=String.valueOf(number);
        return res;
    }

    public String DecimalToAny(String num,long base){
//        long n;
//        String res = "";
//        n = Long.parseLong(num);
//        if(n == 0 ){
//            res = "0";
//        }else{
//            while (n > 0) {
//                long dig = (long) (n % base);
//                if (base == 16 && dig > 9) {
//                    switch (dig) {
//                        case 10:
//                            res += "A";
//                            break;
//                        case 11:
//                            res += "B";
//                            break;
//                        case 12:
//                            res += "C";
//                            break;
//                        case 13:
//                            res += "D";
//                            break;
//                        case 14:
//                            res += "E";
//                            break;
//                        case 15:
//                            res += "F";
//                            break;
//                    }
//                } else {
//                    res = res + Integer.toString(dig);
//                }
//
//                n = n / base;
//            }
//            res = reverseString(res);
//        }
//
//        return res ;
        HashMap<Long, Character> m = new HashMap<Long, Character>();
        long n = Long.parseLong(num);
        char digit = '0';
        char c = 'a';

        for (long i = 0; i <= 15; i++) {
            if (i < 10) {
                m.put(i, digit);
                digit++;
            }
            else {
                m.put(i, c);
                c++;
            }
        }

        // string to be returned
        String res = "";

        // check if num is 0 and directly return "0"
        if (n == 0) {
            return "0";
        }
        // if num>0, use normal technique as
        // discussed in other post
        if (n > 0) {
            while (n != 0) {
                res = m.get(n % base) + res;
                n /= base;
            }
        }
        // if num<0, we need to use the elaborated
        // trick above, lets see this
        else {
            // store num in a u_long, size of u_it is greater,
            // it will be positive since msb is 0
            long temp = getUnsigned(n);
            System.out.println("DtoA + "+ temp);
            // use the same remainder technique.
            while (n != 0) {
                res = m.get(temp % base) + res;
                temp /= base;
            }
        }

        return res;
    }

    long getUnsigned(long signed) {
         return signed >= 0 ? signed : (long) 2 * Integer.MAX_VALUE + 2 + signed;
    }

    public String reverseString(String res)
    {
        String newRes="";
        int i=res.length()-1;
        while(i>=0)
        {
            newRes+=String.valueOf(res.charAt(i));
            i--;
        }
        return newRes;
    }

    public static long eval(String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(long charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    if(charToEat == '<' || charToEat == '>') {nextChar();}
                    nextChar();
                    return true;
                }
                return false;
            }

            long parse() {
                nextChar();
                long x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            long parseExpression() {
                long x = parseTerm();
                for (;;) {
                    if(ch >= 'a' && ch <= 'z') {
                        int startPos = this.pos;
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String temp = str.substring(startPos, this.pos);
                        if (temp.equals("and")) { x &= parseTerm(); }
                        else if (temp.equals("nand")) {x = ~(x & parseTerm());
                            System.out.println("eval + "+x);}
                        else if (temp.equals("or")) x |= parseTerm();
                        else if (temp.equals("nor")) x = ~(x | parseTerm());
                        else if (temp.equals("xor")) x ^= parseTerm();
                        else throw new RuntimeException("Unknown: " + temp);
                    }
                    else if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            long parseTerm() {
                long x = parseTerm2();
                for (;;) {
                    if      (eat('*')) x *= parseTerm2(); // multiplication
                    else if (eat('/')) x /= parseTerm2(); // division
                    else if (eat('%')) x %= parseTerm2(); // mod
                    else return x;
                }
            }

            long parseTerm2() {
                long x = parseFactor();
                for(;;){
                    if      (eat('>')){
                        x >>= parseFactor();
                    }
                    else if (eat('<')){
                        x <<= parseFactor();
                    }
                    else return x;
                }
            }

           long parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                long x = 0;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    System.out.println(x);
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Long.parseLong(str.substring(startPos, this.pos));

                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("not")) x = ~x;
                    else throw new RuntimeException("Unknown function: " + func);
                }else {
                    if(ch != ')'){
                        throw new RuntimeException("Unexpected: " + (char) ch);
                    }
                }

//                if (eat('^')) x = (long) Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}