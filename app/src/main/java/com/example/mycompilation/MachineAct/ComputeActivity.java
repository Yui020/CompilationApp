package com.example.mycompilation.MachineAct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.mycompilation.R;

import org.w3c.dom.Text;

public class ComputeActivity extends AppCompatActivity {

    Button back;
    TextView ID, name, position, status, worked, basicPay, sss, tax, netPay;

    double rate_per_day = 0;
    double tax_rate = 0;
    double final_tax = 0;
    double basic_pay = 0;
    double sss_rate = 0;
    double sss_contribution = 0;
    double net_pay = 0;
    int daysWorked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);

        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ID = findViewById(R.id.display_id);
        name = findViewById(R.id.display_name);
        position = findViewById(R.id.display_position);
        status = findViewById(R.id.display_status);
        worked = findViewById(R.id.display_days_worked);
        basicPay = findViewById(R.id.display_basic_pay);
        sss = findViewById(R.id.display_sss);
        tax = findViewById(R.id.display_tax);
        netPay = findViewById(R.id.display_net_pay);

        //get values from lasst actiivty
        String employeeID = getIntent().getStringExtra("EMPLOYEE_ID");
        String employeeName = getIntent().getStringExtra("EMPLOYEE_NAME");
        String employeePosition = getIntent().getStringExtra("EMPLOYEE_POSITION");
        String employeeStatus = getIntent().getStringExtra("EMPLOYEE_STATUS");
        int daysWorked = getIntent().getIntExtra("DAYS_WORKED", 0);


        //switch case for rate per day
        switch (employeePosition){
            case "A":
                rate_per_day = 500;
                break;
            case "B":
                rate_per_day = 400;
                break;
            case "C":
                rate_per_day = 300;
                break;
        }
        //switch case for status
        switch (employeeStatus){
            case "Single":
                tax_rate = 0.10;
                break;
            case "Married":
                tax_rate = 0.05;
                break;
            case "Widowed":
                tax_rate = 0.05;
                break;
        }

        basic_pay = rate_per_day * daysWorked;

        //create if else for sss rate
        if (basic_pay >= 10000)         sss_rate = 0.07;
        else if (basic_pay >= 5000 && basic_pay <= 9999)sss_rate = 0.05;
        else if (basic_pay >= 1000 && basic_pay <= 4999)sss_rate = 0.03;
        else sss_rate = 0.01;

        sss_contribution = basic_pay * sss_rate;
        final_tax = basic_pay * tax_rate;
        net_pay = basic_pay - (sss_contribution + final_tax);


        //listeners
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ID.setText(employeeID);
        name.setText(employeeName);
        position.setText(employeePosition);
        status.setText(String.valueOf(employeeStatus));

        //convert to string
        worked.setText(String.valueOf(daysWorked));
        basicPay.setText(String.format("%,.2f",basic_pay));
        sss.setText(String.format("%,.2f",sss_contribution));
        tax.setText(String.format("%,.2f",final_tax));
        netPay.setText(String.format("%,.2f",net_pay));
    }
}