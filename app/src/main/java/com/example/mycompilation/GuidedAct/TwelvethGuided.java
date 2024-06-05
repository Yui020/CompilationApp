package com.example.mycompilation.GuidedAct;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycompilation.R;

import java.util.Random;

public class TwelvethGuided extends AppCompatActivity {
    Button click, back;
    Random rand; // creation of random object
    LinearLayout linearLayout;
    int imageNumber = 0;
    int[] images = {R.drawable.img_at1, R.drawable.img_at2,R.drawable.img_at3,R.drawable.img_at4,R.drawable.img_at5,R.drawable.img_at6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelveth_guided);
        randomImage();

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void randomImage() {
        click = findViewById(R.id.btnClicked);
        rand = new Random(); // instantiate rand object
        LinearLayout layout = findViewById(R.id.bg_img); // get the reference to the layout
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageNumber = rand.nextInt(6); // random numbers from 0-5
                layout.setBackgroundResource(images[imageNumber]); // change the background image of the layout
            }
        });
    }
}

