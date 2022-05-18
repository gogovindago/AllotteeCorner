package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.schemeEligibityAdapter;
import hsvp.digital.allottee_corner.databinding.ActivityEligibilityBinding;
import hsvp.digital.allottee_corner.model.EligibilityModel;
import hsvp.digital.allottee_corner.utility.BaseActivity;

public class EligibilityActivity extends BaseActivity implements schemeEligibityAdapter.ItemListener {
    ActivityEligibilityBinding binding;
    ArrayList eligibilityarrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity__eligibility);

        eligibilityarrayList.add(new EligibilityModel("Post Matric Scholarship - SC",
                "Govt/Aided/SFC",
                "SC", "<= Rs. 2,50,000 Per annum",
                "Haryana", ">= 75%", "View", "https://harchhatravratti.highereduhry.ac.in/Notices/PMS%20SC%20Guidelines%20March2021.pdf", 1));

        eligibilityarrayList.add(new EligibilityModel("Post Matric Scholarship - BC",
                "Govt/Aided/SFC", "BC", "<= Rs. 2,50,000 Per annum",
                "Haryana", ">= 75%", "View", "https://harchhatravratti.highereduhry.ac.in/Notices/PMS%20OBC%20Guidelines%20March2021.pdf", 2));

        eligibilityarrayList.add(new EligibilityModel("CONSOL Stipend Scheme For SC",
                "Govt Only", "SC", "N/A", "Haryana", ">=60%", "View",
                "https://harchhatravratti.highereduhry.ac.in/Notices/Consolidate%20Stipend%20and%20Free%20Books%20to%20SC%20Students%20Scheme.pdf", 3));

        eligibilityarrayList.add(new EligibilityModel("CONSOL Stipend For Grand Children of Freedom Fighters (2010-11)",
                "Govt & Aided", "Any", "N/A", "Haryana", ">=50%", "View",
                "https://harchhatravratti.highereduhry.ac.in/Notices/Stipend%20Scheme%20for%20Grand%20Children%20for%20Freedom%20Fighter.pdf", 4));

        eligibilityarrayList.add(new EligibilityModel("Free Books For SC",
                "Govt Only", "SC", "N/A", "Haryana", "N/A", "View",
                "https://harchhatravratti.highereduhry.ac.in/Notices/State%20Merit%20Scholarship%20To%20UG%20Girls.pdf", 5));

        eligibilityarrayList.add(new EligibilityModel("Hry State Meritorious Incentives Scheme",
                "Govt Only", "General & SC", "N/A", "Haryana", "N/A", "View",
                "https://harchhatravratti.highereduhry.ac.in/Notices/Haryana%20State%20Meritorious%20Incentive%20Scheme.pdf", 6));


        eligibilityarrayList.add(new EligibilityModel("Hry State Meritorious Incentives Scheme (CBSE)",
                "Govt/Aided/SFC", "Any", "N/A", "Haryana", "N/A", "View",
                "https://harchhatravratti.highereduhry.ac.in/Notices/Haryana%20State%20Meritorious%20Incentives%20Scheme%20(CBSE).pdf", 7));


        eligibilityarrayList.add(new EligibilityModel("State Merit Scholarship To UG/PG Students",
                "Govt/Aided/SFC", "Any", "N/A", "Haryana", "N/A", "View",
                "https://harchhatravratti.highereduhry.ac.in/Notices/State%20Merit%20Scholarship%20To%20UGPG%20Students.pdf", 8));


        eligibilityarrayList.add(new EligibilityModel("Lower Income Group Scheme",
                "Govt/Aided/SFC", "Any", "<=Rs. 12,000 Per annum", "Haryana", "N/A", "View",
                "https://harchhatravratti.highereduhry.ac.in/Notices/Lower%20Income%20Group%20Scheme.pdf", 9));


        schemeEligibityAdapter adaptermain = new schemeEligibityAdapter(this, eligibilityarrayList, this);
        binding.rv.setAdapter(adaptermain);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        binding.rv.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(EligibilityModel item, int currposition) {

        // GlobalClass.showtost(this, item.Scheme);

        Intent fb = new Intent(this, OpenUrlActivity.class);
        fb.putExtra("title", item.Scheme);
        fb.putExtra("bookurl", item.GuidelineUrl);
        startActivity(fb);
    }

    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Scheme Eligibility");


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