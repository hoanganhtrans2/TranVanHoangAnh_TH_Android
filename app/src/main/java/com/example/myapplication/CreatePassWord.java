package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class CreatePassWord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pass_word);
        final CheckBox cboLower = (CheckBox) findViewById(R.id.cboLower);
        final CheckBox cboUpcase = (CheckBox) findViewById(R.id.cboUpcase);
        final CheckBox cboNumber = (CheckBox) findViewById(R.id.cboNumber);
        final CheckBox cboSymbol = (CheckBox) findViewById(R.id.cboSymbol);
        final TextView passWordTextView = (TextView) findViewById(R.id.txtPassWord);
        final Button button = findViewById(R.id.btnCreate);
        final EditText editText = findViewById(R.id.txtLengthPass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                int idoDaiKytu = parseInt(editText.getText().toString());
                String pss = createPassword(cboLower.isChecked(), cboUpcase.isChecked(),
                        cboNumber.isChecked(),cboSymbol.isChecked(), idoDaiKytu);
                passWordTextView.setText(pss);
            }
        });

    }
    private String createPassword(boolean l, boolean u, boolean n, boolean s, int length){
        String symbol = "-/.^&*_!@%=+>)";
        String upcases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowers = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String finalString = "";
        String password = "";
        Random random = new Random();
        if(l){
            password += lowers.charAt(random.nextInt(lowers.length()));
            finalString +=  lowers;
        }
        System.out.println(password);
        if(u){
            password += upcases.charAt(random.nextInt(upcases.length()));
            finalString+=upcases;
        }
        if(n){
            password += numbers.charAt(random.nextInt(numbers.length()));
            finalString+=numbers;
        }
        if(s){
            password += symbol.charAt(random.nextInt(symbol.length()));
            finalString+=symbol;
        }
        if(password.length()<1){
            finalString += symbol + upcases + lowers + numbers;
        }
        while(password.length()<length){
            password +=
                    finalString.charAt(random.nextInt(finalString.length()));
        }
        return  password;
    }
}