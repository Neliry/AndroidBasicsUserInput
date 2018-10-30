package com.example.maria.lesson_5_18;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textView= new TextView(this);
        textView.setText("Text");
        textView.setTextSize(100);
        textView.setTextColor(Color.RED);
        super.onCreate(savedInstanceState);
        setContentView(textView);
    }
}
