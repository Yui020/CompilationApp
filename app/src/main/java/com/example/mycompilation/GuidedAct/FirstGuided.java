package com.example.mycompilation.GuidedAct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.MainActivity;
import com.example.mycompilation.R;

public class FirstGuided extends AppCompatActivity {
    EditText name, age;
    TextView result;
    Button click, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_guided);
        init();
        showResult();

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void showResult(){
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Name: " + name.getText().toString() +
                        "\nAge: " + age.getText().toString());
                name.setText("");
                age.setText("");
                name.requestFocus();
            }
        });
    }
    public void init(){
        name = findViewById(R.id.etNameGE1);
        age = findViewById(R.id.etAgeGE1);
        result = findViewById(R.id.tvResultGE1);
        click = findViewById(R.id.btnClickGE1);
    }

}