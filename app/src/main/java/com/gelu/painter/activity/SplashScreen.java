package com.gelu.painter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.gelu.painter.R;
import com.gelu.painter.utility.TinyDB;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private SplashScreen splashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        splashScreen = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, 2000);
    }

    private void startApp() {
        if (new TinyDB(splashScreen).getBoolean(TinyDB.isLogin)) {
            startActivity(new Intent(splashScreen, HomeScreen.class));
            finish();
        } else {
            startActivity(new Intent(splashScreen, LoginScreen.class));
            finish();
        }
    }
}
