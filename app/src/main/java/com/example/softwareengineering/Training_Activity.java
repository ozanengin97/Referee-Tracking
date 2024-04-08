package com.example.softwareengineering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class Training_Activity extends AppCompatActivity {

    timer second; //Global olarak nesne oluşturduk
    TextView timer;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_);

        timer = (TextView)findViewById(R.id.timer);


        second=new timer(10000000,1000); //(ne kadar sürecek,hızı ne olacak)
        i=0;
       // t.start(); //ile timer çalışacak

    }

    class timer extends CountDownTimer {
        public timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) { //metodu ile ne yapacağını yazıcaz,sayaç çalıştıkça çalışan metod
            i++;
            //System.out.println(i);
            timer.setText(String.valueOf(i));
        }

        @Override
        public void onFinish() { //sayma işlemi bittiğinde
            //System.out.println("sayma işlemi bitti");
            second.start(); //durduğunda tekrar çalışsın
        }
    }
    public void stop(View view)
    {
        second.cancel();
    }
    public void start(View view)
    {
        second=new timer(10000,1000);
        i = 0;
        second.start();
    }
    public void myTrainings(View view)
    {
        Intent intent = new Intent(this,myTraining_Activity.class);
        startActivity(intent);
    }
    public void userDetails(View view)
    {
        Intent intent = new Intent(this,User_Details_Activity.class);
        startActivity(intent);
    }
}