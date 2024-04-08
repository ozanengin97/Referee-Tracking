package com.example.softwareengineering;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class User_Details_Activity extends AppCompatActivity {

    TextView txt;

    //user info
    private EditText nameEditText,usernameEdittext,emailEditText,dateOfBirth,phoneNumber;
    private CheckBox maleCheckBox,femaleCheckBox;
    private String SEX;

    //date time picker
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private int year, month, dayOfMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__details_);

        nameEditText = findViewById(R.id.nameSurname);
        usernameEdittext = findViewById(R.id.username2);
        emailEditText = findViewById(R.id.userMail2);
        dateOfBirth = findViewById(R.id.selectDate);
        phoneNumber = findViewById(R.id.editTextPhone);
        maleCheckBox = findViewById(R.id.male_checkbox);
        femaleCheckBox = findViewById(R.id.female_checkbox);
    }

    public void male_checkbox(View view)
    {
        femaleCheckBox.setChecked(false);
        SEX = "Male";
    }
    public void female_checkbox(View view)
    {
        maleCheckBox.setChecked(false);
        SEX = "Female";
    }
    public void selectDate(View view) {
        dateOfBirth = findViewById(R.id.selectDate);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        dateOfBirth.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
}