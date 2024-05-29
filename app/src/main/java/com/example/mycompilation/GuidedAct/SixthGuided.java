package com.example.mycompilation.GuidedAct;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;

public class SixthGuided extends AppCompatActivity {

    CheckBox one, two, three, four;
    TextView result;
    Button click;
    ImageView ivReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_guided);
        init();
        returnClicked();
        checkedClicked();
    }

    public void checkedClicked(){
       click.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showResult();
           }
       });
    }
    public void showResult(){
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(two.isChecked() && four.isChecked()){
                    // this will show the TextView named result
                    result.setVisibility(View.VISIBLE);
                    result.setTextColor(Color.RED);
                    result.setText("Number Combination Color is RED");
                }else if (one.isChecked() && three.isChecked()){
                    result.setVisibility(View.VISIBLE);
                    result.setTextColor(Color.BLUE);
                    result.setText("Number Combination Color is BLUE");
                }else if ((one.isChecked() || three.isChecked()) ||
                        (two.isChecked() || four.isChecked())){
                    result.setVisibility(View.VISIBLE);
                    result.setTextColor(Color.GREEN);
                    result.setText("Number Combination Color is GREEN");
                }else{
                    // this will hide the TextView named result
                    result.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
    public void init(){
        one = findViewById(R.id.chkOne);
        two = findViewById(R.id.chkTwo);
        three = findViewById(R.id.chkThree);
        four = findViewById(R.id.chkFour);
        result = findViewById(R.id.tvResultGE6);
        click = findViewById(R.id.btnClickGE6);
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