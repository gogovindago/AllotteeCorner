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
    String role, auth_key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.logo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Intent i = new Intent(SplashActivity.this, CourseListActivity.class);
                //Intent i = new Intent(SplashActivity.this, HowtoApplyActivity.class);
                // Intent i = new Intent(SplashActivity.this, EligibilityActivity.class);
                //  Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);

                //Intent i = new Intent(SplashActivity.this, MainActivity.class);
                // Intent i = new Intent(SplashActivity.this, TrackingAppTestingActivity.class);
                // startActivity(i);
                //  finish();




                /*
        if (role.equalsIgnoreCase("NodalBody")) {
            arrayList.add(new OptionDataModel(R.string.Dashboard, R.drawable.ic_baseline_dashboard_24, 1004, "#FFFFFF"));

        }
        if (role.equalsIgnoreCase("College")) {
            arrayList.add(new OptionDataModel(R.string.Dashboard, R.drawable.ic_baseline_dashboard_24, 1003, "#FFFFFF"));

        }
        if (role.equalsIgnoreCase("NodalBodyDHE")) {
            arrayList.add(new OptionDataModel(R.string.Dashboard, R.drawable.ic_baseline_dashboard_24, 1002, "#FFFFFF"));

        }
        if (role.equalsIgnoreCase("department")) {
            arrayList.add(new OptionDataModel(R.string.Dashboard, R.drawable.ic_baseline_dashboard_24, 1000, "#FFFFFF"));

        }

        if (role.equalsIgnoreCase("masteradmin")) {
            arrayList.add(new OptionDataModel(R.string.Dashboard, R.drawable.ic_baseline_dashboard_24, 1001, "#FFFFFF"));

        }*/


                role = CSPreferences.readString(SplashActivity.this, "UserType");

                if (role.equalsIgnoreCase("department") || role.equalsIgnoreCase("masteradmin")) {

                    auth_key = CSPreferences.readString(SplashActivity.this, "department_Id");

                } else if (role.equalsIgnoreCase("NodalBodyDHE")) {
                    auth_key = CSPreferences.readString(SplashActivity.this, "nodalBody_Id");


                } else if (role.equalsIgnoreCase("College")) {
                    auth_key = CSPreferences.readString(SplashActivity.this, "collegeId");


                } else if (role.equalsIgnoreCase("NodalBody")) {
                    auth_key = CSPreferences.readString(SplashActivity.this, "nodalBody_Id");


                } else {
                    auth_key = CSPreferences.readString(SplashActivity.this, "userid");

                }

                if (!auth_key.isEmpty()) {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    /// Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                    //Intent i = new Intent(SplashActivity.this, ApplyScholarshipActivity.class);
                    //Intent i = new Intent(SplashActivity.this, RegistrationActivity.class);
                    // Intent i = new Intent(SplashActivity.this, DashboardActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        }, splashTimeOut);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
        logo.startAnimation(myanim);
    }
}
