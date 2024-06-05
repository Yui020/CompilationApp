package com.example.mycompilation.MachineAct;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mycompilation.R;

import java.util.ArrayList;
import java.util.List;

public class SixthMachineAct extends AppCompatActivity {

    private Spinner employeeID, employeePosition, employeeDaysWorked;
    private TextView employeeName;
    private RadioGroup status;
    private RadioButton single, married, widowed;
    private Button compute, clear, back;
    private ArrayList<String> emp_id, emp_name, emp_position, emp_days_worked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_machine);

        // Initializing ArrayLists
        emp_id = new ArrayList<>();
        emp_name = new ArrayList<>();
        emp_position = new ArrayList<>();
        emp_days_worked = new ArrayList<>();

        employeeID = findViewById(R.id.id_spinner);
        employeePosition = findViewById(R.id.position_spinner);
        employeeDaysWorked = findViewById(R.id.days_worked_spinner);
        employeeName = findViewById(R.id.display_employee_name);
        status = findViewById(R.id.rdg_status);
        single = findViewById(R.id.rdb_single);
        married = findViewById(R.id.rdb_married);
        widowed = findViewById(R.id.rdb_widowed);
        compute = findViewById(R.id.btn_compute);
        clear = findViewById(R.id.btn_clear);

        back = findViewById(R.id.btn_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        status.check(single.getId());
        if (getIntent().getBooleanExtra("CLEAR_SELECTION", false)) {
            clearSelection();
        }

        // Initialize lists in employee ids
        emp_id.add("EMP0001");
        emp_id.add("EMP0002");
        emp_id.add("EMP0003");
        emp_id.add("EMP0004");
        emp_id.add("EMP0005");

        // Initialize lists in employee names
        emp_name.add("Elgin");
        emp_name.add("Leila");
        emp_name.add("Jenny");
        emp_name.add("Claire");
        emp_name.add("Faith");

        // Initialize lists in position codes
        emp_position.add("A");
        emp_position.add("B");
        emp_position.add("C");

        // Create a loop to initialize lists in number of days
        for (int i = 0; i <= 31; i++) {
            emp_days_worked.add(String.valueOf(i));
        }


        // Call methods
        loadSpinnerData(employeeID, emp_id);
        loadSpinnerData(employeePosition, emp_position);
        loadSpinnerData(employeeDaysWorked, emp_days_worked);

        // Set listeners
        employeeID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedEmployeeId = employeeID.getSelectedItem().toString();
                String selectedEmployeeName = emp_name.get(position);
                employeeName.setText(selectedEmployeeName);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String selectedEmployeeID = employeeID.getSelectedItem().toString();
                String selectedEmployeeName = employeeName.getText().toString();
                String selectedPosition = employeePosition.getSelectedItem().toString();
                RadioButton selectedButton = findViewById(status.getCheckedRadioButtonId());
                String selectedEmployeeStatus = selectedButton.getText().toString();

                int selectedDaysWorked = Integer.parseInt(employeeDaysWorked.getSelectedItem().toString());

                Intent intent = new Intent(SixthMachineAct.this, ComputeActivity.class);
                intent.putExtra("EMPLOYEE_ID", selectedEmployeeID);
                intent.putExtra("EMPLOYEE_NAME", selectedEmployeeName);
                intent.putExtra("EMPLOYEE_POSITION", selectedPosition);
                intent.putExtra("EMPLOYEE_STATUS", selectedEmployeeStatus);
                intent.putExtra("DAYS_WORKED", selectedDaysWorked);
                startActivity(intent);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelection();
            }
        });
    }

    // Method to load data in spinners
    public void loadSpinnerData(Spinner spinner, List<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    // Method to clear selections
    public void clearSelection() {

        status.clearCheck();
        status.check(single.getId());
        employeeID.setSelection(0);
        employeePosition.setSelection(0);
        employeeDaysWorked.setSelection(0);
    }
}
