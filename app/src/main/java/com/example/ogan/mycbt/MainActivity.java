package com.example.ogan.mycbt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view){
        calculateScore();
        displayScore();
        score = 0;
    }

    public void displayScore(){
        EditText editText = (EditText) findViewById(R.id.your_name);
        String  name = editText.getText().toString();
        Toast.makeText(getApplicationContext(),"Hello " + name +", your score is " + score, Toast.LENGTH_LONG).show();

    }

    public void calculateScore(){
        RadioButton answer1 =(RadioButton) findViewById(R.id.question1);
        RadioButton answer2 = (RadioButton) findViewById(R.id.question2);
        RadioButton answer3 = (RadioButton) findViewById(R.id.question3);
        RadioButton answer4 = (RadioButton) findViewById(R.id.question4);
        RadioButton answer5 = (RadioButton) findViewById(R.id.question5);
        if(answer1.isChecked()){
            score = score + 5;
        }
        if (answer2.isChecked()){
            score = score + 5;
        }
        if (answer3.isChecked()){
            score = score + 5;
        }
        if (answer4.isChecked()){
            score = score + 5;
        }
        if(answer5.isChecked()){
            score = score + 5;
        }

    }

    public void emailScore(View view){
        calculateScore();
        EditText editText = (EditText) findViewById(R.id.your_name);
        String  name = editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "My CBT score");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello " + name +", your score is " + score);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        score = 0;
    }
}
