package com.houxxam.gdpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gdpr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdpr);


        getWindow().setBackgroundDrawable(new ColorDrawable(0));



        //privacy policy
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", false);
            if (isFirstRun) {
                startActivity(new Intent(Gdpr.this, MainActivity.class));
            }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", true).apply();




        Button btn_ok = findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);

                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).apply();
                finish();
            }
        });

        TextView btn_exit = findViewById(R.id.btn_exit);

        btn_exit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                finishAffinity();

            }
        });
        TextView btnPrivacyPolicy = findViewById(R.id.btn_privacypolicy);
        btnPrivacyPolicy.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String url = "https://www.freeprivacypolicy.com/";  /// site privacy policy
                final Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
    public void onBackPressed() {
        finishAffinity();
    }
}




