package com.example.mycompilation.MachineAct;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;

public class SecondMachine extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secondNumber;
    private TextView tvResult;
    private Button addButton, subButton, divButton, multiButton, back;
    private double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_machine);
        init();
        Clicked();

        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void init(){
        firstNumber = findViewById(R.id.etFirstNumber);
        secondNumber = findViewById(R.id.etSecondNumber);
        addButton = findViewById(R.id.btnAdd);
        subButton = findViewById(R.id.btnDiff);
        divButton = findViewById(R.id.btnQuo);
        multiButton = findViewById(R.id.btnProd);
        tvResult = findViewById(R.id.tvResult);
    }

    public void Clicked() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum + sNum;
                    showResult("Addition");
                    clearET();
                }
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum -  sNum;
                    showResult("Subtraction");
                    clearET();
                }
            }
        });

        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum * sNum;
                    showResult("Multiplication" );
                    clearET();
                }
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum / sNum;
                    showResult("Division");
                    clearET();
                }
            }
        });
    }
    public void clearET(){
        firstNumber.setText("");
        secondNumber.setText("");
        firstNumber.requestFocus();
    }
    public void showResult(String operation){
        if (result % 2 == 0) {
            // Even
            tvResult.setTextColor(Color.BLUE);
        } else {
            //Odd
            tvResult.setTextColor(Color.RED);
        }
        tvResult.setText(operation + " Result: " + String.valueOf(result));
    }
    public void restrict(){
        Toast.makeText(getApplicationContext(), "Please enter all required numbers to compute.",Toast.LENGTH_SHORT).show();
    }

}