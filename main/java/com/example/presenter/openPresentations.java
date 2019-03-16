package com.example.presenter;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class openPresentations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_presentations);
        String value = getIntent().getStringExtra("e");
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView3);
        textView.setText(value);
    }
    public void startSlide(View view)
    {
        Chronometer simpleChronometer = findViewById(R.id.chronometer1); // initiate a chronometer
        simpleChronometer.setBase(SystemClock.elapsedRealtime());
        simpleChronometer.start(); // start a chronometer
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        TextView textView = findViewById(R.id.textView3);
        String value_x = textView.getText().toString();
        DatabaseReference myRef = database.getReference(value_x);
        myRef.setValue("0");
    }
    public void prevSlide(View view)
    {
        //previous slide code here
        TextView textView = findViewById(R.id.textView3);
        String value_x = textView.getText().toString();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference next=database.getReference(value_x);
        Random r = new Random();
        int val_next = r.nextInt(40 - 21) + 21;
        next.setValue(val_next);
    }
    public void nextSlide(View view)
    {
        //next slide code here
        TextView textView = findViewById(R.id.textView3);
        String value_x = textView.getText().toString();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference next=database.getReference(value_x);
        Random r = new Random();
        int val_next = r.nextInt(20 - 1) + 1;
        next.setValue(val_next);
        //textView.setText(val_next);
    }
    public void endSlide(View view)
    {
        Chronometer simpleChronometer=findViewById(R.id.chronometer1);
        simpleChronometer.stop();
        long time_elapsed = (SystemClock.elapsedRealtime() - simpleChronometer.getBase())/1000;
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        TextView textView = findViewById(R.id.textView3);
        String value_x = textView.getText().toString();
        DatabaseReference myRef_exit = database.getReference(value_x+"exit");
        myRef_exit.setValue(time_elapsed);
        DatabaseReference myRef_delete = database.getReference(value_x);
        myRef_delete.setValue("41");
    }
}