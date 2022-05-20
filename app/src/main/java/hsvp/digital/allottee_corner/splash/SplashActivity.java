package hsvp.digital.allottee_corner.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.ui.MainActivity;
import hsvp.digital.allottee_corner.ui.WelcomeActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;


public class SplashActivity extends AppCompatActivity {

    private static int splashTimeOut = 3000;
    private ImageView logo;
    String  auth_key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.logo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                auth_key = CSPreferences.readString(SplashActivity.this, "userid");

                if (!auth_key.isEmpty()) {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {

                    Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        }, splashTimeOut);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
        logo.startAnimation(myanim);
    }
}
