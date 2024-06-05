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
        ImageView atCharacs;
        Button click, back;
        RadioButton finn, marcy, pb, jake;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_eleventh_guided);
            ListenerClickButton();

            back = findViewById(R.id.btn_back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        public void ListenerClickButton(){
            atCharacs =  (ImageView) findViewById(R.id.ivATCharacters);
            finn  = (RadioButton) findViewById(R.id.rdoFinn);
            marcy =  (RadioButton) findViewById(R.id.rdoMarcy);
            pb = (RadioButton) findViewById(R.id.rdoPB);
            jake = (RadioButton) findViewById(R.id.rdoJake);
            click = (Button) findViewById(R.id.btnClick);
            atCharacs.setImageResource(R.mipmap.ic_at_logo);
            finn.setChecked(true);

            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                //This will change the Image of the image view "ivMarvelCharacter".
                    if (finn.isChecked()) {
                        atCharacs.setImageResource(R.mipmap.ic_finn);
                    }else if (marcy. isChecked()) {
                        atCharacs.setImageResource(R.mipmap.ic_marcy);
                    }else if (pb.isChecked()) {
                        atCharacs.setImageResource(R.mipmap.ic_pb);
                    }else if (jake.isChecked()) {
                        atCharacs.setImageResource(R.mipmap.ic_jake);
                    }else{
                        Toast.makeText(EleventhGuided.this, "Please Choose One", Toast.LENGTH_SHORT).show();
                    }
                }

            });

        }
}