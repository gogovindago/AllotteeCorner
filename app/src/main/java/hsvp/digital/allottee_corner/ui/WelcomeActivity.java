package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.databinding.ActivityWelcomeBinding;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.CSPreferences;

public class WelcomeActivity extends BaseActivity {
    ActivityWelcomeBinding binding;
    String SelectedLanguage = "en";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
    }


    @Override
    public void initData() {

    }

    @Override
    public void initListeners() {


        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlogin = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intentlogin);
                finish();

            }
        });

        binding.btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        binding.btnAppStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentStatus = new Intent(WelcomeActivity.this, CheckApplicatioStatusActivity.class);
                startActivity(intentStatus);


            }
        });




    }


}