package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.databinding.ActivityContactUsBinding;
import hsvp.digital.allottee_corner.utility.BaseActivity;


public class ContactUsActivity extends BaseActivity implements View.OnClickListener {
    ActivityContactUsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_us);



        binding.toolbartxt2.setSelected(true);

        binding.fb.setOnClickListener(this);
        binding.twitter.setOnClickListener(this);
        binding.youtube.setOnClickListener(this);
        binding.instagram.setOnClickListener(this);


    }

    @Override
    public void initData() {

        binding.toolbartxt2.setText("                                       Contact Us                                      ");

    }

    @Override
    public void initListeners() {

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fb:

                Intent fb = new Intent(this, OpenUrlActivity.class);
                fb.putExtra("title", "Dhe,haryana ");
                fb.putExtra("bookurl", "https://www.facebook.com/pg/highereduhry/posts/?ref=page_internal");
                startActivity(fb);

                break;
            case R.id.twitter:
                Intent twitter = new Intent(this, OpenUrlActivity.class);
                twitter.putExtra("title", "Dhe,haryana ");
                twitter.putExtra("bookurl", "https://twitter.com/highereduHRY");
                startActivity(twitter);

                break;
            case R.id.instagram:
                Intent instagram = new Intent(this, OpenUrlActivity.class);
                instagram.putExtra("title", "Dhe,haryana ");
                instagram.putExtra("bookurl", "https://www.instagram.com/accounts/login/");
                startActivity(instagram);

                break;

            case R.id.youtube:
                Intent youtube = new Intent(this, OpenUrlActivity.class);
                youtube.putExtra("title", "Dhe,haryana ");
                youtube.putExtra("bookurl", "https://www.youtube.com/channel/UClnGVAjgb084SMNIYD1NTxA/featured");
                startActivity(youtube);

                break;


        }


    }
}