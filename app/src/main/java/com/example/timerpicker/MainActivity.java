package com.example.timerpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView nowtimeTextview;
    TextView selectTimeTextview;
    Button timeButton;
    int hour, minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeButton = findViewById(R.id.timeButton);
        nowtimeTextview = findViewById(R.id.nowTimeTextview);
        selectTimeTextview = findViewById(R.id.selectTimeTextview);
        setNowTime();

    }

    private void setNowTime() {
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        //Date currentTime = Calendar.getInstance().getTime();
        nowtimeTextview.setText("Now: " + String.format(String.valueOf(currentTime)));

    }

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectMinute) {

                hour = selectedHour;
                minute = selectMinute;

                selectTimeTextview.setText("Select Time: " + String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}