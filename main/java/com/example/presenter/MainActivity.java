package com.example.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void saveCode(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, chooseActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText1);
        String code = editText.getText().toString();
        intent.putExtra("e", code);
        if (!Objects.equals(code, ""))
            startActivity(intent);
    }
}
