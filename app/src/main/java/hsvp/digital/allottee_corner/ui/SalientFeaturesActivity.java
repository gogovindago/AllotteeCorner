package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.SalientfeatureAdapter;
import hsvp.digital.allottee_corner.databinding.ActivitySalientfeaturesBinding;
import hsvp.digital.allottee_corner.model.Rvmodel;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class SalientFeaturesActivity extends BaseActivity implements SalientfeatureAdapter.ItemListener {

    ActivitySalientfeaturesBinding binding;
    ArrayList salientfeaturesarrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_salientfeatures);



        /*Common platform for all scholarships
One Time registration for all scholarships
Auto-populated data from Parivar Pehchan Patra
No Duplication of Application
User-friendly & Transparent system*/


        salientfeaturesarrayList.add(new Rvmodel(1, "Common platform for all scholarships"));
        salientfeaturesarrayList.add(new Rvmodel(2, "One Time registration for all scholarships"));
        salientfeaturesarrayList.add(new Rvmodel(3, "Auto-populated data from Parivar Pehchan Patra"));
        salientfeaturesarrayList.add(new Rvmodel(4, "No Duplication of Application"));
        salientfeaturesarrayList.add(new Rvmodel(5, "User-friendly & Transparent system"));


        SalientfeatureAdapter adaptermain = new SalientfeatureAdapter(this, salientfeaturesarrayList, this);
        binding.rv.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rv.setLayoutManager(manager);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Salient Features");
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

    @Override
    public void onItemClick(Rvmodel item, int currposition) {

    }
}