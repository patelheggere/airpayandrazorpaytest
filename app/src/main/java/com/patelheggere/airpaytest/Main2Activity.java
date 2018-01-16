package com.patelheggere.airpaytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {

    private Button air, razor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        air = findViewById(R.id.airpay);
        razor = findViewById(R.id.razorpay);
        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        razor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Main2Activity.this, RazorPay.class);
                startActivity(intent);
            }
        });
    }
}
