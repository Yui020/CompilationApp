package com.example.mycompilation.GuidedAct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;

public class EighthGuided extends AppCompatActivity {

    Spinner names;
    TextView result;
    ArrayAdapter adapter;
    ImageView ivReturn;
    String[] listOfNames = {"Name Here", "Jude", "Mikel", "Rey", "Arthur", "Artugue", "Pole", "Andrei", "Buendia", "Aarron", "Villamento", "Mark", "Anthony", "Toralde"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_guided);
        init();
        returnClicked();
        showSelectedName();
    }
    public void showSelectedName(){
        names.setAdapter(adapter);
        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if(i > 0){
                    result.setText("Name: " + listOfNames[i]);
                    Toast.makeText(getApplicationContext(),
                            "Name: " + listOfNames[i],Toast.LENGTH_SHORT).show();
                }else{
                    result.setText("Name: ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void init(){
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfNames);
        names = findViewById(R.id.spnrNamesGE8);
        result = findViewById(R.id.tvResultGE4);
        ivReturn = findViewById(R.id.ivReturn);
    }
    public void returnClicked(){
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}