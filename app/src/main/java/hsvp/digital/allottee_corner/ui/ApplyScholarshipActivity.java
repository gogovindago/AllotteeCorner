package hsvp.digital.allottee_corner.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import hsvp.digital.allottee_corner.R;
import hsvp.digital.allottee_corner.adapter.RvSchemeTypeFromApiAdapter;
import hsvp.digital.allottee_corner.allinterface.GetScholarshipListData_interface;
import hsvp.digital.allottee_corner.apicall.WebAPiCall;
import hsvp.digital.allottee_corner.databinding.ActivityApplyScholarshipBinding;
import hsvp.digital.allottee_corner.model.GetScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.utility.BaseActivity;
import hsvp.digital.allottee_corner.utility.GlobalClass;

public class ApplyScholarshipActivity extends BaseActivity implements GetScholarshipListData_interface {

    RadioGroup btnRadiogroup;
    RadioButton checkedRadioButton;
    ActivityApplyScholarshipBinding binding;
    List<GetScholarshipSchemesResponse.Datum> ScholarshipSchemesList = new ArrayList<GetScholarshipSchemesResponse.Datum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_apply_scholaership);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apply_scholarship);

        if (GlobalClass.isNetworkConnected(ApplyScholarshipActivity.this)) {

            WebAPiCall aPiCall = new WebAPiCall();
            aPiCall.GetScholarshipSchemesListDataMethod(ApplyScholarshipActivity.this, ApplyScholarshipActivity.this, ApplyScholarshipActivity.this);

        } else {

            Toast.makeText(ApplyScholarshipActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

/*

        btnRadiogroup = (RadioGroup) findViewById(R.id.btnRadiogroup);
        checkedRadioButton = (RadioButton) btnRadiogroup.findViewById(btnRadiogroup.getCheckedRadioButtonId());

        btnRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) btnRadiogroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable

                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...llCollegestudent
                if (isChecked) {
                    // Changes the textview's text to "Checked: example radiobutton text"
                    switch (checkedId) {

                        case R.id.utypeStudent:

                            if (GlobalClass.isNetworkConnected(ApplyScholarshipActivity.this)) {


                            } else {

                                Toast.makeText(ApplyScholarshipActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                            }


                            break;

                        case R.id.utypeOthers:


                            if (GlobalClass.isNetworkConnected(ApplyScholarshipActivity.this)) {
                                WebAPiCall aPiCall = new WebAPiCall();


                            } else {

                                Toast.makeText(ApplyScholarshipActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                            }


                            break;

                        case R.id.faculty:


                            if (GlobalClass.isNetworkConnected(ApplyScholarshipActivity.this)) {
                                WebAPiCall aPiCall = new WebAPiCall();


                            } else {

                                Toast.makeText(ApplyScholarshipActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                            }


                            break;

                    }
                    Toast.makeText(ApplyScholarshipActivity.this, checkedRadioButton.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });
*/


        String text = "2. Please Check the Scheme Eligibility Here before proceeding.";
        SpannableString spannableString = new SpannableString(text);


        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(ApplyScholarshipActivity.this, EligibilityActivity.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                // ds.setUnderlineText(false);
            }
        };


        spannableString.setSpan(clickableSpan3, 20, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.txteligibility.setText(spannableString);
        binding.txteligibility.setMovementMethod(LinkMovementMethod.getInstance());
        binding.txteligibility.setHighlightColor(Color.TRANSPARENT);

    }


    @Override
    public void initData() {
        binding.toolbar.tvToolbarTitle.setText("Apply Scholarship");
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
    public void GetScholarshipListData(List<GetScholarshipSchemesResponse.Datum> list) {


        ScholarshipSchemesList.clear();
        ScholarshipSchemesList.addAll(list);


        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        binding.rvscholarshiptypes.setLayoutManager(recyclerLayoutManager);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(binding.rvscholarshiptypes.getContext(),
                        recyclerLayoutManager.getOrientation());
        binding.rvscholarshiptypes.addItemDecoration(dividerItemDecoration);


        RvSchemeTypeFromApiAdapter recyclerViewAdapter = new
                RvSchemeTypeFromApiAdapter(ScholarshipSchemesList, this);
        binding.rvscholarshiptypes.setAdapter(recyclerViewAdapter);


    }
}