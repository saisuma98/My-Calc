package com.e.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {


    EditText editA,editB;
    TextView textResult;
    Button gcd,inverse1,inverse2;
    String a,b,displayString1,displayString2,displayStringGcd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = (EditText)findViewById(R.id.textA);
        editB = (EditText)findViewById(R.id.textB);
        textResult = (TextView)findViewById(R.id.result);
        gcd = (Button)findViewById(R.id.gcd);
        inverse1 = (Button)findViewById(R.id.inverse1);
        inverse2 = (Button)findViewById(R.id.inverse2);

        clearFields();


        editA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                a = s.toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                a = s.toString();

                displayString1= "Inverse of "+a+ " mod "+b;
                displayString2= "Inverse of "+b+ " mod "+a;
                displayStringGcd = "Gcd of "+a+ " and "+b;

                gcd.setText(displayStringGcd);
                inverse1.setText(displayString1);
                inverse2.setText(displayString2);

            }
        });

        editB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                b = s.toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                b = s.toString();


                displayString1= "Inverse of "+a+ " mod "+b;
                displayString2= "Inverse of "+b+ " mod "+a;
                displayStringGcd = "Gcd of "+a+ " and "+b;

                gcd.setText(displayStringGcd);
                inverse1.setText(displayString1);
                inverse2.setText(displayString2);

            }
        });


    }

    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }



    static int modInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

    public void clearFields(){

        editA.setText("");
        editB.setText("");
        textResult.setText("");

        displayString1= "Inverse of A mod B";
        displayString2= "Inverse of B mod A";
        displayStringGcd = "Gcd of A and B";

        gcd.setText(displayStringGcd);
        inverse1.setText(displayString1);
        inverse2.setText(displayString2);

    }

    public void clearButton(View view) {

        clearFields();

    }

    public void calculateGcd(View view) {

        String strA = editA.getText().toString();
        String strB = editB.getText().toString();

        if (strA.isEmpty() && strB.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter both the numbers", Toast.LENGTH_SHORT).show();
        } else if (strA.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter the 1st number", Toast.LENGTH_SHORT).show();
        } else if (strB.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter the 2nd number", Toast.LENGTH_SHORT).show();
        } else {

            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            int result = gcd(a, b);
            textResult.setText(result + "");

        }
    }
    public void calculateInverseAB(View view) {

        String strA = editA.getText().toString();
        String strB = editB.getText().toString();

        if (strA.isEmpty() && strB.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter both the numbers", Toast.LENGTH_SHORT).show();
        } else if (strA.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter the 1st number", Toast.LENGTH_SHORT).show();
        } else if (strB.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter the 2nd number", Toast.LENGTH_SHORT).show();
        } else {

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);

        int result = modInverse(a,b);
        textResult.setText(result+"");

        }
    }

    public void calculateInverseBA(View view) {

        String strA = editA.getText().toString();
        String strB = editB.getText().toString();

        if (strA.isEmpty() && strB.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter both the numbers", Toast.LENGTH_SHORT).show();
        } else if (strA.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter the 1st number", Toast.LENGTH_SHORT).show();
        } else if (strB.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter the 2nd number", Toast.LENGTH_SHORT).show();
        } else {

            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            int result = modInverse(b, a);
            textResult.setText(result + "");
        }
    }
}
