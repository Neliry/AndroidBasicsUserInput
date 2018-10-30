package com.example.maria.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioButtonGroup;
    LinearLayout questionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void check(View view){
        int mark=0;

        radioButtonGroup = (RadioGroup) findViewById(R.id.question_1_radio_group);
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);

//        Toast.makeText(this, idx+"", Toast.LENGTH_SHORT).show();
        if (idx==0){
            questionLayout=(LinearLayout)findViewById(R.id.question_1_layout);
            questionLayout.setBackground(getDrawable(R.drawable.right_border));
            mark++;
        }
        else
        {
            questionLayout=(LinearLayout)findViewById(R.id.question_1_layout);
            questionLayout.setBackground(getDrawable(R.drawable.wrong_border));
        }

        radioButtonGroup = (RadioGroup) findViewById(R.id.question_2_radio_group);
        radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        radioButton = radioButtonGroup.findViewById(radioButtonID);
        idx = radioButtonGroup.indexOfChild(radioButton);
        if (idx==1){
            questionLayout=(LinearLayout)findViewById(R.id.question_2_layout);
            questionLayout.setBackground(getDrawable(R.drawable.right_border));
            mark++;
        }
        else
        {
            questionLayout=(LinearLayout)findViewById(R.id.question_2_layout);
            questionLayout.setBackground(getDrawable(R.drawable.wrong_border));
        }

        CheckBox checkBox_3_2=(CheckBox) findViewById(R.id.question3_v2);
        CheckBox checkBox_3_4=(CheckBox) findViewById(R.id.question3_v4);
        CheckBox checkBox_3_5=(CheckBox) findViewById(R.id.question3_v5);

        if(checkBox_3_2.isChecked()&&checkBox_3_4.isChecked()&&checkBox_3_5.isChecked())
        {
            questionLayout=(LinearLayout)findViewById(R.id.question_3_layout);
            questionLayout.setBackground(getDrawable(R.drawable.right_border));
            mark++;
        }
            else
        {
            questionLayout=(LinearLayout)findViewById(R.id.question_3_layout);
            questionLayout.setBackground(getDrawable(R.drawable.wrong_border));
        }

        EditText question_4_editText=(EditText)findViewById(R.id.question_4_editText);
        if(question_4_editText.getText().toString().equals("Акатош")||question_4_editText.getText().toString().equals("акатош")){
            questionLayout=(LinearLayout)findViewById(R.id.question_4_layout);
            questionLayout.setBackground(getDrawable(R.drawable.right_border));
            mark++;
        }
        else
        {
            questionLayout=(LinearLayout)findViewById(R.id.question_4_layout);
            questionLayout.setBackground(getDrawable(R.drawable.wrong_border));
        }

        TextView textView=(TextView)findViewById(R.id.markView);

        textView.setText(mark+" / "+4);
    }
}
