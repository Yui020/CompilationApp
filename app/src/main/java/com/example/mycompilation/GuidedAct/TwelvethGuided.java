package com.example.mycompilation.GuidedAct;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycompilation.R;

import java.util.Random;

public class TwelvethGuided extends AppCompatActivity {
    Button click;
    Random rand; // creation of random object
    int imageNumber = 0;
    int[] images = {R.drawable.image1, R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelveth_guided);
        randomImage();
    }
    public void randomImage() {
        click = findViewById(R.id.btnClicked);
        rand = new Random(); // instantiate rand object
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageNumber = rand.nextInt(4); // random numbers from 0-4
                getWindow().setBackgroundDrawableResource(images[imageNumber]); // change the background image
            }
        });
    }
}

