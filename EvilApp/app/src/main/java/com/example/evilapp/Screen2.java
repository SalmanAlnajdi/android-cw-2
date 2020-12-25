package com.example.evilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);


        Button back = findViewById(R.id.back);//The port to go back

        Bundle a = getIntent().getExtras();  //airport

        //pakage
        String  name = a.getString("name");
        String email = a.getString("email");
        String phone = a.getString("phone");
        String address = a.getString("address");

        TextView app = findViewById(R.id.evilApp);
        TextView n = findViewById(R.id.name1);
        TextView e = findViewById(R.id.email1);
        TextView p = findViewById(R.id.phone1);
        TextView ad = findViewById(R.id.address1);

        //to call the user number
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ phone));
                startActivity(callIntent);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent em = new Intent(Intent.ACTION_SEND);
                em.putExtra(Intent.EXTRA_EMAIL, email);
                em.putExtra(Intent.EXTRA_SUBJECT,"Evil App");
                em.putExtra(Intent.EXTRA_TEXT,"Thank your for submitting in our application");
                em.setType("text/plain");

                startActivity(Intent.createChooser(em,"Send email:"));
            }
        });

        // show time
        app.setText("Welcome "+ name + " to Evil App");
        n.setText(name);
        e.setText(email);
        p.setText(phone);
        ad.setText(address);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s2 = new Intent(Screen2.this,MainActivity.class);
                startActivity(s2);
            }
        });
    }
}