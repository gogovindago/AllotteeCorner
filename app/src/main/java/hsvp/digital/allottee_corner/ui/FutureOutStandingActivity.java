package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.databinding.ActivityFutureoutstandingBinding;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class FutureOutStandingActivity extends BaseActivity {
    ActivityFutureoutstandingBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_futureoutstanding);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Allotee Future Schedule");
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