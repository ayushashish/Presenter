package com.example.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class openSystemControls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_system_controls);
        String value = getIntent().getStringExtra("e");
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView4);
        textView.setText(value);
    }
    public void logOut(View view){
        //code for logout here
        TextView textView=findViewById(R.id.textView5);
        textView.setText("You're logged out of your computer!");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        TextView textView1 = findViewById(R.id.textView4);
        String value_x = textView1.getText().toString();
        DatabaseReference myRef = database.getReference(value_x);
        myRef.setValue("42");
    }
    public void shutDown(View view){
        //code for shut down here
        TextView textView=findViewById(R.id.textView5);
        textView.setText("Shutting down your computer!");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        TextView textView1 = findViewById(R.id.textView4);
        String value_x = textView1.getText().toString();
        DatabaseReference myRef = database.getReference(value_x);
        myRef.setValue("43");
    }
    public void restart(View view){
        //code for restart here
        TextView textView=findViewById(R.id.textView5);
        textView.setText("Restarting your computer!");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        TextView textView1 = findViewById(R.id.textView4);
        String value_x = textView1.getText().toString();
        DatabaseReference myRef = database.getReference(value_x);
        myRef.setValue("44");
    }
}
