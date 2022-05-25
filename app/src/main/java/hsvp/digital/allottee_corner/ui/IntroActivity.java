package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.databinding.ActivityIntroBinding;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class IntroActivity extends BaseActivity {

    ActivityIntroBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro);



    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("About Allottee Corner");
    }

    @Override
    public void initListeners() {

        binding.toolbar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

}