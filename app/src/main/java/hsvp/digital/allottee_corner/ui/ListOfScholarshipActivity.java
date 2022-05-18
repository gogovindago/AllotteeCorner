package hsvp.digital.allottee_corner.ui;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.schemedetailAdapter;
import hsvp.digital.allottee_corner.databinding.ActivityListofscholarshipBinding;
import hsvp.digital.allottee_corner.model.ListOfScholarshipDataModel;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class ListOfScholarshipActivity extends BaseActivity implements schemedetailAdapter.ItemListener {

    ActivityListofscholarshipBinding binding;

    ArrayList schemearrayList = new ArrayList();
    ArrayList DepartmentWithschemeList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_listofscholarship);


        schemearrayList.add(new ListOfScholarshipDataModel(1, "Post Matric Scholarship - SC", true, true, true, true, true));
        schemearrayList.add(new ListOfScholarshipDataModel(2, "Post Matric Scholarship - BC", true, true, true, true, true));
        schemearrayList.add(new ListOfScholarshipDataModel(3, "Stipend Scheme For SC", true, false, false, false, false));
        schemearrayList.add(new ListOfScholarshipDataModel(4, "Stipend Scheme\n For Grand Children of Freedom Fighters", true, false, false, false, false));
        schemearrayList.add(new ListOfScholarshipDataModel(5, "Free Books For SC Students", true, false, false, false, false));
        schemearrayList.add(new ListOfScholarshipDataModel(6, "State Merit Scholarship\n to UG Girls", true, false, false, false, false));
        schemearrayList.add(new ListOfScholarshipDataModel(7, "Haryana State Meritorious\n Incentives Scheme", true, false, false, false, false));
        schemearrayList.add(new ListOfScholarshipDataModel(8, "Haryana State Meritorious\n Incentives Scheme (CBSE)", true, false, false, false, false));
        schemearrayList.add(new ListOfScholarshipDataModel(9, "State Merit Scholarship\n To UG/PG Students", true, false, false, false, false));
        schemearrayList.add(new ListOfScholarshipDataModel(10, "Lower Income\n Group Scheme", true, false, false, false, false));


        schemedetailAdapter adaptermain = new schemedetailAdapter(this, schemearrayList, this);
        binding.rvdeptwithdata.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rvdeptwithdata.setLayoutManager(manager);



/*

        DepartmentWithschemeList.add(new ListOfDepartwithSchemevalueDataModel(111, "Department of Higher Education",
                true, true, true, true, true, true, true, true, true, true));

        DepartmentWithschemeList.add(new ListOfDepartwithSchemevalueDataModel(112, "Department of Technical Education",
                true, true, false, false, false, false, false, false, false, false));
        DepartmentWithschemeList.add(new ListOfDepartwithSchemevalueDataModel(113, "Department of Animal Husbandry & Dairying",
                true, true, false, false, false, false, false, false, false, false));

        DepartmentWithschemeList.add(new ListOfDepartwithSchemevalueDataModel(114, "Department of Medical Education & Research",
                true, true, false, false, false, false, false, false, false, false));
        DepartmentWithschemeList.add(new ListOfDepartwithSchemevalueDataModel(115, "Department of Animal Husbandry & Dairying",
                true, true, false, false, false, false, false, false, false, false));
*/


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("List of Scholarship");
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
    public void onItemClick(ListOfScholarshipDataModel item, int currposition) {

    }
}