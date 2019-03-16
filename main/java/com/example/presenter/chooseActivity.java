package com.example.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class chooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        String value = getIntent().getStringExtra("e");
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(value);
    }
    public void openPresentations(View view) {
        // Open presentations
        Intent intent = new Intent(this, openPresentations.class);
        TextView textView = findViewById(R.id.textView2);
        String code = textView.getText().toString();
        intent.putExtra("e", code);
        startActivity(intent);
    }
    public void openSystemControls(View view){
        // Open system controls
        Intent intent = new Intent(this, openSystemControls.class);
        TextView textView = findViewById(R.id.textView2);
        String code = textView.getText().toString();
        intent.putExtra("e", code);
        startActivity(intent);
    }
}
