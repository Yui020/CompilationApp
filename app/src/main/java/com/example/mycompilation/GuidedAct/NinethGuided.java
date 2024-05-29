package com.example.mycompilation.GuidedAct;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;

public class NinethGuided extends AppCompatActivity {
    ListView name;
    ImageView ivReturn;
    ArrayAdapter adapter;
    String[] listOfNames = { "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Isabella", "Jack"};
    double[] listOfSemGrades = {1.00,1.50,2.00,1.25,3.00,5.00,1.75,2.25,3.00,1.00,2.25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nineth_guided);
        init();
        showSemGrade();
        returnClicked();
    }
    public void showSemGrade(){
        name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getApplicationContext(),"Name: " + name.getItemAtPosition(i)
                        + "\nSem Grade: " + listOfSemGrades[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void init(){
        name = findViewById(R.id.lvNameGE9);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfNames);
        name.setAdapter(adapter);
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