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

public class ProgrammerFragment extends Fragment {
    TextView Calculation,Result;
    boolean flag = true ;
    TextView DEC,HEX,BIN,OCT;
    TextView DECtext,HEXtext,BINtext,OCTtext;
    int heSo = 10;
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

        HEX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(heSo != 16){
                    String s = Result.getText().toString();
                    Result.setText(DecimalToAny(AnyToDecimal(heSo,s) ,16));
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
                    Result.setText(AnyToDecimal(heSo,s));
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
                    Result.setText(DecimalToAny(AnyToDecimal(heSo,s) ,8));
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
                    String temp = AnyToDecimal(heSo,s);
                    Result.setText(DecimalToAny(temp,2));
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
                    Calculation.setText(Result.getText().toString()+"+");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + "+");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d = solve(s);
                        Calculation.setText(s+"+");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d = solve(s);
                        Calculation.setText(s+"+");
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
                    Calculation.setText(Result.getText().toString()+"-");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + "-");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d = solve(s);
                        Calculation.setText(s+"-");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d = solve(s);
                        Calculation.setText(s+"-");
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
                    Calculation.setText(Result.getText().toString()+"*");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+"*");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "*");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "*");
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
                    Calculation.setText(Result.getText().toString()+"/");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+"/");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "/");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "/");
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
                    Calculation.setText(Result.getText().toString()+"%");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+"%");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "%");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "%");
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
                    Calculation.setText(Result.getText().toString()+"<<");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+"<<");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "<<");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + "<<");
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
                    Calculation.setText(Result.getText().toString()+">>");
                }else{
                    if(s.lastIndexOf("=") > 0){
                        Calculation.setText(input+">>");
                    }else if(s.charAt(s.length()-1) == ')'){
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + ">>");
                    }else{
                        s += Result.getText().toString();
                        if(s.contains("+")||s.contains("-")) {
                            int i = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
                            String temp = s.substring(i + 1);
                            String d = solve(temp);
                            Result.setText(d);
                            show();
                        }else{
                            String d = solve(s);
                            Result.setText(d);
                            show();
                        }
                        Calculation.setText(s + ">>");
                    }
                }
                flag = true;
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Calculation.getText().toString();
                if(s.charAt(s.length()-1) == ')') {
                    String d = solve(s);
                    input = d;
                    Result.setText(input);
                    Calculation.setText(s + "=");
                    show();
                    flag = true;
                } else {
                    s += Result.getText().toString();
                    String d = solve(s);
                    input = d;
                    System.out.println(d);
                    return;
//                    Result.setText(input);
//                    Calculation.setText(s + "=");
//                    show();
//                    flag = true;
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
        lp.x = 0; lp.y = 100;
//        lp.gravity = Gravity.TOP|Gravity.LEFT;

        dialog.getWindow().setAttributes(lp);

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
                    Calculation.setText(Result.getText().toString()+" AND ");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + " AND ");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d = solve(s);
                        Calculation.setText(s+" AND ");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d = solve(s);
                        Calculation.setText(s+" AND ");
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
                    Calculation.setText(Result.getText().toString()+"Or");
                }else{
                    if(s.lastIndexOf("=") > 0) {
                        Calculation.setText(input + "Or");
                    }else if(s.charAt(s.length()-1) == ')'){
                        String d = solve(s);
                        Calculation.setText(s+"Or");
                        Result.setText(d);
                        show();
                    }else {
                        String temp = Result.getText().toString();
                        s += temp;
                        String d = solve(s);
                        Calculation.setText(s+"Or");
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
            int n = checkPar(s);
            int i;
            int cnt = 0;
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

    public void NumInput(String s){
        if(Result.getText().toString().equals("0") || flag ){
            Result.setText(s);
            show();
            flag = false;
        }else if(s.equals(".")){
            if(Result.getText().toString().contains(".")) {
                Result.setText(Result.getText().toString() + s);
                show();
            }
        }else{
            Result.setText(Result.getText().toString()+s);
            show();
        }
    }

    public String solve(String s){
        if(heSo != 10){
            s = AnyToDecimal(heSo,s);
        }
        long d = eval(s);
        return DecimalToAny(Long.toString(d),heSo);
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
                number = number+(Long.parseLong(dig)*(long)Math.pow(base,j));
                i--;
                j++;

            }
        }else{
            n = Long.parseLong(num);
            int i=0;
            while (n>0)
            {
                int dig = (int) (n % 10);
                number=number+(long)(dig*Math.pow(base,i));
                i++;
                n=n/10;
            }
        }
        res=String.valueOf(number);
        return res;
    }

    public String DecimalToAny(String num,long base){
        long n;
        String res = "";
        n = Long.parseLong(num);
        while (n > 0) {
            int dig = (int) (n % base);
            if (base==16 && dig>9)
            {
                switch (dig)
                {
                    case 10:
                        res+="A";
                        break;
                    case 11:
                        res+="B";
                        break;
                    case 12:
                        res+="C";
                        break;
                    case 13:
                        res+="D";
                        break;
                    case 14:
                        res+="E";
                        break;
                    case 15:
                        res+="F";
                        break;
                }
            }
            else
            {
                res = res + Integer.toString(dig);
            }

            n = n / base;
        }
        res = reverseString(res);
        return res ;
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

            boolean eat(int charToEat) {
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
                int startPos = this.pos;
                for (;;) {
                    if(ch >= 'A' && ch <= 'Z') {
                        while (ch >= 'A' && ch <= 'Z') nextChar();
                        String temp = str.substring(startPos, this.pos);
                        if (temp.equals("AND")) x &= parseTerm();
                        else if (temp.equals("NAND")) x = ~(x & parseTerm());
                        else if (temp.equals("OR")) x |= parseTerm();
                        else if (temp.equals("NOR")) x = ~(x | parseTerm());
                        else if (temp.equals("XOR")) x ^= parseTerm();
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

                long x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Long.parseLong(str.substring(startPos, this.pos));

                } else if (ch >= 'A' && ch <= 'Z') { // functions
                    while (ch >= 'A' && ch <= 'Z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("NOT")) x = ~x;
                    else throw new RuntimeException("Unknown function: " + func);
                }else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

//                if (eat('^')) x = (long) Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}