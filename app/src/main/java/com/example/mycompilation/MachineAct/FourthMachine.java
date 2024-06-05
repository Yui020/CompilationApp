package com.example.mycompilation.MachineAct;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
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

import com.example.mycompilation.R;

import java.text.DecimalFormat;

public class FourthMachine extends AppCompatActivity {
    private TextView tvStudentName, tvSemGrade, tvPEquivalent, tvRemarks;

    private EditText studentName, Prelim, Midterm, Finals;

    private Button btnCompute, btnNewEnt, back;

    private String name;
    private double prelimG, midtermG, finalG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_machine);
        init();
        computeClick();
        newEventClicked();

        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public double average(double prelim, double midterm, double Final){
        return prelim * 0.25 + midterm * 0.25 + Final * 0.50;
    }
    public double equivalent(double average){
        double equi;

        if(average == 100){
            equi = 1.00;
        } else if (average <= 99 && average >= 95) {
            equi = 1.50;
        }else if (average <= 94 && average >= 90) {
            equi = 2.00;
        }else if (average <= 89 && average >= 85) {
            equi = 2.50;
        }else if (average <= 84 && average >= 80) {
            equi = 3.00;
        }else if (average <= 79 && average >= 75) {
            equi = 3.50;
        }else if (average <= 74) {
            equi = 5.00;
        }else{
            return 0;
        }
        return equi;
    }
    public String Remark(double equi){
        if(equi > 3.00){
            tvRemarks.setTextColor(Color.RED);
            return "Failed!";
        }
        tvRemarks.setTextColor(Color.BLUE);
        return "Passed!";
    }
    public void newEventClicked(){
        btnNewEnt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FourthMachine.this);
                builder.setTitle("Warning Message").setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        clearET();
                        clearTv();
                        tvRemarks.setTextColor(Color.BLACK);
                        studentName.setText("");
                        studentName.requestFocus();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });

    }

    public void computeClick(){
        AlertDialog.Builder builder = new AlertDialog.Builder(FourthMachine.this);
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setTitle("Warning Message").setMessage("All Entries Correct?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if(!studentName.getText().toString().isEmpty()  && !Prelim.getText().toString().isEmpty() && !Midterm.getText().toString().isEmpty() && !Finals.getText().toString().isEmpty()){

                            name = studentName.getText().toString();
                            prelimG = Double.parseDouble(Prelim.getText().toString());
                            midtermG = Double.parseDouble(Midterm.getText().toString());
                            finalG = Double.parseDouble(Finals.getText().toString());
                            double averageG = average(prelimG, midtermG, finalG);
                            DecimalFormat df = new DecimalFormat("#.##"); // Format to two decimal places
                            double equi = equivalent(averageG);
                            String remarks = Remark(equi);

                            try{
                                if((prelimG <= 100 && prelimG >= 0 ) && (midtermG <= 100 && midtermG >= 0 ) && (finalG <= 100 && finalG >= 0 ) ){
                                    tvStudentName.setText(name);
                                    tvSemGrade.setText(df.format(averageG));
                                    tvPEquivalent.setText(String.valueOf(equi));
                                    tvRemarks.setText(remarks);
                                }else{
                                    tvRemarks.setTextColor(Color.BLACK);
                                    builder.setTitle("Alert").setMessage("Enter value from 1 - 100 only!");
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.dismiss();
                                            clearET();
                                            studentName.setText(name);
                                        }
                                    });
                                    builder.setCancelable(false);
                                    AlertDialog dialog1 = builder.create();
                                    dialog1.show();
                                }
                            }catch (Exception e){
                            }

                        }else{
                            builder.setTitle("Alert").setMessage("Please enter all necessary details to compute");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                            builder.setCancelable(false);
                            AlertDialog dialog2 = builder.create();
                            dialog2.show();
                        }                        }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
    public void clearET(){
        studentName.setText("");
        Prelim.setText("");
        Midterm.setText("");
        Finals.setText("");

        Prelim.requestFocus();
    }
    public void clearTv(){
        tvStudentName.setText("SN");
        tvSemGrade.setText("SB");
        tvPEquivalent.setText("PE");
        tvRemarks.setText("Remark");
    }

    public void init(){

        tvStudentName = findViewById(R.id.tvSNDisp);
        tvSemGrade = findViewById(R.id.tvSGDisp);
        tvPEquivalent = findViewById(R.id.tvPEDisp);
        tvRemarks = findViewById(R.id.tvRemarksDisp);
        studentName = findViewById(R.id.etStudentName);
        Prelim = findViewById(R.id.etPrelim);
        Midterm = findViewById(R.id.etMidterm);
        Finals = findViewById(R.id.etFinal);
        btnCompute = findViewById(R.id.btnCompute);
        btnNewEnt = findViewById(R.id.btnNewEnt);
    }
}