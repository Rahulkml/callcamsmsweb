package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button cam,smss,webb,calll;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cam=(Button) findViewById(R.id.b1);
        smss=(Button) findViewById(R.id.b2);
        webb=(Button) findViewById(R.id.b4);
        calll=(Button) findViewById(R.id.b3);
        editText = (EditText)findViewById(R.id.e1);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CaM = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(CaM);
            }
        });
        smss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editText.getText().toString();
                Intent SmS = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ result));
                startActivity(SmS);
            }
        });
        webb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Web = new Intent();
                Web.setAction(Intent.ACTION_VIEW);
                Web.addCategory(Intent.CATEGORY_BROWSABLE);
                Web.setData(Uri.parse("http://www.google.com"));
                startActivity(Web);
            }
        });
        calll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" +result));
                startActivity(intent);
            }
        });


    }


}
