package com.example.mycompilation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mycompilation.GuidedAct.EighthGuided;
import com.example.mycompilation.GuidedAct.EleventhGuided;
import com.example.mycompilation.GuidedAct.EleventhGuided2;
import com.example.mycompilation.GuidedAct.FifthGuided;
import com.example.mycompilation.GuidedAct.FirstGuided;
import com.example.mycompilation.GuidedAct.FourthGuided;
import com.example.mycompilation.GuidedAct.NinthGuided;
import com.example.mycompilation.GuidedAct.SecondGuided;
import com.example.mycompilation.GuidedAct.SeventhGuided;
import com.example.mycompilation.GuidedAct.SixthGuided;
import com.example.mycompilation.GuidedAct.TenthGuided;
import com.example.mycompilation.GuidedAct.ThirdGuided;
import com.example.mycompilation.GuidedAct.ThirteenthGuided;
import com.example.mycompilation.GuidedAct.TwelvethGuided;
import com.example.mycompilation.MachineAct.FifthMachine;
import com.example.mycompilation.MachineAct.FourthMachine;
import com.example.mycompilation.MachineAct.SixthMachineAct;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<CardVPLayout> cardVPLayoutArrayList;
    LinearLayout dotsLayout;
    TextView[] dots;
    int currentPos;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsLayout = findViewById(R.id.dots);
        viewPager2 = findViewById(R.id.card_vp);
        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String[] heading = {getString(R.string.mp2),
                getString(R.string.mp4),
                getString(R.string.mp5),
                getString(R.string.mp6),
                getString(R.string.g1),
                getString(R.string.g2),
                getString(R.string.g3),
                getString(R.string.g4),
                getString(R.string.g5),
                getString(R.string.g6),
                getString(R.string.g7),
                getString(R.string.g8),
                getString(R.string.g9),
                getString(R.string.g10),
                getString(R.string.g11),
                getString(R.string.g12),
                getString(R.string.g13),
                getString(R.string.g14)};

        cardVPLayoutArrayList = new ArrayList<>();

        for (int i = 0; i < heading.length; i++) {
            final int position = i;
            CardVPLayout viewPagerItem = new CardVPLayout(heading[i]);
            cardVPLayoutArrayList.add(viewPagerItem);
            viewPagerItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle click event for each slide
                    switch (position) {
                        //MACHINE PROBLEMS 2, 4, 5 & 6
                        case 0:
                            startActivity(new Intent(MainActivity.this, FirstGuided.class));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this, FourthMachine.class));
                            break;
                        case 2:
                            startActivity(new Intent(MainActivity.this, FifthMachine.class));
                            break;
                        case 3:
                            startActivity(new Intent(MainActivity.this, SixthMachineAct.class));
                            break;

                        //GUIDED ACTIVITY 1, 2, 3, 4, 5
                        case 4:
                            startActivity(new Intent(MainActivity.this, SecondGuided.class));
                            break;
                        case 5:
                            startActivity(new Intent(MainActivity.this, SecondGuided.class));
                            break;
                        case 6:
                            startActivity(new Intent(MainActivity.this, ThirdGuided.class));
                            break;
                        case 7:
                            startActivity(new Intent(MainActivity.this, FourthGuided.class));
                            break;
                        case 8:
                            startActivity(new Intent(MainActivity.this, FifthGuided.class));
                            break;

                        //GUIDED ACTIVITY 6, 7, 8, 9, 10
                        case 9:
                            startActivity(new Intent(MainActivity.this, SixthGuided.class));
                            break;
                        case 10:
                            startActivity(new Intent(MainActivity.this, SeventhGuided.class));
                            break;
                        case 11:
                            startActivity(new Intent(MainActivity.this, EighthGuided.class));
                            break;
                        case 12:
                            startActivity(new Intent(MainActivity.this, NinthGuided.class));
                            break;
                        case 13:
                            startActivity(new Intent(MainActivity.this, TenthGuided.class));
                            break;

                        //GUIDED ACTIVITY 11, 12, 13 & 14
                        case 14:
                            startActivity(new Intent(MainActivity.this, EleventhGuided2.class));
                            break;
                        case 15:
                            startActivity(new Intent(MainActivity.this, EleventhGuided.class));
                            break;
                        case 16:
                            startActivity(new Intent(MainActivity.this, TwelvethGuided.class));
                            break;
                        case 17:
                            startActivity(new Intent(MainActivity.this, ThirteenthGuided.class));
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        VPAdapter vpAdapter = new VPAdapter(MainActivity.this, cardVPLayoutArrayList);
        viewPager2.setAdapter(vpAdapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        addDots(0);
        viewPager2.registerOnPageChangeCallback(changeCallback);
    }

    protected void addDots(int position) {
        if (dots == null) {
            dots = new TextView[cardVPLayoutArrayList.size()];
            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226;", Html.FROM_HTML_MODE_COMPACT));
                dots[i].setTextSize(35);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(6, 0, 6, 0);
                dots[i].setLayoutParams(params);
                dotsLayout.addView(dots[i]);
            }
        }

        for (int i = 0; i < dots.length; i++) {
            dots[i].setTextColor(ContextCompat.getColor(this, i == position ? R.color.Olive_Green : R.color.Dark_Green));
        }
    }

    ViewPager2.OnPageChangeCallback changeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}