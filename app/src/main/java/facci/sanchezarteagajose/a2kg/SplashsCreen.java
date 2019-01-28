package facci.sanchezarteagajose.a2kg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashsCreen extends Activity {
private final int DURANTION_SPLAIN=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new  Runnable() {
            @Override
            public void run() {

                        Intent intent = new Intent(SplashsCreen.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    },DURANTION_SPLAIN);
            }
        }

