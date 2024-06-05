package com.example.mycompilation.GuidedAct;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycompilation.R;

public class EighthGuided extends AppCompatActivity {

    Button back;
    Spinner names;
    TextView result;
    ArrayAdapter adapter;
    String[] listOfNames = {"Name Here", "Elgin", "Claire", "Leila", "Faith", "Jenny", "Jude", "Mark", "Arthur", "Pole", "Aaron"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_guided);
        init();
        showSelectedName();

        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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
    }
}