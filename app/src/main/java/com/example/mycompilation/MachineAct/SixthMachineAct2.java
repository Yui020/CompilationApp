package com.example.mycompilation.MachineAct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;
import com.example.mycompilation.databinding.ActivitySixthMachineAct2Binding;
import com.example.mycompilation.databinding.ActivitySixthMachineBinding;

public class SixthMachineAct2 extends AppCompatActivity {
    private ActivitySixthMachineAct2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySixthMachineAct2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getEmployeeSetToDetails();
        backClicked();
    }
    public void getEmployeeSetToDetails(){
        Intent intent = getIntent();
        Employee employee = (Employee) intent.getSerializableExtra("Employee");

        if (employee != null) {
            binding.tvEmpID.setText(employee.getEmployeeID());
            binding.tvName.setText(employee.getEmployeeName());
            binding.tvPosCode.setText(employee.getPoscode());
            binding.tvCivilStatus.setText(employee.getEmployeeStatus());
            binding.tvDaysWorked.setText(employee.getEmployeeNumDaysWorked());
            binding.tvBasicPay.setText("Php " + String.format("%.2f", employee.getEmployeeBasPay()));
            binding.tvSSSContrib.setText("Php " + String.format("%.2f", employee.getEmployeeSSS()));
            binding.tvWithHolding.setText("Php " + String.format("%.2f", employee.getEmployeeWitTax()));
            binding.tvNetpay.setText("Php " + String.format("%.2f", employee.getNetPay()));
        }
    }
    public void backClicked(){
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}