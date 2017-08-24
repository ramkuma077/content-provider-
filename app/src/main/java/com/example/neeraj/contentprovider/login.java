package com.example.neeraj.contentprovider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {
    TextView T,T2;
    EditText E,E2;
    Button B;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        T=(TextView)findViewById(R.id.T);
        T2=(TextView)findViewById(R.id.T2);
        E=(EditText)findViewById(R.id.lE);
        B=(Button)findViewById(R.id.B);
        E2=(EditText)findViewById(R.id.lE2);
        sharedPreferences=getSharedPreferences("SpDemo",MODE_PRIVATE);
        String un=sharedPreferences.getString("key1","");
                String up=sharedPreferences.getString("key2","");
       // E.setText(un);
        //E2.setText(up);



        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=E.getText().toString();
                String pass=E2.getText().toString();
                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putString("key1",user);
                editor.putString("key2",pass);
                editor.commit();
                Intent intent=new Intent(login.this,profile.class);
                startActivity(intent);
            }
        });

    }
}
