package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.deptOnBoardAdapter;
import hsvp.digital.allottee_corner.databinding.ActivityDeptonboardBinding;
import hsvp.digital.allottee_corner.model.Rvmodel;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class DeptOnBoardActivity extends BaseActivity implements deptOnBoardAdapter.ItemListener {

    ActivityDeptonboardBinding binding;
    ArrayList salientfeaturesarrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deptonboard);


        /*Department of Higher Education, Haryana
Department of Technical Education, Haryana
Department of Animal Husbandry & Dairying, Haryana
Department of Medical Education & Research, Haryana
Department of Skill & Industrial Training, Haryana*/
        salientfeaturesarrayList.add(new Rvmodel(1, "Department of Higher Education, Haryana"));
        salientfeaturesarrayList.add(new Rvmodel(2, "Department of Technical Education, Haryana"));
        salientfeaturesarrayList.add(new Rvmodel(3, "Department of Medical Education & Research, Haryana"));
        salientfeaturesarrayList.add(new Rvmodel(4, "Department of Animal Husbandry & Dairying, Haryana"));
        salientfeaturesarrayList.add(new Rvmodel(5, "Department of Skill & Industrial Training, Haryana"));


        deptOnBoardAdapter adaptermain = new deptOnBoardAdapter(this, salientfeaturesarrayList, this);
        binding.rv.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rv.setLayoutManager(manager);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Department On Board");
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