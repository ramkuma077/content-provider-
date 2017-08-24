package com.example.neeraj.contentprovider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class splash extends AppCompatActivity {
    ProgressDialog pro;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        pro = new ProgressDialog(splash.this);
        pro.setTitle("Welcome");
        pro.setMessage("wait");
        pro.show();

        sharedPreferences=getSharedPreferences("SpDemo",MODE_PRIVATE);

        final String un=sharedPreferences.getString("key1","");


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                pro.dismiss();


                if(un.isEmpty()){
                    Intent i = new Intent(splash.this,login.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(splash.this,profile.class);
                    startActivity(i);
                }


            }


        });

        thread.start();


}
}




