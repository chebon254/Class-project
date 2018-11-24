package com.kelvin.intense;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button songa,calling,messaging,mailing,camera,sharing, dialing,mpesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        songa = findViewById(R.id.btnmove);
        calling = findViewById(R.id.btncall);
        messaging = findViewById(R.id.btnsms);
        mailing = findViewById(R.id.btnmail);
        camera = findViewById(R.id.btncamera);
        sharing = findViewById(R.id.btnshare);
        dialing = findViewById(R.id.btndial);
        mpesa = findViewById(R.id.btnmpesa);

        songa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent piga = new Intent(Intent.ACTION_CALL);
                piga.setData(Uri.parse("tel:0720326791"));
                startActivity(piga);
            }
        });
        messaging.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                Uri tumasms = Uri.parse("tel:0720326791");
                Intent sms = new Intent(Intent.ACTION_VIEW,tumasms);
                sms.putExtra("sms_body","Niaje brathe");
                sms.setType("vnd.android-dir/mms-sms");
                startActivity(sms);
            }
        });
        mailing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = SecondActivity.this;
                ShareCompat.IntentBuilder.from(activity).
                        setType("message/rfc822").
                        addEmailTo("kelvinchebon90@gmail.com").
                        setSubject("Job application").
                        setText("Niaje bro").
                        setChooserTitle("Sending mail").
                        startChooser();
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePic,100);
            }
        });
        sharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"Download app on www.abc.com");
                share.setType("text/plain");
                startActivity(share);
            }
        });
                dialing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent piga = new Intent(Intent.ACTION_DIAL);
                        piga.setData(Uri.parse("tel:"));
                        startActivity(piga);
                    }
                });
                mpesa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent pesa = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                        if(pesa !=null){
                            startActivity(pesa);
                        }else{
                            Toast.makeText(SecondActivity.this, "No STK found", Toast.LENGTH_SHORT).show();
                        }

                    }

                });

       }
}