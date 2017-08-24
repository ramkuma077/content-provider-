package com.example.neeraj.contentprovider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    EditText E,E2;
    TextView T;
    Button B;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        E=(EditText)findViewById(R.id.E);
        E2=(EditText)findViewById(R.id.E2);
        T=(TextView)findViewById(R.id.T);
        B=(Button)findViewById(R.id.B3);

        sharedPreferences=getSharedPreferences("SpDemo",MODE_PRIVATE);
        String un=sharedPreferences.getString("key1","");
        String up=sharedPreferences.getString("key2","");
        E.setText(un);
        E2.setText(up);




        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Intent intent=new Intent(profile.this,login.class);
                startActivity(intent);
            }

        });
    }

    }
