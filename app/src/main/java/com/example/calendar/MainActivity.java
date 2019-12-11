package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private Button ChooseStartDate;
    private Button ChooseEndDate;
    private CalendarView StartDateCalendar;
    private CalendarView EndtDateCalendar;
    private Button BtnOK;
    private long StartDate;
    private String StartDateTxt;
    private long EndDate;
    private String EndDateTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        ChooseStartDate = findViewById(R.id.chooseStartDate);
        ChooseEndDate = findViewById(R.id.chooseEndDate);
        StartDateCalendar = findViewById(R.id.startDateCalendar);
        EndtDateCalendar = findViewById(R.id.endtDateCalendar);
        BtnOK = findViewById(R.id.btnOK);

        ChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartDateCalendar.setVisibility(View.VISIBLE);
                EndtDateCalendar.setVisibility(View.GONE);
            }
        });

        ChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EndtDateCalendar.setVisibility(View.VISIBLE);
                StartDateCalendar.setVisibility(View.GONE);
            }
        });

        StartDateCalendar.setVisibility(View.GONE);
        EndtDateCalendar.setVisibility(View.GONE);

        StartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                StartDateTxt = year+"-"+month+"-"+dayOfMonth;
                ChooseStartDate.setText(getString(R.string.txtStart)+ StartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, month, dayOfMonth);
                StartDate = gregorianCalendar.getTimeInMillis();
                StartDateCalendar.setVisibility(View.GONE);
            }
        });


        EndtDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                EndDateTxt = year+"-"+month+"-"+dayOfMonth;
                ChooseEndDate.setText(getString(R.string.txtStop)+ EndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(year, month, dayOfMonth);
                EndDate = gregorianCalendar.getTimeInMillis();
                EndtDateCalendar.setVisibility(View.GONE);
            }
        });

        BtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (StartDate > EndDate){
                    Toast.makeText(MainActivity.this, getString(R.string.txtinform), Toast.LENGTH_LONG).show();
                    ChooseStartDate.setText(R.string.txtStart);
                    ChooseEndDate.setText(R.string.txtStop);
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.txtstart) + StartDateTxt + getString(R.string.txtkon) + EndDateTxt, Toast.LENGTH_LONG).show();
                }
            }
        });
    }




}
