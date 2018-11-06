package com.example.maria.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        TextView textView=(TextView) findViewById(R.id.menu_item_1);
        Log.i("EnterpriseActivity.java", textView.getText().toString());
        textView=(TextView) findViewById(R.id.menu_item_2);
        Log.i("EnterpriseActivity.java", textView.getText().toString());
        textView=(TextView) findViewById(R.id.menu_item_3);
        Log.i("EnterpriseActivity.java", textView.getText().toString());

    }
}