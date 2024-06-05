package com.example.mycompilation.GuidedAct;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;

public class FifthGuided extends AppCompatActivity {
    RadioButton red, blue, yellow, green;
    RadioGroup rbGroup;
    ConstraintLayout main;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_guided);
        init();
        radioButtonListener();

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void showSelectedColor(){
        if(red.isChecked()){
            Toast.makeText(getApplicationContext(),"Color: RED", Toast.LENGTH_SHORT).show();
        }
        if(blue.isChecked()){
            Toast.makeText(getApplicationContext(),"Color: BLUE", Toast.LENGTH_SHORT).show();
        }
        if(yellow.isChecked()){
            Toast.makeText(getApplicationContext(),"Color: YELLOW", Toast.LENGTH_SHORT).show();
        }
        if(green.isChecked()){
            Toast.makeText(getApplicationContext(),"Color: GREEN", Toast.LENGTH_SHORT).show();
        }
    }
    public void radioButtonListener(){
        red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeBackgroundColor(buttonView);
            }
        });
        blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeBackgroundColor(buttonView);
            }
        });yellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeBackgroundColor(buttonView);
            }
        });green.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeBackgroundColor(buttonView);
            }
        });

    }
    public void changeBackgroundColor(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if (view.getId() == R.id.rbRed && checked) {
            main.setBackgroundColor(Color.RED);
            showSelectedColor();
        } else if (view.getId() == R.id.rbBlue && checked) {
            main.setBackgroundColor(Color.BLUE);
            showSelectedColor();
        } else if (view.getId() == R.id.rbYellow && checked) {
            main.setBackgroundColor(Color.YELLOW);
            showSelectedColor();
        } else if (view.getId() == R.id.rbGreen && checked) {
            main.setBackgroundColor(Color.GREEN);
            showSelectedColor();
        }
    }

    public void init(){
        red = findViewById(R.id.rbRed);
        blue = findViewById(R.id.rbBlue);
        yellow = findViewById(R.id.rbYellow);
        green = findViewById(R.id.rbGreen);
        rbGroup = findViewById(R.id.rgColors);
        main = findViewById(R.id.main);
    }
}