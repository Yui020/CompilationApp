package com.example.mycompilation.GuidedAct;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.mycompilation.R;

public class EleventhGuided extends AppCompatActivity {
        ImageView marvelCharacter;
        Button click;
        RadioButton captainamerica, thor, hulk, ironman;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_eleventh_guided);
            ListenerClickButton();
        }
        public void ListenerClickButton(){
            marvelCharacter =  (ImageView) findViewById(R.id.ivMarvelCharacter);
            captainamerica  = (RadioButton) findViewById(R.id.rdoCaptainAmerica);
            thor =  (RadioButton) findViewById(R.id.rdoThor);
            hulk = (RadioButton) findViewById(R.id.rdoHulk);
            ironman = (RadioButton) findViewById(R.id.rdoIronMan);
            click = (Button) findViewById(R.id.btnClick);
            marvelCharacter.setImageResource(R.mipmap.ic_launcher);
            thor.setChecked(true);

            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                //This will change the Image of the image view "ivMarvelCharacter".
                    if (thor.isChecked()) {
                        marvelCharacter.setImageResource(R.mipmap.ic_thor);
                    }else if (captainamerica. isChecked()) {
                        marvelCharacter.setImageResource(R.mipmap.ic_cap);
                    }else if (hulk.isChecked()) {
                        marvelCharacter.setImageResource(R.mipmap.ic_hulk);
                    }else if (ironman.isChecked()) {
                        marvelCharacter.setImageResource(R.mipmap.ic_iron);
                    }else{
                        Toast.makeText(EleventhGuided.this, "Please Choose One", Toast.LENGTH_SHORT).show();
                    }
                }

            });

        }
}