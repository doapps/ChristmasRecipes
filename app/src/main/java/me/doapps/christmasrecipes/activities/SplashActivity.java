package me.doapps.christmasrecipes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import me.doapps.christmasrecipes.R;
import me.doapps.christmasrecipes.utils.UtilFonts;

/**
 * Created by jonathan on 23/11/2014.
 */
public class SplashActivity extends ActionBarActivity {
    private TextView txt_title_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        txt_title_splash = (TextView)findViewById(R.id.txt_title_splash);
        txt_title_splash.setTypeface(UtilFonts.setHollyBerry(this));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
