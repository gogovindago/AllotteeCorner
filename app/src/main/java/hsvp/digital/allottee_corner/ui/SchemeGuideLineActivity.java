package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.schemeGuidelineAdapter;
import hsvp.digital.allottee_corner.databinding.ActivitySchemeguidelineBinding;
import hsvp.digital.allottee_corner.model.SchemeGuideLinemodel;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class SchemeGuideLineActivity extends BaseActivity implements  schemeGuidelineAdapter.ItemListener {

    ActivitySchemeguidelineBinding binding;
    ArrayList<SchemeGuideLinemodel> SchemeGuidearrayList = new ArrayList<SchemeGuideLinemodel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_schemeguideline);

        /*Post Matric Scholarship SC Guidelines w.e.f 2020-21
Post Matric Scholarship OBC Guidelines w.e.f Sept, 2018
Consolidate Stipend and Free Books to SC Students Scheme
Haryana State Meritorious Incentive Scheme
Haryana State Meritorious Incentives Scheme (CBSE)
State Merit Scholarship To UG Girls
State Merit Scholarship To UGPG Students
Stipend Scheme for Grand Children for Freedom Fighter
Lower Income Group Scheme*/
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(1, "Post Matric Scholarship SC Guidelines w.e.f 2020-21","https://harchhatravratti.highereduhry.ac.in/Notices/PMS%20SC%20Guidelines%20March2021.pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(2, "Post Matric Scholarship OBC Guidelines w.e.f Sept, 2018","https://harchhatravratti.highereduhry.ac.in/Notices/PMS%20OBC%20Guidelines%20March2021.pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(3, "Consolidate Stipend and Free Books to SC Students Scheme","https://harchhatravratti.highereduhry.ac.in/Notices/Consolidate%20Stipend%20and%20Free%20Books%20to%20SC%20Students%20Scheme.pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(4, "Haryana State Meritorious Incentive Scheme","https://harchhatravratti.highereduhry.ac.in/Notices/Haryana%20State%20Meritorious%20Incentive%20Scheme.pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(5, "Haryana State Meritorious Incentives Scheme (CBSE)","https://harchhatravratti.highereduhry.ac.in/Notices/Haryana%20State%20Meritorious%20Incentives%20Scheme%20(CBSE).pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(6, "State Merit Scholarship To UG Girls","https://harchhatravratti.highereduhry.ac.in/Notices/State%20Merit%20Scholarship%20To%20UG%20Girls.pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(7, "State Merit Scholarship To UGPG Students","https://harchhatravratti.highereduhry.ac.in/Notices/State%20Merit%20Scholarship%20To%20UGPG%20Students.pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(8, "Stipend Scheme for Grand Children for Freedom Fighter","https://harchhatravratti.highereduhry.ac.in/Notices/Stipend%20Scheme%20for%20Grand%20Children%20for%20Freedom%20Fighter.pdf"));
        SchemeGuidearrayList.add(new SchemeGuideLinemodel(9, "Lower Income Group Scheme","https://harchhatravratti.highereduhry.ac.in/Notices/Lower%20Income%20Group%20Scheme.pdf"));


        schemeGuidelineAdapter adaptermain = new schemeGuidelineAdapter(this, SchemeGuidearrayList, this);
        binding.rv.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rv.setLayoutManager(manager);


    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Scheme GuideLine");
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
    public void onItemClick(SchemeGuideLinemodel item, int currposition) {


        Intent twitter = new Intent(this, OpenUrlActivity.class);
        twitter.putExtra("title", "Dhe,haryana ");
        twitter.putExtra("bookurl", item.salientfeatureUrl);
        startActivity(twitter);

    }


}