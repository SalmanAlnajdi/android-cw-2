package com.example.evilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import static com.example.evilapp.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);


        final ProgressBar Pbar = findViewById(R.id.progressBar);
        final EditText n = findViewById(R.id.Name);
        final EditText e = findViewById(R.id.Email);
        final EditText p = findViewById(R.id.Phone);
        final EditText a = findViewById(R.id.address);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            private void run() {

            }

            private Intent s1;

            @Override
            public void onClick(View view) {

                Pbar.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                //Stop wait for 4 sec
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        Intent s1 = new Intent(MainActivity.this, Screen2.class); // this is my ticket XD
                        //package lines
                        String name = n.getText().toString(); //package 1
                        String email = e.getText().toString();//package 2
                        String phone = p.getText().toString();//package 3
                        String address = a.getText().toString();//package 3
                        //pull the package
                        s1.putExtra("name", name);
                        s1.putExtra("email", email);
                        s1.putExtra("phone", phone);
                        s1.putExtra("address",address);

                        startActivity(s1); // using my ticket <3 }
                    }
                }, 4000);//continue after 4 sec
            }

        });


    }
}